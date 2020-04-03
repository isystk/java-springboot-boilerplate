package com.isystk.sample.web.front.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 投稿フロント表示用DTO
 */
@Getter
@Setter
public class FrontPostDto implements Dto {

	Integer postId;

	Integer userId;

	String title;

	String text;

    LocalDateTime registTime;

	String registTimeYYYYMMDD;

	String registTimeMMDD;

	List<Integer> imageIdList;

	List<String> imageUrlList;

	List<String> tagNameList;


}
