package com.isystk.sample.web.base.view;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.collect.Lists;
import com.isystk.sample.common.util.EncodeUtils;
import lombok.val;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.dataformat.csv.CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS;
import static com.isystk.sample.common.util.ValidateUtils.isNotEmpty;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

/**
 * CSVビュー
 */
public class CsvView extends AbstractView {

  protected static final CsvMapper csvMapper = createCsvMapper();

  protected Class<?> clazz;

  protected Collection<?> data;

  protected String filename;

  protected List<String> columns;

  /**
   * CSVマッパーを生成する。
   *
   * @return
   */
  static CsvMapper createCsvMapper() {
    CsvMapper mapper = new CsvMapper();
    mapper.configure(ALWAYS_QUOTE_STRINGS, true);
    mapper.findAndRegisterModules();
    return mapper;
  }

  /**
   * コンストラクタ
   *
   * @param clazz
   * @param data
   * @param filename
   */
  public CsvView(Class<?> clazz, Collection<?> data, String filename) {
    setContentType("application/octet-stream; charset=Windows-31J;");
    this.clazz = clazz;
    this.data = data;
    this.filename = filename;
  }

  @Override
  protected boolean generatesDownloadContent() {
    return true;
  }

  @Override
  protected final void renderMergedOutputModel(Map<String, Object> model,
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    // ファイル名に日本語を含めても文字化けしないようにUTF-8にエンコードする
    val encodedFilename = EncodeUtils.encodeUtf8(filename);
    val contentDisposition = String.format("attachment; filename*=UTF-8''%s", encodedFilename);

    response.setHeader(CONTENT_TYPE, getContentType());
    response.setHeader(CONTENT_DISPOSITION, contentDisposition);

    // CSVヘッダをオブジェクトから作成する
    CsvSchema schema = csvMapper.schemaFor(clazz).withHeader();

    if (isNotEmpty(columns)) {
      // カラムが指定された場合は、スキーマを再構築する
      val builder = schema.rebuild().clearColumns();
      for (String column : columns) {
        builder.addColumn(column);
      }
      schema = builder.build();
    }

    // 書き出し
//		val outputStream = createTemporaryOutputStream();
//		try (Writer writer = new OutputStreamWriter(outputStream, "Windows-31J")) {
    try (PrintWriter writer = response.getWriter()) {
      csvMapper.writer(schema).writeValue(writer, data);
    }
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }
}
