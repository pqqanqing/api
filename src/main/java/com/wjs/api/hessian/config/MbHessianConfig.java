package com.wjs.api.hessian.config;


import cn.com.common.base.query.QueryService;
import com.wjs.mb.api.facade.MbFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@Configuration
public class MbHessianConfig extends CommonHessianConfig {

    @Bean
    public HessianProxyFactoryBean mbFacade() {
        return newHessianProxyFactoryBean(getProperty("mb.facade.url"), MbFacade.class);
    }

    @Bean
    public HessianProxyFactoryBean mbQueryFacade() {
        return newHessianProxyFactoryBean(getProperty("mb.query.url"), QueryService.class);
    }
}
