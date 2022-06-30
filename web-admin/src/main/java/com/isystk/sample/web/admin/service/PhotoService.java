package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.values.ImageType;
import com.isystk.sample.web.admin.dto.ImageDto;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.compress.utils.Lists;
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
  public List<ImageDto> findAll(String name) {
    List<String> stockImages = imageHelper.getImageList("/stocks");
    return stockImages.stream().map((e) -> {
      ImageDto dto = new ImageDto();
      dto.setImageType(ImageType.STOCK);
      String[] names = e.split("/");
      dto.setImageName(names[names.length-1]);
      return dto;
    }).collect(Collectors.toList());
  }

}
