package com.message;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

/**
 * 使用Jetty运行调试Web应用,在Console输入回车停止服务.
 * 
 * @author calvin
 */
public class GatMessageService {

	public static final int PORT = 8002;
	public static final String CONTEXT = "/jwt_gat_message_service";
	public static final String BASE_URL = "http://localhost:8002/jwt_gat_message_service";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\workspaces\\jwt\\trunk\\code\\jwt_gat_message_service\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
