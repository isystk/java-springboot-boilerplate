package com.isystk.sample.batch.jobs.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.isystk.sample.batch.item.ItemPosition;
import com.isystk.sample.domain.validator.annotation.PhoneNumber;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImportUserDto implements ItemPosition {

    // 名前
    @NotEmpty
    String firstName;

    // 苗字
    @NotEmpty
    String lastName;

    // メールアドレス
    @Email
    String email;

    // 電話番号
    @PhoneNumber
    String tel;

    // 郵便番号
    @NotEmpty
    String zip;

    // 住所
    @NotEmpty
    String address;

    // 取り込み元ファイル
    String sourceName;

    int position;
}
