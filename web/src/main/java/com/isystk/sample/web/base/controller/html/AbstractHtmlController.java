package com.isystk.sample.web.base.controller.html;

import static com.isystk.sample.common.Const.MAV_ERRORS;

import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isystk.sample.common.FunctionNameAware;
import com.isystk.sample.web.base.controller.BaseController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 基底HTMLコントローラー
 */
@Slf4j
public abstract class AbstractHtmlController extends BaseController implements FunctionNameAware {

	/**
	 * 入力チェックエラーがある場合はtrueを返します。
	 *
	 * @param model
	 * @return
	 */
	public boolean hasErrors(Model model) {
		val errors = model.asMap().get(MAV_ERRORS);

		if (errors != null && errors instanceof BeanPropertyBindingResult) {
			val br = ((BeanPropertyBindingResult) errors);

			if (br.hasErrors()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * リダイレクト先に入力エラーを渡します。
	 *
	 * @param attributes
	 * @param result
	 */
	public void setFlashAttributeErrors(RedirectAttributes attributes, BindingResult result) {
		attributes.addFlashAttribute(MAV_ERRORS, result);
	}
}
