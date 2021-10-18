package com.mycompany.powermockito.introduction;

class CollaboratorForPartialMocking {

	static String staticMethod() {
		return "Hello Steve!";
	}

	final String finalMethod() {
		return "Hello Steve!";
	}

	private String privateMethod() {
		return "Hello Steve!";
	}

	String privateMethodCaller() {
		return privateMethod() + " Welcome to the Java world.";
	}
}