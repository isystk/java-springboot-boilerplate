package com.isystk.sample.web.front.controller.html.entry;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntryHtmlForm implements Serializable {

    private static final long serialVersionUID = 7593564324192730932L;

    @NotEmpty
    String loginId;

    @NotEmpty
    String password;

}
