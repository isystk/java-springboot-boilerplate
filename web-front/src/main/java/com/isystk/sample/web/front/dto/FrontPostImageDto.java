package com.isystk.sample.web.front.dto;

import com.isystk.sample.common.dto.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 投稿フロント表示用 投稿画像DTO
 */
@Getter
@Setter
public class FrontPostImageDto implements Dto {

  Integer imageId;

  String imageUrl;

}
