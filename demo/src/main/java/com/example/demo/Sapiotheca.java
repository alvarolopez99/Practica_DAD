package com.example.demo;

import java.util.NoSuchElementException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class Sapiotheca {

	public static void main(String[] args) {
		SpringApplication.run(Sapiotheca.class, args);
		
		//FASE 2 - 11/03/2021
		
		
		/*String host = "127.0.0.1";
		int port = 9999;
		
		try {
			//Leer de la entrada estandar, enviar al servidor por el socket, leer del socket e imprimir
			Socket socket = new Socket(host, port);
			
			InputStreamReader InStrReaderStn = new InputStreamReader(System.in);
			BufferedReader BRStdIn = new BufferedReader(InStrReaderStn);
			
			
			InputStreamReader InStrReaderSocket = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderSocket);
			
			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			String line;
			
			while(!(line = BRStdIn.readLine()).equals("x")) {
				
				PWSocketOut.println("HelloServer");
				
				String response = BRSocketIn.readLine();
				System.out.println();
				
			}
			
			
			BRSocketIn.close();
			socket.close();
			PWSocketOut.close();
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		*/


		
		
		
	}
	
}
