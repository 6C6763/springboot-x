package com.gopher.api.service.dubbo;

/**
 * @author 6c6763
 * @date 2020/10/26
 */
public interface HelloService {
    /**
     * dubbo-api say check
     *
     * @param name param
     * @return result
     */
    String say(String name);
}
