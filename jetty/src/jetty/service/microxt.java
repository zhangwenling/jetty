package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class microxt {
	public static final int PORT = 9090;
	public static final String CONTEXT = "/microxt";
	public static final String BASE_URL = "http://localhost:9090/microxt";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\microxt\\trunk\\code\\microxt\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
