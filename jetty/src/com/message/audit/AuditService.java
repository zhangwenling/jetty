package com.message.audit;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

/**
 * 使用Jetty运行调试Web应用,在Console输入回车停止服务.
 * 
 * @author calvin
 */
public class AuditService {

	public static final int PORT = 8080;
	public static final String CONTEXT = "/jwt_audit_service";
	public static final String BASE_URL = "http://localhost:8080/jwt_audit_service";

	public static void main(String[] args) throws Exception {
		Server server = JettyUtils.buildNormalServer(PORT, CONTEXT, "D:\\project\\jgzf\\trunk\\code\\jwt_audit_service\\WebRoot");
		server.start();

		System.out.println("Hit Enter in console to stop server");
		if (System.in.read() != 0) {
			server.stop();
			System.out.println("Server stopped");
		}
	}
}
