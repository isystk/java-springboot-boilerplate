package com.isystk.sample.domain.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
	private Long id;

	@NotBlank(message = "商品名は入力必須です")
	private String name;

	@Min(value = 10, message = "価格は10より大きい値を入力して下さい")
	@Max(value = 10000, message = "価格は10000より小さい値を入力して下さい")
	private float price;

	@Size(max = 50, message = "生産者は50文字以内で入力して下さい")
	private String vendor;

}
