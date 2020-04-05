package com.isystk.sample.web.front.controller.html.entry;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.isystk.sample.common.validator.annotation.PhoneNumber;
import com.isystk.sample.common.validator.annotation.ZenKana;
import com.isystk.sample.common.validator.annotation.ZipCode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class EntryForm implements Serializable {

	private static final long serialVersionUID = 7593564324192730932L;

	/** 姓 */
	@NotBlank
	@Size(max = 100)
	String familyName;

	/** 名 */
	@NotBlank
	@Size(max = 100)
	String name;

	/** 姓（カナ） */
	@NotBlank
	@Size(max = 100)
	@ZenKana
	String familyNameKana;

	/** 名（カナ） */
	@NotBlank
	@Size(max = 100)
	@ZenKana
	String nameKana;

	/** メールアドレス */
	@NotBlank
	@Email
	@Size(max = 100)
	String email;

	/** パスワード */
	@NotBlank
	@Size(max = 100)
	String password;

	/** パスワード(確認用) */
	@NotBlank
	@Size(max = 100)
	String passwordConf;

	/** 性別 */
	@NotNull
	@Digits(integer = 11, fraction = 0)
	Integer sex;

	/** 郵便番号 */
	@Size(max = 11)
	@ZipCode
	String zip;

	/** 都道府県 */
	@Digits(integer = 11, fraction = 0)
	String prefectureId;

	/** 市区町村 */
	@Size(max = 100)
	String area;

	/** 町名番地 */
	@Size(max = 100)
	String address;

	/** 建物名 */
	@Size(max = 100)
	String building;

	/** 電話番号 */
	@PhoneNumber
	String tel;

	/** 生年月日 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate birthday;

}
