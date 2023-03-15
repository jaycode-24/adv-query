package com.jaycode24.common.interceptor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description mybatis插件注入自动配置
 * @Author wangcheng
 * @Date 2022/10/25 16:39
 */
@Configuration
public class MybatisPluginAutoConfig {


    /**
     * 需要配置
     * advQuery:
     *  open: true
     * 才会开启
     * @return 分页注入
     */
    @Bean
    @ConditionalOnProperty(prefix = "advQuery", name = "open", havingValue = "true")
    public InjectConfig injectConfig(){
        return new InjectConfig();
    }
}
