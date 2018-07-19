package org.kh.member.common;

public class Log4jAdvice {
	public void printLogging() {
		System.out.println("[공통로그 - Log4j] : 비즈니스 로직 수행 전 로그 기록");
	}
	public void printTransactionLog() {
		System.out.println("[트랜잭션 로그 - Log4j] : 트랜잭션 처리 로그");
	}
}
