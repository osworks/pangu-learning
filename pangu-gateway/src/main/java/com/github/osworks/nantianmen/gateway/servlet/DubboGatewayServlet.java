package com.github.osworks.nantianmen.gateway.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.servlet.HttpServletBean;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(urlPatterns = "/ntm/*")
public class DubboGatewayServlet extends HttpServletBean {

    private static final long serialVersionUID = -3688590685611733692L;

    private static GenericService genericService;
    private static ApplicationConfig applicationConfig;
    private static ReferenceConfig<GenericService> referenceConfig;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        applicationConfig = new ApplicationConfig();
        applicationConfig.setName("nantianmen-gateway");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://118.126.108.44:8848");
        applicationConfig.setRegistry(registryConfig);
        referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setGeneric("true");
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        log.info(DateUtil.now());
        referenceConfig.setInterface("com.github.osworks.nantianmen.admin.service.UserService");
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("default");
        genericService = referenceConfig.get();
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String",""}, new Object[]{"world"});
        log.info(result.toString());
        response.getWriter().println(result.toString());
    }
    
}
