package com.github.osworks.pangu.learning.discovery.dubbo.api.service;

import com.github.osworks.pangu.learning.discovery.dubbo.api.model.BankCard;

public interface BankCardService {
    
    BankCard findCardInfo(String cardNo);
    
}
