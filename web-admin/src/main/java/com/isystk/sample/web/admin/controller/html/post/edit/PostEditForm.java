package com.isystk.sample.web.admin.controller.html.post.edit;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

import com.isystk.sample.web.base.controller.html.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostEditForm extends BaseForm {

  private static final long serialVersionUID = 7593564324192730932L;

  @NotNull
  Integer userId;

  @NotNull
  Integer postId;

  @NotBlank
  String title;

  @NotBlank
  String text;

  @NotEmpty
  List<@Digits(integer = 9, fraction = 0) Integer> postImageId;

  List<@Digits(integer = 9, fraction = 0) Integer> postTagId;

}
