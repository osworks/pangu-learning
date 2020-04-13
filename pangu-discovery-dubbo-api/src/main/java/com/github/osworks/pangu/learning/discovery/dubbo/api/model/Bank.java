package com.github.osworks.pangu.learning.discovery.dubbo.api.model;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Bank implements Serializable{
	
	private static final long serialVersionUID = -3008292194149248348L;
	
	private String id;
	private String name;	
}
