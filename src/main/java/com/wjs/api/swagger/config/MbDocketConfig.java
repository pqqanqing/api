package com.wjs.api.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class MbDocketConfig extends CommonDocketConfig {

    @Bean
    public Docket mbDocket() {
        return commonDocket()
                .group("会员模块")
                .contact("清清", "https://github.com/pqqanqing", "xxx")
                .paths("/mbs.*")
                .build();
    }
}
