package com.test;

/**
 * @Description 类说明
 * @author zzy
 * @date 2014年6月3日 下午6:26:17
 * @version V1.0.0
 */

public class BaseResponse {

	private int status;
	private String message;

	/**
	 * @return the staus
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param staus
	 *            the staus to set
	 */
	public void setStatus(int staus) {
		this.status = staus;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
