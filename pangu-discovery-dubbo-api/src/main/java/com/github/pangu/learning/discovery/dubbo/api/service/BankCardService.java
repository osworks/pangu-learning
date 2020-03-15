package com.github.pangu.learning.discovery.dubbo.api.service;

import com.github.pangu.learning.discovery.dubbo.api.model.BankCard;

public interface BankCardService {
    
    BankCard findCardInfo(String cardNo);
    
}
