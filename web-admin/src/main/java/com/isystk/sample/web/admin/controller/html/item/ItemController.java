package com.isystk.sample.web.admin.controller.html.item;

import static com.isystk.sample.web.base.WebConst.ADMIN_ITEMS_URL;

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

import com.isystk.sample.domain.entity.Item;
import com.isystk.sample.web.admin.dto.ItemDto;
import com.isystk.sample.web.admin.service.ItemService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(ADMIN_ITEMS_URL)
public class ItemController extends AbstractHtmlController {

	@Override
	public String getFunctionName() {
		return "A_ITEM";
	}

	@Autowired
	private ItemService itemService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "modules/items/index";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.findOne(id));
		return "modules/items/show";
	}

	@GetMapping("new")
	public String newItem(@ModelAttribute("item") Item item, Model model) {
		return "modules/items/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, @ModelAttribute("item") Item item, Model model) {
		model.addAttribute("item", itemService.findOne(id));
		return "modules/items/edit";
	}

	@PostMapping
	public String create(@ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "modules/items/new";
		} else {
			itemService.save(item);
			return "redirect:/items";
		}
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute("item") @Validated Item item, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("item", item);
			return "modules/items/edit";
		} else {
			item.setId(id);
			itemService.update(item);
			return "redirect:/items";
		}
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		itemService.delete(id);
		return "redirect:/items";
	}

    /**
     * 検索
     *
     * @param model
     * @return
     */
    @GetMapping("/find")
    public String findUser(@ModelAttribute ItemForm form, Model model) {
		model.addAttribute("items", itemService.findAll());

        // 入力値を詰め替える
        val itemDto = modelMapper.map(form, ItemDto.class);
//
//        // 10件区切りで取得する
//        val pages = userService.findAll(itemDto, form);
//
//        // 画面に検索結果を渡す
//        model.addAttribute("pages", pages);

		return "modules/items/index";
    }

}
