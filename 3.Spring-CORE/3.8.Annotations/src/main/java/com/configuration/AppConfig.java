package com.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // In IOC a bean will be created with name zoomSoftware
    @Bean
    public Software zoomSoftware() {
        return new Software("Zoom", "V2.56");
    }

    @Bean
    public Software vsCodeSoftware() {
        return new Software("VS Code", "2023.12.*");
    }

    @Bean
    public Hardware getHardware() {
        return new Hardware("HardDisk", "Sandisk");
    }

    /**
     * If the bean which you want to create is injecting their dependencies using constructor
     * then follow the below method to inject the values
     */
    @Bean
    public Computer getComputer(@Qualifier("zoomSoftware") Software software, Hardware hardware) {
        return new Computer(software, hardware);
    }
}
