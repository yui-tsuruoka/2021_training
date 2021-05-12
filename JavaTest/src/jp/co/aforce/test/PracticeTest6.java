package jp.co.aforce.test;

public class PracticeTest6 {

	public static void main(String[] args) {
		MinMax minMax = new MinMax();
		int a = 4;
		int b = 2;
		int c = 10;
		System.out.println(a + "と" + b + "と" + c + "のうち、最大のものは" + minMax.getMaxValue(a,b,c));
		System.out.println(a + "と" + b + "と" + c + "のうち、最小のものは" + minMax.getMinValue(a,b,c));

	}

}
