package jp.co.aforce.test;

public class MinMax {
	//PracticeTest6に付随

	//最大値を求めるメソッド
	int getMaxValue(int x, int y, int z) {
		if(x > y) {
			if(x > z) {
				return x;
			}else{
				return z;
			}
		}else {
			if(y > z) {
				return y;
			}else {
				return z;
			}
		}
	}

	//最小値を求めるメソッド
	int getMinValue(int x, int y, int z) {
		if(x > y) {
			if(y > z) {
				return z;
			}else {
				return y;
			}
		}else {
			if(x > z) {
				return z;
			}else {
				return x;
			}
		}
	}


}
