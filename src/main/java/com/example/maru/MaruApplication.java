package com.example.maru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@@EnableJpaAuditing ：レコードの作成、更新時の情報設定を有効にし、Auditingを活性化する。
@EnableJpaAuditing 
public class MaruApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaruApplication.class, args);
	}

//	// @PostConstruct：Bean生成後の初期化
//	@PostConstruct
//	public void init() {
//		// spring bootのタイムゾーンをJSTに設定（デフォルトはUCT）
//		TimeZone.setDefault(TimeZone.getTimeZone("UCT"));
//	}

}
