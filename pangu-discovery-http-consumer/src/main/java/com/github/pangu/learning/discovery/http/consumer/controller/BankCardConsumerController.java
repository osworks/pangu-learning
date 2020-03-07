package com.github.pangu.learning.discovery.http.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.discovery.http.consumer.feignclient.BankCardFeignClient;
import com.github.pangu.learning.discovery.http.consumer.model.BankCard;
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
	
	@Autowired
	private BankCardFeignClient bankCardFeignClient;

	@GetMapping("findCardInfo")
	public BankCard findCardInfo(String cardNo) {
	    log.info("入参 cardNo:{}", cardNo);
		BankCard bankCard = bankCardFeignClient.findCardInfo(cardNo);
		log.info("出参 bankCard:{}", bankCard);
		return bankCard;
	}

}
