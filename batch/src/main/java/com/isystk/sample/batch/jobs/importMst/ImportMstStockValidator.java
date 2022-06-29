package com.isystk.sample.batch.jobs.importMst;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ImportMstStockValidator extends AbstractValidator<ImportMstStockDto> {

  @Override
  protected void doValidate(ImportMstStockDto dto, Errors errors) {

    if (dto.getPosition() == 1 && !Objects.equals(dto.getName(), "商品名")) {
      errors.rejectValue("name", "importMstJob.invalidMstStock");
    }
  }
}
