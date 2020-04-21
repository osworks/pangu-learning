package com.github.osworks.pangu.learning.discovery.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import com.github.osworks.pangu.learning.discovery.dubbo.api.model.BankCard;
import com.github.osworks.pangu.learning.discovery.dubbo.api.service.BankCardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(version = "1.0.0", group = "pangu-discovery-dubbo-provider")
public class DefaultBankCardService implements BankCardService{

    @Override
    public BankCard findCardInfo(String cardNo) {
        log.info("入参：{}", cardNo);
        BankCard bankCard = new BankCard();
        bankCard.setCardNo("530102").setName("XC");
        return bankCard;
    }

}
