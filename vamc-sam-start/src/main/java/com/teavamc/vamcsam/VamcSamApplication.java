package com.teavamc.vamcsam;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.teavamc.vamsam.dubboutils.EnableDubboUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@EnableDubbo(scanBasePackages = {"com.teavamc.vamcsam.service.dubbo"})
@MapperScan("com.teavamc.vamcsam.dao")
@EnableDubboUtil
public class VamcSamApplication {

    public static void main(String[] args) {
        SpringApplication.run(VamcSamApplication.class, args);
        log.info("Every thing will perfect!");
    }

}
