package com.gopher.zkd1.service.dubbo;

import com.gopher.api.service.dubbo.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;

/**
 * @author 6c6763
 * @date 2020/10/26
 */
@Service(group = "local")
public class Zkd1Service implements HelloService {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private String port;


    @lombok.SneakyThrows
    @Override
    public String say(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        rpcContext.setAttachment("ip", InetAddress.getLocalHost().getHostAddress());
        return appName + " say: " + name + " from: " + rpcContext.getAttachment("ip")+":"+port;
    }
}
