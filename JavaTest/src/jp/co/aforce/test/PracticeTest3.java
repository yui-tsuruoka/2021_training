package jp.co.aforce.test;

import java.util.ArrayList;

public class PracticeTest3 {

	public static void main(String[] args) {
		//1.
		String[] tanaka = {"田中太郎", "男性", "27"};

		//2.
		System.out.println(tanaka[0]);

		//3.
		Employee employee = new Employee();
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		System.out.println(numbers);

		ArrayList<String> names = new ArrayList<>();
		names.add("田中太郎");
		names.add("佐藤花子");
		names.add("鈴木次郎");

		ArrayList<String> sex = new ArrayList<>();
		sex.add("男");
		sex.add("女");
		sex.add("男");

		ArrayList<Integer> ages = new ArrayList<>();
		ages.add(27);
		ages.add(22);
		ages.add(31);

	}

}
