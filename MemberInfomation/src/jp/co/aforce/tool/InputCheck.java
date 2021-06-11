package jp.co.aforce.tool;
/*nullであることはつかめるが、なぜかnameはnullであってもデータの追加ができてしまう。
 * また、nameは空値であってもcatchのエラーに引っかからない。catchって何を取ってくんの？
 * おそらくnameだけString型であることに関係しているような気がする。
*/
public class InputCheck {
	public boolean requiredCheck(String input){
		if(input.equals("")){
			return false;
		}else {
			return true;
		}
	}

	//うまく使えなかった。
	public boolean numberCheck(int number) {
		if(number != 0) {
			return true;
		}else {
			return false;
		}

	}

}
