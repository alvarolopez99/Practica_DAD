package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.services.FilterService;

@EnableCaching
@SpringBootApplication
public class Sapiotheca {
	
	static final Log LOGGER = LogFactory.getLog(Sapiotheca.class);
	
	//FASE 2 - 11/03/2021
	public static void main(String[] args) {
		SpringApplication.run(Sapiotheca.class, args);		
	}
	
    @Bean
    public CacheManager cacheManager() {
    	LOGGER.info("Activando caché...");
    	return new ConcurrentMapCacheManager("anuncios");
    }
	
}
