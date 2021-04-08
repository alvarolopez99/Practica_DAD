package com.example.demo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.SocketFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.Sapiotheca;


@Component
public class FilterService {
	
	
	
	public String filtrarLenguaje(String input) {
		
		final Logger LOGGER=LoggerFactory.getLogger(Sapiotheca.class);
		String response = "";
		String host = "127.0.0.1";
		int port = 9999;
		SocketFactory ssf = SocketFactory.getDefault();

		
		try {
			//Leer de la entrada estandar, enviar al servidor por el socket, leer del socket e imprimir

			Socket socket = ssf.createSocket(host, port); 	//Socket socket = new Socket(host, port);
			InputStreamReader InStrReaderStn = new InputStreamReader(System.in);
			BufferedReader BRStdIn = new BufferedReader(InStrReaderStn);
			InputStreamReader InStrReaderSocket = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderSocket);
			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			String line;
		
			PWSocketOut.println(input);
			PWSocketOut.flush();
	
			response = BRSocketIn.readLine();
			//System.out.println();
			//LOGGER.info("MENSAJE FILTRADO: " + response);
				
			BRSocketIn.close();
			socket.close();
			PWSocketOut.close();
			
		}  catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
}
