package com.dp.dynamicProxy;
public class SpeakerTimeProxy implements Speaker {
	Speaker speaker;
	public SpeakerTimeProxy(Speaker sp) {
		super();
		this.speaker = sp;
	}
	public void speak() {
		long start = System.currentTimeMillis();
		speaker.speak();
		long end = System.currentTimeMillis();
		System.out.println("speakMathod: costTime:" + (end - start));
	}
}