package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class Moment {
	public static final int PORT = 9093;
	public static final String CONTEXT = "/moment";
	public static final String BASE_URL = "http://localhost:9093/moment";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\moment\\trunk\\code\\moment\\webapp");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
