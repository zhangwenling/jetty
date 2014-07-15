package jetty.service;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class InternetService {

	public static final int PORT = 8081;
	public static final String CONTEXT = "/jwt_internet_service";
	public static final String BASE_URL = "http://localhost:8081/jwt_internet_service";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\jwt_internet_service\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
