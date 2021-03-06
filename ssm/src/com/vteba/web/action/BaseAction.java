package com.vteba.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.vteba.service.context.RequestContextHolder;
import com.vteba.util.web.HtmlUtils;

/**
 * 控制器基类，提供一些工具方法，简化控制器的实现。
 * @author yinlei
 * date 2013-8-23 下午7:08:37
 */
public class BaseAction {
	private static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
	
	public final static String SUCCESS = "success";

	public final static String MSG = "msg";

	public final static String DATA = "data";

	public final static String LOGOUT_FLAG = "logoutFlag";

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	/**
	 * 获取IP地址
	 * @param request HttpServletRequest
	 * @return IP地址
	 */
	public String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 所有ActionMap 统一从这里获取
	 * @return
	 */
	public Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		// 添加url到 Map中
		//rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}

	public ModelAndView forword(String viewName, Map<String, ?> context) {
		return new ModelAndView(viewName, context);
	}
	
	public ModelAndView error(String errMsg) {
		return new ModelAndView("error_all");
	}

	/**
	 * 提示成功信息
	 * @param message
	 */
	public void sendSuccessMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtils.writerJson(response, result);
	}

	/**
	 * 提示失败信息
	 * @param message
	 */
	public void sendFailureMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		HtmlUtils.writerJson(response, result);
	}
	
	public HttpServletRequest getRequest() {
		return RequestContextHolder.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return RequestContextHolder.getResponse();
	}
	
	public HttpSession getSession() {
		return RequestContextHolder.getSession();
	}
	
	/**
	 * 向客户端输出指定格式的文档。
	 * @param response 		响应
	 * @param text   		要发的内容
	 * @param contentType   发送的格式
	 */
	public void response(HttpServletResponse response, String text, String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			logger.info("向客户端输出时发生异常 。content=[" + text + "]", e);
		}
	}

	/**
	 * 直接输出json。
	 * @param text 要输出的json内容
	 */
	public void renderJson(String json) {
		response(getResponse(), json, "application/json;charset=UTF-8");
	}

	/**
	 * 直接输出纯HTML。
	 * @param text 要输出的html内容
	 */
	public void renderHtml(String text) {
		response(getResponse(), text, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出纯字符串。约定：返回1，刷新页面；返回文本，alert。
	 * @param text 要输出的内容
	 */
	public void renderText(String text) {
		response(getResponse(), text, "text/plain;charset=UTF-8");
	}
}
