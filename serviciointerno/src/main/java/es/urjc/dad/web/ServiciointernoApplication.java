package es.urjc.dad.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiciointernoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciointernoApplication.class, args);
		
		




/*try {
			
			ServerSocket serverSocket = new ServerSocket(9999);
			
			Socket socket = serverSocket.accept();
			
			InputStreamReader InStrReaderStn = new InputStreamReader(socket.getInputStream());
			BufferedReader BRSocketIn = new BufferedReader(InStrReaderStn);

			PrintWriter PWSocketOut = new PrintWriter(socket.getOutputStream()); //Para escribir en el socket
			
			
			while(true) {
				
				//String line = BRSocketIn.readLine();
				//PWSocketOut.println(line);
				PWSocketOut.println("HelloClient");
				PWSocketOut.flush();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		*/







		
		
		
	}

}
