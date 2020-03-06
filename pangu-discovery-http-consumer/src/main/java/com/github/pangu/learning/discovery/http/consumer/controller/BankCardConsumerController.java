package com.github.pangu.learning.discovery.http.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.discovery.http.consumer.feignclient.BankCardFeignClient;
import com.github.pangu.learning.discovery.http.consumer.model.BankCard;

/**
 * 演示基于RestTemplate消费服务
 * @author xiongchun
 *
 */
@RestController
@RequestMapping("bankCard")
public class BankCardConsumerController {
	
	@Autowired
	private BankCardFeignClient bankCardFeignClient;

	@GetMapping("findCardInfo")
	public BankCard findCardInfo(String cardNo) {
		BankCard bankCard = bankCardFeignClient.findCardInfo(cardNo);
		System.out.println(bankCard);
		return bankCard;
	}

}
