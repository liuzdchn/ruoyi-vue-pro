package com.gedeng.trade.framework.dict.config;

import com.gedeng.trade.framework.dict.core.service.DictDataFrameworkService;
import com.gedeng.trade.framework.dict.core.util.DictFrameworkUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YudaoDictAutoConfiguration {

    @Bean
    @SuppressWarnings("InstantiationOfUtilityClass")
    public DictFrameworkUtils dictUtils(DictDataFrameworkService service) {
        DictFrameworkUtils.init(service);
        return new DictFrameworkUtils();
    }

}
