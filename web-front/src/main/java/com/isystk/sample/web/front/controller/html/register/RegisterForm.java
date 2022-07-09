package com.isystk.sample.web.front.controller.html.register;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterForm implements Serializable {

  private static final long serialVersionUID = 7593564324192730932L;
  @NotEmpty
  String name;

  @NotEmpty
  @Email
  String email;

  @NotEmpty
  String password;

  @NotEmpty
  String passwordConfirmation;

}
