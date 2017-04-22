package com.wjs.api.hessian.config;


import cn.com.common.base.query.QueryService;
import com.wjs.wechat.api.facade.WechatFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class WechatHessianConfig extends CommonHessianConfig {

    @Bean
    public HessianProxyFactoryBean wechatFacade() {
        return newHessianProxyFactoryBean(getProperty("wechat.facade.url"), WechatFacade.class);
    }

    @Bean
    public HessianProxyFactoryBean wechatQueryFacade() {
        return newHessianProxyFactoryBean(getProperty("wechat.query.url"), QueryService.class);
    }
}
