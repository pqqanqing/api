package com.wjs.api.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class WechatDocketConfig extends CommonDocketConfig {

    @Bean
    public Docket wechatDocket() {
        return commonDocket()
                .group("微信钱吧模块")
                .contact("潘清清/张世海", "https://github.com/pqqanqing", "15601870402@163.com")
                .paths("/wechats.*")
                .build();
    }
}