package com.github.pangu.learning.discovery.http.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BankCard implements Serializable{
	
	private static final long serialVersionUID = -3008292194149248348L;
	
	private String cardNo;
	private String name;
	private BigDecimal balance;
	
}
