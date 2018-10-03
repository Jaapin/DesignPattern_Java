package com.dp.staticProxy;

public class SpeakerLogProxy implements Speaker {

	Speaker speaker;

	public SpeakerLogProxy(Speaker sp) {
		this.speaker = sp;
	}

	public void speak() {
		System.out.println("speakMathod: start:");

		speaker.speak();

		System.out.println("speakMathod: end:");
	}

}
