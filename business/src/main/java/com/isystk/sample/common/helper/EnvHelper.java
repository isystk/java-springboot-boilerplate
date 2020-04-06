package com.isystk.sample.common.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 環境ヘルパー
 */
@Component("env")
@Slf4j
public class EnvHelper {

	@Value("${spring.profiles}") // 設定ファイルに定義されたprofilesを取得する
	String profile;

	/**
	 * ローカル環境かどうか
	 */
	public boolean isLocal() {
		return "local".equals(profile);
	}

	/**
	 * ステージング環境かどうか
	 */
	public boolean isStaging() {
		return "staging".equals(profile);
	}

	/**
	 * 本番環境かどうか
	 */
	public boolean isProduction() {
		return "production".equals(profile);
	}

}
