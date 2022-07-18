package com.mis.kill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mis.kill.pojo")
public class KillApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillApplication.class, args);
    }

}
