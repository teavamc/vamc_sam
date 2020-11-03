package com.teavamc.vamcsam.practice.gateway.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.gateway.domain
 * @date 2020/11/2 10:33
 */
@Data
public class ServerProcessDTO implements Serializable {

    /**
     * 服务器 ip
     */
    private String serverIp;

    /**
     * 端口
     */
    private String port;

    public ServerProcessDTO(String serverIp,String port){
        this.serverIp = serverIp;
        this.port = port;
    }

}
