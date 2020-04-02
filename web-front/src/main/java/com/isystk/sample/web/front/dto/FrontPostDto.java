package com.isystk.sample.web.front.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 投稿フロント表示用DTO
 */
@Getter
@Setter
public class FrontPostDto {

	private Integer postId;

	private Integer userId;

	private String title;

	private String text;

	private List<String> imageUrlList;

	private List<String> tagNameList;


}
