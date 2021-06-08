package jp.co.aforce.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//実行するという動作の抽象クラス。ログイン処理においても継承して使う。

public abstract class Action {
	public abstract String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception;

}

