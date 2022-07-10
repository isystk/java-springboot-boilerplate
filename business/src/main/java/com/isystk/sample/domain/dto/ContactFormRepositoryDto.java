package com.isystk.sample.domain.dto;

import com.isystk.sample.domain.entity.ContactForm;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactFormRepositoryDto extends ContactForm {

  List<ContactFormImageRepositoryDto> imageList;
}