package com.effective.No8;

public class IgnoreCase {

	public String str;
	public IgnoreCase(String s) {
		this.str=s;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IgnoreCase){
			return this.str.equalsIgnoreCase(((IgnoreCase)obj).str);
		}
		return false;
	}
}
