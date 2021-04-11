package es.urjc.dad.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.urjc.dad.web.services.FilterService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

public class ProcesadorSockets implements Runnable{

	Socket socket;
	final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);
	FilterService filterService = new FilterService();
	
	public ProcesadorSockets(Socket socket) {
		this.socket = socket;
		}
	
	@Override
	public void run() {

		final Logger LOGGER=LoggerFactory.getLogger(ServiciointernoApplication.class);
		
		try {
			
			InputStreamReader InStrReaderStn = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderStn);

			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
				
				String Mensaje = BRSocketIn.readLine();
				
				if (Mensaje !=null) {
		
					Mensaje = filterService.filtrarLenguaje(Mensaje);
					PWSocketOut.println(Mensaje);
					PWSocketOut.flush();
				}
		
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
	}

}
