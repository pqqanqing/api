package com.wjs.api.swagger.config;

import com.wjs.api.swagger.builder.DocketBuilder;

public abstract class CommonDocketConfig {

    public DocketBuilder commonDocket() {
        return commonDocket("接口测试API", "1.0");
    }

    public DocketBuilder commonDocket(String title, String version) {
        return DocketBuilder.title(title).version(version);
    }

}