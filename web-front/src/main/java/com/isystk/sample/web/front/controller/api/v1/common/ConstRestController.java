package com.isystk.sample.web.front.controller.api.v1.common;

import com.isystk.sample.common.dto.CodeValueDto;
import com.isystk.sample.common.dto.CodeValueGroupDto;
import com.isystk.sample.common.values.Prefecture;
import com.isystk.sample.common.values.Sex;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import org.apache.commons.compress.utils.Lists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_COMMON_CONST;

@RestController
@RequestMapping(path = API_V1_COMMON_CONST, produces = MediaType.APPLICATION_JSON_VALUE)
public class ConstRestController extends AbstractRestController {

  @Override
  public String getFunctionName() {
    return "API_COMMON_CONST";
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
    list.add(new CodeValueGroupDto("sex", Arrays.stream(Sex.values())
        .map((values) -> new CodeValueDto(values)
        ).collect(Collectors.toList())));

    list.add(new CodeValueGroupDto("prefecture", Arrays.stream(Prefecture.values())
        .map((values) -> new CodeValueDto(values)
        ).collect(Collectors.toList())));

    resource.setData(list);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

}
