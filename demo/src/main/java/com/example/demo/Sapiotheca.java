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


@SpringBootApplication
public class Sapiotheca {
	

	public static void main(String[] args) {
		SpringApplication.run(Sapiotheca.class, args);
			
		//FASE 2 - 11/03/2021
		final Logger LOGGER=LoggerFactory.getLogger(Sapiotheca.class);

		String host = "127.0.0.1";
		int port = 9999;
		SocketFactory ssf = SocketFactory.getDefault();

		
		try {
			//Leer de la entrada estandar, enviar al servidor por el socket, leer del socket e imprimir
			//Socket socket = new Socket(host, port);
			Socket socket = ssf.createSocket(host, port);
			InputStreamReader InStrReaderStn = new InputStreamReader(System.in);
			BufferedReader BRStdIn = new BufferedReader(InStrReaderStn);
			InputStreamReader InStrReaderSocket = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderSocket);
			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			String line;
		
			PWSocketOut.println("Hola servidor, soy el cliente");
			PWSocketOut.flush();
	
			int n = 1;
			
			String response = BRSocketIn.readLine();
			System.out.println();
			LOGGER.info("RESPUESTA DEL SERVIDOR: " + response +" *******");
				
			BRSocketIn.close();
			socket.close();
			PWSocketOut.close();
			
		}  catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
