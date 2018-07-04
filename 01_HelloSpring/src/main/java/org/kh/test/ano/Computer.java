package org.kh.test.ano;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("com") // 서블릿에서 com 이라는 이름으로 찾음
public class Computer {
	@Resource(name = "sony") //아래를 합친것이 Resource
	
	/*
	@Autowired // Speaker 클래스를 연결함 (클래스에 component가 붙어있으면 전부 객체생성됨)
	@Qualifier("apple") // 그중에서 apple Speak를 사용하겠다
	*/
	private Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
		
	public Computer() {
		System.out.println("컴퓨터 객체 생성 성공~!");
	}
	
	public void powerOn() {
		System.out.println("컴퓨터가 켜졌습니다,");
	}
	
}
