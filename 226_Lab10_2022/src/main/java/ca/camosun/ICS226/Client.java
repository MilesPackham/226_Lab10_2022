package ca.camosun.ICS226;

import java.io.*;
import java.net.*;

public class Client {

	protected String serverAddress;
	protected int serverPort;
	protected String message;

    /**
     * constructor for the client class
     * @param serverAddress the address to connect to
     * @param serverPort the port to connect to
     */
	public Client(String serverAddress, String serverPort) {
		this.serverAddress = serverAddress;
		this.serverPort = Integer.parseInt(serverPort);
	}

    /**
     * creates a single connection to the server
     * then sends user inputs from the console outputting
     * the server responses
     */
	public void connect() {
		try (
			Socket socket = new Socket(serverAddress, serverPort);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		) {
            while(true) {
                String input = Prompt.getUserInput();
                char[] inputBuffer = new char[1028];
                out.println(input);
                in.read(inputBuffer, 0, 1028);
                System.out.println(new String(inputBuffer));
            }
 		} catch (UnknownHostException e) {
			System.err.println(e);
			System.exit(-1);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-2);
		} catch (SecurityException e) {
			System.err.println(e);
			System.exit(-3);
		} catch (IllegalArgumentException e) {
			System.err.println(e);
			System.exit(-4);
		}
	}
}