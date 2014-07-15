package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class XctbOld {
	public static final int PORT = 8080;
	public static final String CONTEXT = "/XctbOld";
	public static final String BASE_URL = "http://localhost:8080/XctbOld";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\xctb\\trunk\\code\\xctb_old\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
