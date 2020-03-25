package com.isystk.sample.web.admin.controller.html.post;

import static com.isystk.sample.web.base.WebConst.*;
import static com.isystk.sample.domain.util.TypeUtils.toListType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.service.post.PostService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.base.view.CsvView;
import com.isystk.sample.web.base.view.ExcelView;
import com.isystk.sample.web.base.view.PdfView;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(ADMIN_POST_URL)
public class PostController extends AbstractHtmlController {

    @Autowired
    PostService postService;

	@Override
	public String getFunctionName() {
		return "A_POST";
	}

	/**
	 * 一覧画面表示
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String index(@ModelAttribute SearchPostForm form, Model model) {
        // 入力値を詰め替える
        val criteria = modelMapper.map(form, PostCriteria.class);

        // 10件区切りで取得する
        val pages = postService.findAll(criteria, form);

        // 画面に検索結果を渡す
        model.addAttribute("pages", pages);

		return "modules/post/index";
	}

	/**
	 * 詳細画面表示
	 * @param postId
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}")
	public String show(@PathVariable Integer postId, Model model) {
		model.addAttribute("post", postService.findById(postId));
		return "modules/post/show";
	}

	/**
	 * 登録画面表示
	 * @param post
	 * @param model
	 * @return
	 */
	@GetMapping("new")
	public String newItem(@ModelAttribute("post") TPost post, Model model) {
		return "modules/post/new";
	}

	/**
	 * 変更画面表示
	 * @param postId
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("{postId}/edit")
	public String edit(@PathVariable Integer postId, @ModelAttribute("postForm") PostForm form, Model model) {
        // セッションから取得できる場合は、読み込み直さない
        if (!hasErrors(model)) {
            // 1件取得する
            val post = postService.findById(postId);

            // 取得したDtoをFromに詰め替える
            modelMapper.map(post, form);
        }

		return "modules/post/edit";
	}

	/**
	 * 登録処理
	 * @param post
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping
	public String create(@ModelAttribute("post") @Validated TPost post, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "modules/post/new";
		} else {
			postService.create(post);
			return "redirect:/post";
		}
	}

	/**
	 * 更新処理
	 * @param form
	 * @param br
	 * @param postId
	 * @param sessionStatus
	 * @param attributes
	 * @return
	 */
	@PutMapping("{postId}")
	public String update(@Validated @ModelAttribute("postForm") PostForm form, BindingResult br,
            @PathVariable Integer postId, SessionStatus sessionStatus, RedirectAttributes attributes) {

        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            setFlashAttributeErrors(attributes, br);
			return "modules/post/edit";
        }

        // 更新対象を取得する
        val post = postService.findById(postId);

        // 入力値を詰め替える
        modelMapper.map(form, post);

        // 更新する
        val updatedPost = postService.update(post);

        // セッションのpostFormをクリアする
        sessionStatus.setComplete();

		return "redirect:/post/" + updatedPost.getPostId();
	}

	/**
	 * 削除処理
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
    public ModelAndView downloadCsv(@PathVariable String filename) {
        // 全件取得する
        val posts = postService.findAll(new PostCriteria(), Pageable.NO_LIMIT);

        // 詰め替える
        List<PostCsv> csvList = modelMapper.map(posts.getData(), toListType(PostCsv.class));

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
    public ModelAndView downloadExcel(@PathVariable String filename) {
        // 全件取得する
        val posts = postService.findAll(new PostCriteria(), Pageable.NO_LIMIT);

        // Excelプック生成コールバック、データ、ダウンロード時のファイル名を指定する
        val view = new ExcelView(new PostExcel(), posts.getData(), filename);

        return new ModelAndView(view);
    }

    /**
     * PDFダウンロード
     *
     * @param filename
     * @return
     */
    @GetMapping(path = "/download/{filename:.+\\.pdf}")
    public ModelAndView downloadPdf(@PathVariable String filename) {
        // 全件取得する
        val posts = postService.findAll(new PostCriteria(), Pageable.NO_LIMIT);

        // 帳票レイアウト、データ、ダウンロード時のファイル名を指定する
        val view = new PdfView("reports/post.jrxml", posts.getData(), filename);

        return new ModelAndView(view);
    }
}
