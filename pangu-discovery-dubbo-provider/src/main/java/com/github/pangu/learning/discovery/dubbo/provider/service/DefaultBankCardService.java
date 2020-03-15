package com.github.pangu.learning.discovery.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import com.github.pangu.learning.discovery.dubbo.api.model.BankCard;
import com.github.pangu.learning.discovery.dubbo.api.service.BankCardService;

@Service(version = "1.0.0")
public class DefaultBankCardService implements BankCardService{

    @Override
    public BankCard findCardInfo(String cardNo) {
        return null;
    }

}
