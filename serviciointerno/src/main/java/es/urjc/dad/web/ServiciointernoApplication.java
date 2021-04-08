package es.urjc.dad.web;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiciointernoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciointernoApplication.class, args);

		final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);


		try {
			
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket socket = serverSocket.accept();
			
			LOGGER.info("*SE HAN CONECTADO*");
			
			InputStreamReader InStrReaderStn = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderStn);

			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			while(true) {
				//LOGGER.info("************");
				
				String  line = "";
				line = BRSocketIn.readLine();
				if (line !=null) {
				
					LOGGER.info("MENSAJE DEL CLIENTE: " + line);
					
					PWSocketOut.println("Hola cliente, soy el servidor");
					PWSocketOut.flush();
				}
				
				//PWSocketOut.println(line);
				//PWSocketOut.println("Soy el servidor");
				//PWSocketOut.flush();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		


	
	}

}
