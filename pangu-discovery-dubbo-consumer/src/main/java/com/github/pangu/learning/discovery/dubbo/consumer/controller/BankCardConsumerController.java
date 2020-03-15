package com.github.pangu.learning.discovery.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.discovery.dubbo.api.model.BankCard;
import com.github.pangu.learning.discovery.dubbo.api.service.BankCardService;
import lombok.extern.slf4j.Slf4j;

/**
 * 演示基于RestTemplate消费服务
 * @author xiongchun
 *
 */
@Slf4j
@RestController
@RequestMapping("bankCard")
public class BankCardConsumerController {
	
	@Reference(version = "1.0.0")
	private BankCardService bankCardService;

	@GetMapping("findCardInfo")
	public BankCard findCardInfo(String cardNo) {
	    log.info("入参 cardNo:{}", cardNo);
		BankCard bankCard = bankCardService.findCardInfo(cardNo);
		log.info("出参 bankCard:{}", bankCard);
		return bankCard;
	}

}
