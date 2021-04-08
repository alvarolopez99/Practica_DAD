package es.urjc.dad.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcesadorSockets implements Runnable{

	Socket socket;
	final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);
	
	public ProcesadorSockets(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);
		int puerto = 9999;
		
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
