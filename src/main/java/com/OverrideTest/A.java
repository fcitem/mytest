package com.OverrideTest;

class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}
	/*public String show(B obj){
		return ("A and B");
	}*/
}
