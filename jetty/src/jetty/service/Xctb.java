package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class Xctb {
	public static final int PORT = 80;
	public static final String CONTEXT = "/xctb";
	public static final String BASE_URL = "http://localhost:80/xctb";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\xctb\\trunk\\code\\xctb\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
