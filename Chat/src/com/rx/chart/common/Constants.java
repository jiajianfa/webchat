package com.rx.chart.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共属性
 * 
 * @author Renxin
 * 
 */
public class Constants {

	/**
	 * Session集合
	 */
	public static List<String> users = new ArrayList<String>();

	/**
	 * 消息集合
	 */
	public static List<String> messages = new ArrayList<String>();

	/**
	 * 会话线程映射 Key:SessionId Value:Thread
	 */
	public static Map<String, Thread> sessionThreadMapping = new HashMap<String, Thread>();

}
