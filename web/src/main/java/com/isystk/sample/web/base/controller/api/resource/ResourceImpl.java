package com.isystk.sample.web.base.controller.api.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isystk.sample.domain.dto.common.Dto;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceImpl implements Resource {

    List<? extends Dto> data;

    // メッセージ
    String message;
}
