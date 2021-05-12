package jp.co.aforce.test;

public class PracticeTest7 {

	public static void main(String[] args) {
		Airplane airplane = new Airplane();
		Fighter fighter = new Fighter();

		//飛行機が飛行する
		airplane.fly();

		//戦闘機が飛行する
		fighter.fly();

		//戦闘機が戦闘する
		fighter.fight();


	}

}
