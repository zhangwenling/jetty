package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class JgzfService {
	public static final int PORT = 9093;
	public static final String CONTEXT = "/jgzfService";
	public static final String BASE_URL = "http://localhost:9093/jgzfService";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\jgzf\\trunk\\code\\jgzfService\\webapp");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
