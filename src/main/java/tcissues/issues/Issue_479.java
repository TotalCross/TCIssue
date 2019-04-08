package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.ui.Container;
import totalcross.ui.PushButtonGroup;

public class Issue_479 extends BaseIssue {

	public Issue_479() {
		super("Lentidão ao Utilizar o PushButtonGroup", "Lentidão PushButton Group", 479, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				String[] botoes = new String[12];
				botoes[0] = "0";
				botoes[1] = "1";
				botoes[2] = "2";
				botoes[3] = "3";
				botoes[4] = "4";
				botoes[5] = "<";
				botoes[6] = "5";
				botoes[7] = "6";
				botoes[8] = "7";
				botoes[9] = "8";
				botoes[10] = "9";
				botoes[11] = "OK";

				PushButtonGroup pbg = new PushButtonGroup(botoes, 1, 2);
				pbg.setBackForeColors(Colors.BACKGROUND, Colors.ON_BACKGROUND);
				pbg.setFocusLess(true);
				
				add(pbg, LEFT, TOP, FILL, SCREENSIZE + 15);
			}
		};
	}

}
