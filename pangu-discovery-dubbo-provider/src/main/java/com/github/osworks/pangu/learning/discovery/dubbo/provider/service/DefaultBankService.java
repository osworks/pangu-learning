package com.github.osworks.pangu.learning.discovery.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import com.github.osworks.pangu.learning.discovery.dubbo.api.model.Bank;
import com.github.osworks.pangu.learning.discovery.dubbo.api.service.BankService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(version = "1.0.0", group = "pangu-discovery-dubbo-provider")
public class DefaultBankService implements BankService{

    @Override
    public Bank findBankInfo(String id) {
        log.info("入参：{}", id);
        Bank bank = new Bank();
        bank.setId("10000").setName("昆明工商银行");
        return bank;
    }

}
