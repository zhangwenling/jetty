/**
 * 项目microxt -包 com.microxt.utils
 * <p>File: JettyUtils.java 创建时间:2013-6-3上午11:39:55</p> 
 * <p>Title: 标题（要求能简洁地表达出类的功能和职责）</p>
 * <p>Description: 描述（简要描述类的职责、实现方式、使用注意事项等）</p>
 * <p>Copyright: Copyright (c) 2013 河南亿众科技有限公司</p>
 * <p>Company: 河南亿众科技有限公司</p>
 * @author 陈帅
 * @version 1.0
 * @history 修订历史（历次修订内容、修订人、修订时间等）

 */

package com.jetty.utils;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppClassLoader;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * @author 陈雷
 * 
 */
public class JettyUtils {

	/**
	 * 创建用于正常运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
	 * @param base TODO
	 */
	public static Server buildNormalServer(int port, String contextPath, String path) {
		Server server = new Server(port);
		try {
			WebAppContext webContext = new WebAppContext(path, contextPath);
			webContext.setClassLoader(new WebAppClassLoader(Thread.currentThread().getContextClassLoader(),webContext));
			server.setHandler(webContext);
			server.setStopAtShutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return server;
	}
}
