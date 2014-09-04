package com.rx.chart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rx.chart.common.Constants;
import com.rx.chart.util.Util;

public class SendMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String message = request.getParameter("message");
		message = session.getId() + ":" + message;

		Constants.messages.add(message);

		// 唤醒全部更新列表
		Util.wakeUpAllThread();

		Util.out(response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
