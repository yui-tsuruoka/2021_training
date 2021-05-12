package jp.co.aforce.test;

import java.util.ArrayList;
import java.util.Calendar;

public class PracticeTest4 {

	public static void main(String[] args) {

		//1.
		//②が適切。
		//←文字列は参照型であり、str1 ==str2 は、参照先の比較をしていることになるから。

		//2.
		ArrayList<String> animals = new ArrayList<>();
		animals.add("犬");
		animals.add("猫");
		animals.add("うさぎ");
		animals.add("へび");

		//3.
		String animal = "ちんあなご";
		if(animals.contains(animal)) {
			System.out.println(animal + "はリストに含まれています");
		}else {
			System.out.println(animal + "はリストに含まれていません");
		}

		//4.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();

		int birthYear = 4;

		switch(birthYear) {
		case 1:
			System.out.println("元日、成人の日");
			break;
		case 2:
			System.out.println("建国記念の日、天皇誕生日");
			break;
		case 3:
			System.out.println("春分の日");
			break;
		case 4:
			System.out.println("昭和の日");
			break;
		case 5:
			System.out.println("憲法記念日、みどりの日、こどもの日");
			break;
		case 6:
			System.out.println("なし");
			break;
		case 7:
			System.out.println("海の日、スポーツの日");
			break;
		case 8:
			System.out.println("山の日");
			break;
		case 9:
			System.out.println("敬老の日、秋分の日");
			break;
		case 10:
			System.out.println("なし");
			break;
		case 11:
			System.out.println("文化の日、勤労感謝の日");
			break;
		case 12:
			System.out.println("なし");
			break;
		}

//		なぜswitchを選んだのか
//		←値によって処理を分岐するから。値が1~12の数値でswitchの方が見やすいから。

	}

}
