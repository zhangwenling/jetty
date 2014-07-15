package com.message.microxt;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

public class MicroxtService {
	public static final int PORT = 8080;
	public static final String CONTEXT = "/microxt";
	public static final String BASE_URL = "http://localhost:8080/microxt";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\workspaces\\microxt\\trunk\\code\\microxt\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
