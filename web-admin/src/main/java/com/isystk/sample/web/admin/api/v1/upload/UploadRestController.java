package com.isystk.sample.web.admin.api.v1.upload;

import static com.isystk.sample.common.Const.*;
import static com.isystk.sample.common.AdminUrl.*;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isystk.sample.common.dto.UploadFileDto;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.base.view.FileDownloadView;

import lombok.val;

/**
 * ファイルアップロードのコントローラー
 */
@RestController
@RequestMapping(path = API_V1_FILEUPLOAD, produces = MediaType.APPLICATION_JSON_VALUE)
public class UploadRestController extends AbstractRestController {

  @Autowired
  ImageHelper imageHelper;

  @Override
  public String getFunctionName() {
    return "API_FILEUPLOAD";
  }

  /**
   * ファイル内容表示
   *
   * @param imageId
   * @return
   */
  @GetMapping("/{imageId}")
  @ResponseBody
  public ModelAndView serveFile(@PathVariable Integer imageId) {
    // ファイルを読み込む
    val resource = imageHelper.loadFile(imageId);

    // レスポンスを設定する
    val view = new FileDownloadView(resource);
    view.setAttachment(false);
    view.setFilename(imageId + "." + IMAGE_EXTENSION);

    return new ModelAndView(view);
  }

  /**
   * ファイルダウンロード
   *
   * @param imageId
   * @return
   */
  @GetMapping("/download/{imageId}")
  @ResponseBody
  public ModelAndView downloadFile(@PathVariable Integer imageId) {
    // ファイルを読み込む
    val resource = imageHelper.loadFile(imageId);

    // レスポンスを設定する
    val view = new FileDownloadView(resource);
    view.setFilename(imageId + "." + IMAGE_EXTENSION);

    return new ModelAndView(view);
  }

  /**
   * 画像アップロードを行う
   *
   * @param form
   * @param model
   * @return
   */
  @PostMapping("/image")
  public Resource post(@ModelAttribute("uploadRestForm") UploadRestForm form, Model model) {

    // ファイルを保存する
    UploadFileDto dto = imageHelper.saveFile(form.getImageFile());

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(dto));
    resource.setMessage(getMessage("uploadfiles.upload.success"));

    return resource;
  }

}