package com.isystk.sample.domain.repository.dto;

import java.util.List;

import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPostImage;
import com.isystk.sample.domain.entity.TPostTag;
import com.isystk.sample.domain.entity.TUser;

import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.compress.utils.Lists;

@Getter
@Setter
public class TPostRepositoryDto extends TPost {

  TUser tUser;

  List<TPostImage> tPostImageList;

  List<TPostTag> tPostTagList;

  public List<Integer> getPostTagIdList() {
    return Optional.of(tPostTagList.stream().map((e) ->
          e.getPostTagId()
        ).collect(Collectors.toList())).orElse(Lists.newArrayList());
  }
}