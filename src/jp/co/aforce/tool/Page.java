package jp.co.aforce.tool;

import java.io.PrintWriter;

//htmlの<head>部分と末尾をまとめたメソッドを作成する。（ここら辺は共通なのでまとめた方が使いやすい）

public class Page {

	public static void header(PrintWriter out) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("</head>");
		out.println("<body>");
	}

	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");

	}



}
