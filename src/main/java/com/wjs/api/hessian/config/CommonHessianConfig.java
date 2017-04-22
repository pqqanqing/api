package com.wjs.api.hessian.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import static java.util.Objects.isNull;

public abstract class CommonHessianConfig {

    @Autowired
    private Environment environment;

    public <T> HessianProxyFactoryBean newHessianProxyFactoryBean(String url, Class<T> T) {
        HessianProxyFactoryBean hessianProxyFactoryBean = new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setServiceUrl(url);
        hessianProxyFactoryBean.setServiceInterface(T);
        hessianProxyFactoryBean.setHessian2(true);
        hessianProxyFactoryBean.setOverloadEnabled(true);
        return hessianProxyFactoryBean;
    }

    public String getProperty(String key) {
        if (isNull(environment)) return null;
        return isNull(key) ? null : environment.getProperty(key);
    }
}
