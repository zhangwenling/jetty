package com.jetty;

import org.mortbay.jetty.Server;

import com.jetty.utils.JettyUtils;

/**
 * 使用Jetty运行调试Web应用,在Console输入回车停止服务.
 * 
 * @author calvin
 */
public class Start {
	public static void main(String[] args) throws Exception {
		try {
			int port = Integer.valueOf(args[0]);
			String context = args[1];
			String dir = args[2];
			Server server = JettyUtils.buildNormalServer(port, context, dir);
			server.start();

			System.out.println("Hit Enter in console to stop server");
			if (System.in.read() != 0) {
				server.stop();
				System.out.println("Server stopped");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
