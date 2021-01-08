package com.isystk.sample.web.admin.controller.html.post.tag;

import static com.isystk.sample.common.AdminUrl.*;

import com.isystk.sample.common.util.NumberUtils;
import com.isystk.sample.domain.repository.dto.MPostTagRepositoryDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.repository.MPostTagRepository;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_TAG)
@SessionAttributes(types = {PostTagSearchForm.class})
public class PostTagHtmlController extends AbstractHtmlController {

  @Autowired
  MPostTagRepository mPostTagRepository;

  @Override
  public String getFunctionName() {
    return "A_POST_TAG";
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(PostTagSearchForm form, Model model) {

    // 10件区切りで取得する
    val pages = mPostTagRepository.find(formToCriteria(form), form);

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/post/tag/list";
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private MPostTagCriteria formToCriteria(PostTagSearchForm form) {

    // 入力値を詰め替える
    MPostTagCriteria criteria = new MPostTagCriteria();
    criteria.setNameLike(form.getPostTagName());
    criteria.setDeleteFlgFalse(true);
    criteria.setOrderBy("order by regist_time desc, post_tag_id asc");

    return criteria;
  }

  /**
   * 新規登録処理
   *
   * @param name
   * @return
   */
  @PostMapping
  public String create(@NotBlank @RequestParam("name") String name ) {

    // 入力値を詰め替える
    val dto = new MPostTagRepositoryDto();
    dto.setName(name);
    // 登録する
    mPostTagRepository.create(dto);

    return "redirect:/post/tag";
  }

  /**
   * 削除処理
   *
   * @param id
   * @return
   */
  @DeleteMapping("{id}")
  public String delete(@PathVariable Integer id) {

    // 削除する
    mPostTagRepository.delete(id);

    return "redirect:/post/tag";
  }

}
