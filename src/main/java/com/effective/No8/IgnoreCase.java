package com.effective.No8;

public class IgnoreCase {

	public String str;
	public IgnoreCase(String s) {
		// TODO Auto-generated constructor stub
		this.str=s;
	}
	/* (non-Javadoc)
	 * equals重写的参数类型必须是Object，否则你要重写Object的equals才行
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof IgnoreCase){
			return this.str.equalsIgnoreCase(((IgnoreCase)obj).str);
		}
		return false;
	}
}
