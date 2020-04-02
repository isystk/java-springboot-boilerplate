package com.isystk.sample.domain.dto;

import java.util.List;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto extends TPost {

	List<TPostImage> tPostImageList;

	List<TPostTag> tPostTagList;

}