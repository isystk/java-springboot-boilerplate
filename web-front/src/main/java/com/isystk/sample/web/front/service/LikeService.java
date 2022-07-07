package com.isystk.sample.web.front.service;

import com.google.common.collect.Lists;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.NumberUtils;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.web.base.util.CookieUtils;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.castor.core.util.Assert;
import org.springframework.stereotype.Service;

@Service
public class LikeService extends BaseTransactionalService {

  private static final String LIKE_COOKIE_KEY = "likes";

  private static final int COOKIE_MAXAGE = 24 * 60 * 60 * 365; // 1年

  /**
   * クッキーからお気に入り情報を取得します。
   *
   * @return
   */
  public List<BigInteger> getLikes() {
    String cookieString = CookieUtils.getValue(LIKE_COOKIE_KEY);
    var likes = parseCommaSeparatedValue(cookieString);
    return likes.stream()
        .filter((e) -> {
          BigInteger stockId = NumberUtils.toBigInteger(e);
          return (stockId != null);
        })
        .map(e -> NumberUtils.toBigInteger(e))
        .collect(Collectors.toList());
  }

  /**
   * カンマ区切りの文字列から、文字列の配列を作成する
   *
   * @param cookieString カンマ区切りの文字列
   * @return
   */
  private List<String> parseCommaSeparatedValue(String cookieString) {
    List<String> result = Lists.newArrayList();
    try {
      if (cookieString != null) {
        for (String val : cookieString.split("-")) {
          if (result.contains(val) == false) {
            result.add(val);
          }
        }
      }
    } catch (Exception e) {
        // void
    }
    return result;
  }

  /**
   * クッキーにお気に入り情報を追加します。
   *
   * @return
   */
  public List<BigInteger> addLike(BigInteger stockId) {
    var likes = getLikes();
    Assert.notNull(likes, "likes must not be null");

    likes.add(stockId);

    String join = StringUtils.join( "-", likes.toArray());
	  CookieUtils.setCookie(LIKE_COOKIE_KEY, join, "/", COOKIE_MAXAGE, null);
    return likes;
  }

  /**
   * クッキーからお気に入り情報を削除します。
   *
   * @return
   */
  public List<BigInteger> removeLike(BigInteger stockId) {
    var likes = getLikes();
    Assert.notNull(likes, "likes must not be null");

    likes = likes.stream().filter((e) -> {
      return !e.equals(stockId);
    }).collect(Collectors.toList());

    String join = StringUtils.join( "-", likes.toArray());
    CookieUtils.setCookie(LIKE_COOKIE_KEY, join, "/", COOKIE_MAXAGE, null);
    return likes;
  }

}
