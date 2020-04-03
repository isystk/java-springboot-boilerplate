package com.isystk.sample.domain.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TPostDto extends TPost {

	List<TPostImage> tPostImageList;

	List<TPostTag> tPostTagList;

}