package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.common.values.ImageType;
import com.isystk.sample.web.admin.dto.PhotoSearchResultDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService extends BaseTransactionalService {

  @Autowired
  ImageHelper imageHelper;

  /**
   * 写真を複数取得します。
   *
   * @param name
   * @return
   */
  public List<PhotoSearchResultDto> findAll(String name) {
    List<String> stockImages = imageHelper.getImageList("");
    return stockImages.stream()
        .filter((e) -> {
          if (StringUtils.isBlankOrSpace(name)) {
            return true;
          }
          return 0 <= e.indexOf(name);
        })
        .map((e) -> {
          PhotoSearchResultDto dto = new PhotoSearchResultDto();
          if (0<=e.indexOf("stock")) {
            dto.setImageType(ImageType.STOCK);
          } else if (0<=e.indexOf("contact")) {
            dto.setImageType(ImageType.CONTACT);
          } else {
            dto.setImageType(ImageType.UNKNOWN);
          }
          dto.setImageName(e);
          return dto;
    }).collect(Collectors.toList());
  }

  /**
   * 写真を削除します。
   * @param imageName
   */
  public void delete(String imageName) {
    imageHelper.removeFile("/", imageName);
  }
}
