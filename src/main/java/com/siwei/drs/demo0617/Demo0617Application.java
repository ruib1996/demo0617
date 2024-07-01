package com.siwei.drs.demo0617;

import com.siwei.drs.config.demodFtpConfig;
import com.siwei.drs.config.recvPlanFtpConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({demodFtpConfig.class, recvPlanFtpConfig.class})
@SpringBootApplication
public class Demo0617Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo0617Application.class, args);

    }

}
