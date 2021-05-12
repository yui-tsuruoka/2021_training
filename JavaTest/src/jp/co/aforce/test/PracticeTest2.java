package jp.co.aforce.test;

import java.util.Random;

public class PracticeTest2 {

	public static void main(String[] args) {
		int x = 10;
		int y = 28;
		double z = 3.14;

		//1.
		System.out.println(x * y);

		//2.
		System.out.println(y / x);
		System.out.println(y % x);

		//3.
		double multi = y * z;
		System.out.println(multi);

		//4.
		multi++;
		System.out.println(multi);

		//5.
		int age = 23;
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);

		System.out.println("r=" + randomNumber);
		if(age > randomNumber) {
			System.out.println("私の方が年上です");
		}else if(age < randomNumber) {
			System.out.println("私の方が年下です");
		}else {
			System.out.println("私と同い年です");
		}


	}

}
