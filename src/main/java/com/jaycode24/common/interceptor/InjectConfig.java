package com.jaycode24.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description 插件注入
 * @Author wangcheng
 * @Date 2022/10/25 16:34
 */
@Slf4j
public class InjectConfig implements ApplicationContextAware {

    private final static List<Interceptor> INTERCEPTORS;

    static {
        INTERCEPTORS = Arrays.asList(new PagePlugin());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, SqlSessionFactory> sqlSessionFactoryMap = applicationContext.getBeansOfType(SqlSessionFactory.class);
        for (Map.Entry<String, SqlSessionFactory> entry : sqlSessionFactoryMap.entrySet()) {
            SqlSessionFactory sq = entry.getValue();
            //注册插件
            //log.info("分页插件注入：sql参数基类为com.sy.pangu.common.support.query.request.PageRequest将自动分页");
            INTERCEPTORS.forEach(sq.getConfiguration() :: addInterceptor);
        }
    }
}
