package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.NoSuchElementException;

import javax.net.SocketFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.services.FilterService;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class Sapiotheca {
	
	static final Log LOGGER = LogFactory.getLog(Sapiotheca.class);
	
	//FASE 2 - 11/03/2021
	public static void main(String[] args) {
		SpringApplication.run(Sapiotheca.class, args);		
	}
	
    @Bean
    public CacheManager cacheManager() {
    	LOGGER.info("Activando caché...");
    	return new ConcurrentMapCacheManager("cacheSapiotheca");
    }
    
    @Bean
    public Config config() {
	    Config config = new Config();
	    JoinConfig joinConfig = config.getNetworkConfig().getJoin();
	    joinConfig.getMulticastConfig().setEnabled(false);
	    joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
	    return config;
    }
	
}
