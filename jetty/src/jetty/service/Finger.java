package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class Finger {
	public static final int PORT = 8080;
	public static final String CONTEXT = "/finger";
	public static final String BASE_URL = "http://localhost:8080/finger";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\finger\\trunk\\code\\finger\\webapp");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
