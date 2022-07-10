package com.isystk.sample.web.front.controller.api.v1.constant;

import com.isystk.sample.common.dto.CodeValueDto;
import com.isystk.sample.common.dto.CodeValueGroupDto;
import com.isystk.sample.common.values.Age;
import com.isystk.sample.common.values.Prefecture;
import com.isystk.sample.common.values.Gender;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_CONSTS;

@RestController
@RequestMapping(path = API_V1_CONSTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class ConstantController extends AbstractRestController {

  @Value("${stripe.apiKey}")
  String apiKey;

  @Override
  public String getFunctionName() {
    return "API_CONSTANTS";
  }

  /**
   * 定数取得します。
   *
   * @return
   */
  @GetMapping
  public Resource index() {

    Resource resource = resourceFactory.create();

    List<CodeValueGroupDto> list = Lists.newArrayList();
    list.add(new CodeValueGroupDto("gender", Arrays.stream(Gender.values())
        .map((values) -> {
              CodeValueDto dto = new CodeValueDto();
              dto.setText(values.getText());
              dto.setCode(values.getCode());
              return dto;
            }
        ).collect(Collectors.toList())));
    list.add(new CodeValueGroupDto("age", Arrays.stream(Age.values())
        .map((values) -> {
              CodeValueDto dto = new CodeValueDto();
              dto.setText(values.getText());
              dto.setCode(values.getCode());
              return dto;
            }
        ).collect(Collectors.toList())));
    list.add(new CodeValueGroupDto("prefecture", Arrays.stream(Prefecture.values())
        .map((values) -> {
              CodeValueDto dto = new CodeValueDto();
              dto.setText(values.getText());
              dto.setCode(values.getCode());
              return dto;
            }
        ).collect(Collectors.toList())));
    CodeValueDto dto = new CodeValueDto();
    dto.setText("stripe_key");
    dto.setCode(apiKey);
    list.add(new CodeValueGroupDto("stripe", Arrays.asList(dto)));

    resource.setData(list);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

}
