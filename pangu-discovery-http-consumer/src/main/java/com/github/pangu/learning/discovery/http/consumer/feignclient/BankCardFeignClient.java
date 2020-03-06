package com.github.pangu.learning.discovery.http.consumer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pangu.learning.discovery.http.consumer.model.BankCard;

@FeignClient(name="pangu-discovery-http-provider")
public interface BankCardFeignClient {
	
	@GetMapping("bankCard/findCardInfo")
	BankCard findCardInfo(@RequestParam("cardNo") String cardNo);

	@GetMapping("/notFound")
	String notFound();
}
