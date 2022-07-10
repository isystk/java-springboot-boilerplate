package com.isystk.sample.web.front.controller.api.v1.like;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_LIKES;

import com.google.common.collect.Maps;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.base.controller.api.resource.ResourceImpl;
import com.isystk.sample.web.front.service.LikeService;
import java.math.BigInteger;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = API_V1_LIKES, produces = MediaType.APPLICATION_JSON_VALUE)
public class LikeController extends AbstractRestController {

  @Autowired
  LikeService likeService;

  @Override
  public String getFunctionName() {
    return "API_LIKES";
  }

  /**
   * お気に入りの一覧を取得します。
   *
   * @return
   */
  @GetMapping
  public Resource index() {

    var likes = likeService.getLikes();

    Map data = Maps.newHashMap();
    data.put("data", likes);
    Resource resource = ObjectMapperUtils.map(data, ResourceImpl.class);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

  /**
   * お気に入りを追加します。
   *
   * @return
   */
  @PostMapping("/add")
  public Resource addLike(@RequestParam("id") BigInteger stockId) {
    var likes = likeService.addLike(stockId);

    Map data = Maps.newHashMap();
    data.put("data", likes);
    Resource resource = ObjectMapperUtils.map(data, ResourceImpl.class);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

  /**
   * お気に入りを削除します。
   *
   * @return
   */
  @PostMapping("/remove")
  public Resource removeLike(@RequestParam("id") BigInteger stockId) {
    var likes = likeService.removeLike(stockId);

    Map data = Maps.newHashMap();
    data.put("data", likes);
    Resource resource = ObjectMapperUtils.map(data, ResourceImpl.class);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

}
