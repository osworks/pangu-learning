package com.github.pangu.learning.discovery.http.provider.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.discovery.http.provider.model.BankCard;
import lombok.extern.slf4j.Slf4j;

/**
 * 银行卡服务
 * @author xiongchun
 *
 */
@Slf4j
@RestController
@RequestMapping("bankCard")
public class BankCardController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("findCardInfo")
	public BankCard findCardInfo(String cardNo) {
	    log.info("入参 cardNo:{}", cardNo);
		BankCard bankCard = new BankCard().setCardNo("5301001").setName("XC").setBalance(BigDecimal.valueOf(1000000L));
		log.info("出参 bankCard:{}", bankCard);
		return bankCard;
	}
}