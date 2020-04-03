package com.dream.utils;

/**
 * @program: dream-socket-webapp .
 * @description: 消息 .
 * @author: ning .
 * @create: 2020-03-27 10:43 .
 */
public class Message {
	private String name;
	private MessageType type;
	private String content;
	public  Message() {
	}
	public  Message(String name) {
		this.name = name;
	}

	public  Message(String name, MessageType type) {
		this.name = name;
		this.type = type;
	}

	public  Message(String name, MessageType type, String content) {
		this.name = name;
		this.type = type;
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("name:").append(this.name).append(";")
				.append("type:").append(this.type).append(";")
				.append("content:").append(this.content).append(";");
		return stringBuilder.toString();
	}

	public String getName() {
		return name;
	}

	public MessageType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public enum MessageType {
		INFO,
		WARN,
		ERROR
	}
}
