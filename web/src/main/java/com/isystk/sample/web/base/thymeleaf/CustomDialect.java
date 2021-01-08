package com.isystk.sample.web.base.thymeleaf;

import java.util.HashSet;
import java.util.Set;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * 独自定義したダイアレクトを登録する
 */
public class CustomDialect extends AbstractProcessorDialect {

  static final String DIALECT_NAME = "CustomDialect";
  static final String DIALECT_PREFIX = "ex";

  public CustomDialect() {
    super(DIALECT_NAME, DIALECT_PREFIX, 1000);
  }

  @Override
  public Set<IProcessor> getProcessors(String dialectPrefix) {
    final Set<IProcessor> processors = new HashSet<>();
    processors.add(new TextLineProcessor(dialectPrefix, getDialectProcessorPrecedence()));
    return processors;
  }

}
