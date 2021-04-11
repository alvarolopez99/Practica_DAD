package com.example.demo;

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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.services.FilterService;


@SpringBootApplication
public class Sapiotheca {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Sapiotheca.class, args);
			
		//FASE 2 - 11/03/2021
		final Logger LOGGER=LoggerFactory.getLogger(Sapiotheca.class);
		
	}
	
}
