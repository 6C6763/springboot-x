package com.gopher.zkd2.service.dubbo;

import com.gopher.api.service.dubbo.HelloService;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * @author 6c6763
 * @date 2020/10/26
 */
@Service(interfaceName = "zkd2Service",loadbalance = "leastactive",group = "remote")
public class Zkd2Service implements HelloService {


    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private String port;

    @SneakyThrows
    @Override
    public String say(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        rpcContext.setAttachment("ip", InetAddress.getLocalHost().getHostAddress());
        return appName + " say: " + name + " from: " + rpcContext.getAttachment("ip")+":"+port;
    }
}
