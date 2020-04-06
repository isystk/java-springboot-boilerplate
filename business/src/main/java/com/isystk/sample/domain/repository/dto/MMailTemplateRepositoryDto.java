package com.isystk.sample.domain.repository.dto;

import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.entity.MMailTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MMailTemplateRepositoryDto extends MMailTemplate {

	MailTemplateDiv mailTemplateDiv;

}