package com.isystk.sample.common.helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.common.dto.UploadFileDto;
import com.isystk.sample.common.exception.FileNotFoundException;
import com.isystk.sample.common.exception.SystemException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.FileUtils;
import com.isystk.sample.domain.dao.TImageDao;
import com.isystk.sample.domain.entity.TImage;

/**
 * ファイルアップロード
 */
@Component
public class FileHelper {

    @Value("${application.fileUploadLocation:#{systemProperties['java.io.tmpdir']}}") // 設定ファイルに定義されたアップロード先を取得する
    String fileUploadLocation;

    @Autowired
    TImageDao tImageDao;

    /**
     * ファイルの一覧を取得します。
     *
     * @param location
     * @return
     */
    public Stream<Path> listAllFiles(Path location) {
        try {
            return Files.walk(location, 1).filter(path -> !path.equals(location)).map(location::relativize);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to list uploadfiles. ", e);
        }
    }

    /**
     * ファイルを読み込みます。
     *
     * @param location
     * @param filename
     * @return
     */
    public Resource loadFile(Integer imageId) {
		// ディレクトリ
		String dir = getHash(imageId);
        Path location = Paths.get(fileUploadLocation, dir);
        try {

			// 保存するファイル名
			String saveFileName = imageId + ".jpg";

            Path file = location.resolve(dir).resolve(saveFileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            }

            throw new FileNotFoundException("could not read file. " + imageId);

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(
                    "malformed Url resource. [location=" + location.toString() + ", imageId=" + imageId + "]", e);
        }
    }

	/**
	 * ID生成
	 *
	 * @return 生成されたID
	 */
    private Integer generateID(int maxLength) {
		Integer id = 0;
		boolean loopFlg = true;

		do {
			id = Integer.valueOf(RandomStringUtils.randomNumeric(maxLength));

			// 生成したIDが存在しない場合、そのIDを返却する
			TImage tImage = tImageDao.selectById(id).orElse(null);

			if (tImage == null) {
				loopFlg = false;
			}
		} while (loopFlg);

		return id;
	}

	/**
	 * 画像IDからパスを表すハッシュを取得する。
	 *
	 * @param imgId
	 *            画像ID
	 * @return ハッシュ
	 */
	private String getHash(Integer imgId) {
		int h;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] d = md.digest(new DecimalFormat("00000000").format(imgId).getBytes());
			h = d[0];
			h += d[1] << 8;
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException(e);
		}
		Formatter f = new Formatter();
		f.format("/%02x/%02x/", (h & 0xff), ((h >> 8) & 0xff));
		return f.toString();
	}

    /**
     * ファイルを保存します。
     *
     * @param location
     * @param file
     *            保存先ディレクトリ
     */
    public UploadFileDto saveFile(MultipartFile file) {
		Assert.notNull(file, "file can't be null");
		String upFileName = file.getOriginalFilename();

		try {
			if (file.isEmpty()) {
				throw new IllegalArgumentException("cloud not save empty file. " + upFileName);
			}

			// 画像の拡張子
			String extension = upFileName.substring(upFileName.lastIndexOf(".") + 1);

			if (!"jpg".equalsIgnoreCase(extension)) {
				// TODO JPG 以外の場合は変換する
			}

			// 画像ID
			var id = generateID(Integer.valueOf(9));

			// ディレクトリ
			String dir = getHash(id);
	        Path location = Paths.get(fileUploadLocation, dir);

			// 保存するファイル名
			String saveFileName = id + ".jpg";

			// ディレクトリがない場合は作成する
			FileUtils.createDirectories(location);

			// インプットストリームをファイルに書き出す
			Files.copy(file.getInputStream(), location.resolve(saveFileName));

			TImage tImage = new TImage();
			tImage.setImageId(id);
			tImage.setRegistTime(DateUtils.getNow());
			tImage.setUpdateTime(DateUtils.getNow());
			tImage.setDeleteFlg(false);
			tImageDao.insert(tImage);

			UploadFileDto dto = new UploadFileDto();
			dto.setId(id);
			dto.setPath("/thumb" + dir + "/" + saveFileName);
			return dto;

		} catch (IOException e) {
			throw new IllegalStateException("failed to save file. " + upFileName, e);
		}
	}
}
