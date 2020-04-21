package com.github.osworks.pangu.learning.discovery.dubbo.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.github.osworks.pangu.common.boot.PanguApp;
import com.github.osworks.pangu.common.boot.PanguAppType;
import com.github.osworks.pangu.learning.discovery.dubbo.api.model.BankCard;
import com.github.osworks.pangu.learning.discovery.dubbo.api.service.BankCardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ComponentScan({"com.github.osworks.pangu"})
@EnableDubbo
@EnableScheduling
public class DubboConsumerApplication {

	public static void main(String[] args) {
	    PanguApp.run(DubboConsumerApplication.class, PanguAppType.WEBNONE, args);
	}
	
	@Reference(version = "1.0.0", check = false, group = "pangu-discovery-dubbo-provider")
	private BankCardService bankCardService;
	
    @Scheduled(fixedRate = 3000)
    public void callService() throws Exception {
        BankCard bankCard = bankCardService.findCardInfo("530102");
        log.info(bankCard.toString());
    }

}
