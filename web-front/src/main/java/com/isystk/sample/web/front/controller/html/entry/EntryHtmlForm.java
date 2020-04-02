package com.isystk.sample.web.front.controller.html.entry;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntryHtmlForm implements Serializable {

    private static final long serialVersionUID = 7593564324192730932L;

	/** 姓 */
    @NotEmpty
	public String familyName;

	/** 名 */
    @NotEmpty
	public String name;

	/** 姓（カナ） */
    @NotEmpty
	public String familyNameKana;

	/** 名（カナ） */
    @NotEmpty
	public String nameKana;

	/** メールアドレス */
    @NotEmpty
	public String mail;

	/** パスワード */
    @NotEmpty
	public String password;

	/** パスワード(確認用) */
    @NotEmpty
	public String passwordConf;

	/** 郵便番号 */
	public String zip;

	/** 都道府県 */
	public String prefectureId;

	/** 市区町村 */
	public String area;

	/** 町名番地 */
	public String address;

	/** 建物名 */
	public String building;

	/** 電話番号 */
	public String tel;

	/** 性別 */
	public String sex;

	/** 生年月日 */
	public String birthday;

	/** 生年月日（年） */
	public String birthdayYyyy;
	/** 生年月日（月） */
	public String birthdayMm;
	/** 生年月日（日） */
	public String birthdayDd;

}
