package com.isystk.sample.domain.repository.dto;

import java.util.List;

import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.entity.TUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostRepositoryDto extends TPost {

	TUser tUser;

	List<TPostImage> tPostImageList;

	List<TPostTag> tPostTagList;

}