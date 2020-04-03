package com.isystk.sample.web.admin.controller.html.post;

import static com.isystk.sample.common.FrontUrl.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.entity.TPostDto;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.web.admin.service.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.base.view.CsvView;
import com.isystk.sample.web.base.view.ExcelView;
import com.isystk.sample.web.base.view.PdfView;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(POST_URL)
@SessionAttributes(types = { SearchPostForm.class, PostForm.class })
public class PostHtmlController extends AbstractHtmlController {

	@Autowired
	PostService postService;

	@Autowired
	PostFormValidator postFormValidator;

	@Autowired
	UserHelper userHelper;

	@Override
	public String getFunctionName() {
		return "A_POST";
	}

	@InitBinder("postForm")
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(postFormValidator);
	}

	/**
	 * 一覧画面表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(SearchPostForm form, Model model) {
		// 入力値を詰め替える
		TPostCriteria criteria = new TPostCriteria();
		criteria.setPostIdEqual(form.getPostId());
		criteria.setUserIdEqual(form.getUserId());
		criteria.setTitleLike(form.getTitle());

		// 10件区切りで取得する
		val pages = postService.findAll(criteria, form);

		// 画面に検索結果を渡す
		model.addAttribute("pages", pages);

		return "modules/post/list";
	}

	/**
	 * 詳細画面表示
	 *
	 * @param postId
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}")
	public String show(@PathVariable Integer postId, Model model) {
		model.addAttribute("post", postService.findById(postId));
		return "modules/post/detail";
	}

	/**
	 * 登録画面表示
	 *
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("regist")
	public String regist(PostForm form, Model model, SessionStatus sessionStatus) {

		// セッションのpostFormをクリアする
		sessionStatus.setComplete();

		// ユーザー一覧
		val userList = userHelper.getUserList();
		model.addAttribute("userList", userList);

		return showRegist(model);
	}

	private String showRegist(Model model) {
		// ユーザー一覧
		val userList = userHelper.getUserList();
		model.addAttribute("userList", userList);

		return "modules/post/regist";
	}

	/**
	 * 変更画面表示
	 *
	 * @param postId
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}/edit")
	public String edit(@PathVariable Integer postId, PostForm form, Model model, SessionStatus sessionStatus) {

		// セッションのpostFormをクリアする
		sessionStatus.setComplete();

		// 1件取得する
		val post = postService.findById(postId);

		// 取得したDtoをFromに詰め替える
		ObjectMapperUtils.map(post, form);

		return showRegist(model);
	}

	/**
	 * 登録処理
	 *
	 * @param post
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping
	public String regist(@Validated PostForm form, Model model, BindingResult br, SessionStatus sessionStatus,
			RedirectAttributes attributes) {
		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return showRegist(model);
		}

		// 入力値からDTOを作成する
		val tPostDto = ObjectMapperUtils.map(form, TPostDto.class);
		// ログインユーザーID
		tPostDto.setUserId(userHelper.getLoginUserId());
		// 投稿画像
		List<TPostImage> tPostImageList = Lists.newArrayList();
		if (form.getPostImageId() != null) {
			for (Integer imageId : form.getPostImageId()) {
				TPostImage tPostImage = new TPostImage();
				tPostImage.setImageId(imageId);
				tPostImageList.add(tPostImage);
			}
		}
		tPostDto.setTPostImageList(tPostImageList);
		// 投稿タグ
		List<TPostTag> tPostTagList = Lists.newArrayList();
		if (form.getPostTagId() != null) {
			for (Integer tagId : form.getPostTagId()) {
				TPostTag tPostTag = new TPostTag();
				tPostTag.setPostTagId(tagId);
				tPostTagList.add(tPostTag);
			}
		}
		tPostDto.setTPostTagList(tPostTagList);
		val tPost = postService.create(tPostDto);

		return "redirect:/post/" + tPost.getPostId();
	}

	/**
	 * 更新処理
	 *
	 * @param form
	 * @param br
	 * @param postId
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PutMapping("{postId}")
	public String update(@PathVariable Integer postId, @Validated PostForm form, Model model, BindingResult br,
			SessionStatus sessionStatus, RedirectAttributes attributes) {

		// 入力チェックエラーがある場合は、元の画面にもどる
		if (br.hasErrors()) {
			setFlashAttributeErrors(attributes, br);
			return showRegist(model);
		}

		// 入力値を詰め替える
		val tPostDto = ObjectMapperUtils.map(form, TPostDto.class);
		// 投稿画像
		List<TPostImage> tPostImageList = Lists.newArrayList();
		if (form.getPostImageId() != null) {
			for (Integer imageId : form.getPostImageId()) {
				TPostImage tPostImage = new TPostImage();
				tPostImage.setImageId(imageId);
				tPostImageList.add(tPostImage);
			}
		}
		tPostDto.setTPostImageList(tPostImageList);
		// 投稿タグ
		List<TPostTag> tPostTagList = Lists.newArrayList();
		if (form.getPostTagId() != null) {
			for (Integer tagId : form.getPostTagId()) {
				TPostTag tPostTag = new TPostTag();
				tPostTag.setPostTagId(tagId);
				tPostTagList.add(tPostTag);
			}
		}
		tPostDto.setTPostTagList(tPostTagList);
		// 更新する
		postService.update(tPostDto);

		// セッションのpostFormをクリアする
		sessionStatus.setComplete();

		return "redirect:/post/" + tPostDto.getPostId();
	}

	/**
	 * 削除処理
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) {
		postService.delete(id);
		return "redirect:/post";
	}

	/**
	 * CSVダウンロード
	 *
	 * @param filename
	 * @return
	 */
	@GetMapping("/download/{filename:.+\\.csv}")
	public ModelAndView downloadCsv(@PathVariable String filename, SearchPostForm form, Model model) {
		// 入力値を詰め替える
		val criteria = ObjectMapperUtils.map(form, TPostCriteria.class);

		// 全件取得する
		form.setPerpage(Pageable.NO_LIMIT.getPerpage());
		val pages = postService.findAll(criteria, form);

		// 詰め替える
		List<PostCsv> csvList = ObjectMapperUtils.mapAll(pages.getData(), PostCsv.class);

		// CSVスキーマクラス、データ、ダウンロード時のファイル名を指定する
		val view = new CsvView(PostCsv.class, csvList, filename);

		return new ModelAndView(view);
	}

	/**
	 * Excelダウンロード
	 *
	 * @param filename
	 * @return
	 */
	@GetMapping(path = "/download/{filename:.+\\.xlsx}")
	public ModelAndView downloadExcel(@PathVariable String filename, SearchPostForm form, Model model) {
		// 入力値を詰め替える
		val criteria = ObjectMapperUtils.map(form, TPostCriteria.class);

		// 全件取得する
		form.setPerpage(Pageable.NO_LIMIT.getPerpage());
		val pages = postService.findAll(criteria, form);

		// Excelプック生成コールバック、データ、ダウンロード時のファイル名を指定する
		val view = new ExcelView(new PostExcel(), pages.getData(), filename);

		return new ModelAndView(view);
	}

	/**
	 * PDFダウンロード
	 *
	 * @param filename
	 * @return
	 */
	@GetMapping(path = "/download/{filename:.+\\.pdf}")
	public ModelAndView downloadPdf(@PathVariable String filename, SearchPostForm form, Model model) {
		// 入力値を詰め替える
		val criteria = ObjectMapperUtils.map(form, TPostCriteria.class);

		// 全件取得する
		form.setPerpage(Pageable.NO_LIMIT.getPerpage());
		val pages = postService.findAll(criteria, form);

		// 帳票レイアウト、データ、ダウンロード時のファイル名を指定する
		val view = new PdfView("reports/post.jrxml", pages.getData(), filename);

		return new ModelAndView(view);
	}
}
