package com.rx.chart.listener;

import static com.rx.chart.common.Constants.users;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.rx.chart.util.Util;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent httpsessionevent) {

		users.add(httpsessionevent.getSession().getId());

		Util.wakeUpAllThread();

	}

	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {

		users.remove(httpsessionevent.getSession().getId());

		Util.wakeUpAllThread();

	}

}
