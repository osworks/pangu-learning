package com.github.osworks.pangu.learning.discovery.dubbo.api.service;

import com.github.osworks.pangu.learning.discovery.dubbo.api.model.Bank;

public interface BankService {
    
    Bank findBankInfo(String id);
    
}
