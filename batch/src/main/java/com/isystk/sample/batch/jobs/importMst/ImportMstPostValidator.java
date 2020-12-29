package com.isystk.sample.batch.jobs.importMst;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ImportMstPostValidator extends AbstractValidator<ImportMstPostDto> {

  @Override
  protected void doValidate(ImportMstPostDto dto, Errors errors) {

    if (dto.getPosition() == 1 && !Objects.equals(dto.getPostTagId(), "Wyn")) {
      errors.rejectValue("postTagId", "importMstJob.invalidMstPostId");
    }
  }
}
