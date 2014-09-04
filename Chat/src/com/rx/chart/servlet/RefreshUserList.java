package com.rx.chart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rx.chart.common.Constants;
import com.rx.chart.util.Util;

public class RefreshUserList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 加入映射
		Constants.sessionThreadMapping.put(session.getId(), Thread
				.currentThread());

		// 等待
		try {
			synchronized (Thread.currentThread()) {
				// 阻塞当前请求
				Thread.currentThread().wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Util.out(response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
