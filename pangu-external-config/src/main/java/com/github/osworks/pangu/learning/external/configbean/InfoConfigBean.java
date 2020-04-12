package com.github.osworks.pangu.learning.external.configbean;

import org.springframework.stereotype.Component;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;

@Data
@Component
public class InfoConfigBean {
	
    @NacosValue(value = "${bankcard.id}", autoRefreshed = true)
    private String id;
    
    @NacosValue(value = "${bankcard.name}", autoRefreshed = true)
    private String name;
	
}
