package com.isystk.sample.web.front.controller.api.v1.upload;

import static com.isystk.sample.web.base.FrontUrl.API_V1_FILEUPLOAD;

import java.nio.file.Paths;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isystk.sample.common.util.FileUtils;
import com.isystk.sample.domain.helper.FileHelper;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.base.util.MultipartFileUtils;
import com.isystk.sample.web.base.view.FileDownloadView;

import lombok.val;

/**
 * 一括アップロードのコントローラー
 */
@RestController
@RequestMapping(path = API_V1_FILEUPLOAD, produces = MediaType.APPLICATION_JSON_VALUE)
public class UploadRestController extends AbstractRestController implements InitializingBean {

    @Value("${application.fileUploadLocation:#{systemProperties['java.io.tmpdir']}}") // 設定ファイルに定義されたアップロード先を取得する
    String fileUploadLocation;

    @Autowired
    FileHelper fileHelper;

    @Override
    public String getFunctionName() {
        return "API_FILEUPLOAD";
    }

    /**
     * ファイル内容表示
     *
     * @param filename
     * @return
     */
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ModelAndView serveFile(@PathVariable String filename) {
        // ファイルを読み込む
        val resource = fileHelper.loadFile(Paths.get(fileUploadLocation), filename);

        // レスポンスを設定する
        val view = new FileDownloadView(resource);
        view.setAttachment(false);
        view.setFilename(filename);

        return new ModelAndView(view);
    }

    /**
     * ファイルダウンロード
     *
     * @param filename
     * @return
     */
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ModelAndView downloadFile(@PathVariable String filename) {
        // ファイルを読み込む
        val resource = fileHelper.loadFile(Paths.get(fileUploadLocation), filename);

        // レスポンスを設定する
        val view = new FileDownloadView(resource);
        view.setFilename(filename);

        return new ModelAndView(view);
    }

    /**
     * 一括アップロードを行う
     *
     * @param multipartFile
     * @param fileType
     * @param registrationType
     * @param dailyAttendanceYyyymm
     * @param loginUser
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Resource post(@ModelAttribute("uploadForm") UploadForm form, Model model) {

        // ファイルを保存する
        MultipartFileUtils.saveFile(Paths.get(fileUploadLocation), form.getImageFile());

        Resource resource = resourceFactory.create();
//        resource.setData(Arrays.asList(""));
        resource.setMessage(getMessage("uploadfiles.upload.success"));

        return resource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // アップロードディレクトリ
        val location = Paths.get(fileUploadLocation);

        // ディレクトリがない場合は作成する
        FileUtils.createDirectories(location);
    }
}