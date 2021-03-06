package com.other.test;

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		try {
			try {
				throw new Sneeze();
			} catch (Annoyance a) {     //能使用父类型的地方一定能使用子类型
				System.out.println("Caught Annoyance");
				throw a;
			}
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
			return;
		} finally {
			System.out.println("Hello World!");
		}
	}
}
class Annoyance extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

class Sneeze extends Annoyance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
