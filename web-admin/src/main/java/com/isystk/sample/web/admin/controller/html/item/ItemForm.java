package com.isystk.sample.web.admin.controller.html.item;

import javax.validation.constraints.NotEmpty;

import com.isystk.sample.web.base.controller.html.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemForm extends BaseForm {

    private static final long serialVersionUID = 7593564324192730932L;

    @NotEmpty
    Long itemId;

    @NotEmpty
    String itemName;

	@Override
	public Long getId() {
		return itemId;
	}

}
