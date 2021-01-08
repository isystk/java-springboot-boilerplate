package com.isystk.sample.web.admin.controller.html.post.edit;

import static com.isystk.sample.common.AdminUrl.*;

import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.domain.repository.MPostTagRepository;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;
import com.isystk.sample.web.admin.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_EDIT)
@SessionAttributes(types = {PostEditForm.class})
public class PostEditHtmlController extends AbstractHtmlController {

  @Autowired
  PostService postService;

  @Autowired
  TPostRepository postRepository;

  @Autowired
  UserHelper userHelper;

  @Autowired
  PostEditFormValidator postEditFormValidator;

  @Autowired
  MPostTagRepository mPostTagRepository;

  @Autowired
  HttpSession session;

  @ModelAttribute("postEditForm")
  public PostEditForm postEditForm() {
    return new PostEditForm();
  }

  @InitBinder("postEditForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(postEditFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "A_POST_EDIT";
  }

  /**
   * 初期表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping("{postId}")
  public String editIndex(@ModelAttribute PostEditForm form, Model model) {
//
//        // SessionAttributeを再生成する
//        model.addAttribute("postEditForm", new PostEditForm());

    // 1件取得する
    val post = postRepository.findById(form.getPostId());

    // 取得したDtoをFromに詰め替える
    ObjectMapperUtils.map(post, form);
    // 投稿画像
    form.setPostImageId(
        Optional.ofNullable(post.getTPostImageList())
            .map(list -> list.stream()
                .map(s -> s.getImageId())
                .collect(Collectors.toList())
            )
            .orElse(null)
    );
    // 投稿タグ
    form.setPostTagId(
        Optional.ofNullable(post.getTPostTagList())
            .map(list -> list.stream()
                .map(s -> s.getPostTagId())
                .collect(Collectors.toList())
            )
            .orElse(null)
    );

    return showEditIndex(form, model);
  }

  /**
   * 修正画面表示
   *
   * @param form
   * @param model
   * @return
   */
  private String showEditIndex(PostEditForm form, Model model) {

    TUser tUser = userHelper.getUser(form.getUserId());
    model.addAttribute("userName", String.join(tUser.getFamilyName(), " ", tUser.getName()));

    // タグの一覧
    model.addAttribute("postTagList", mPostTagRepository.findAllSelectList());

    return "modules/post/edit/index";
  }

  /**
   * 修正確認画面表示
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "confirm")
  public String editConfirm(@Validated @ModelAttribute PostEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    TUser tUser = userHelper.getUser(form.getUserId());
    model.addAttribute("userName", String.join(tUser.getFamilyName(), " ", tUser.getName()));

    // タグの一覧
    model.addAttribute("postTagList", mPostTagRepository.findAllSelectList());

    return "modules/post/edit/confirm";
  }

  /**
   * 前に戻る
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "back")
  public String editBack(@Validated @ModelAttribute PostEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
    return showEditIndex(form, model);
  }

  /**
   * 更新処理
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "complete")
  public String updateComplete(@Validated @ModelAttribute PostEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    // 入力値を詰め替える
    val tPostDto = ObjectMapperUtils.map(form, TPostRepositoryDto.class);
    // 投稿画像
    tPostDto.setTPostImageList(
        Optional.ofNullable(form.getPostImageId())
            .map(list -> list.stream()
                .map(imageId -> {
                  TPostImage tPostImage = new TPostImage();
                  tPostImage.setImageId(imageId);
                  return tPostImage;
                })
                .collect(Collectors.toList())
            )
            .orElse(null)
    );
    // 投稿タグ
    tPostDto.setTPostTagList(
        Optional.ofNullable(form.getPostTagId())
            .map(list -> list.stream()
                .map(tagId -> {
                  TPostTag tPostTag = new TPostTag();
                  tPostTag.setPostTagId(tagId);
                  return tPostTag;
                })
                .collect(Collectors.toList())
            )
            .orElse(null)
    );
    // 更新する
    postService.update(tPostDto);

    // セッションのpostEditFormをクリアする
    sessionStatus.setComplete();

    return "redirect:/post/edit/complete";
  }

  /**
   * 修正完了画面表示
   *
   * @return
   */
  @GetMapping("complete")
  public String showComplete() {
    return "modules/post/edit/complete";
  }

}
