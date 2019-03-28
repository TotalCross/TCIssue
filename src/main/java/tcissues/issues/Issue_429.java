package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.gfx.Color;
import totalcross.util.regex.Matcher;
import totalcross.util.regex.Pattern;

public class Issue_429 extends BaseIssue {
	public Issue_429() {
		super("Erro ninepatch quando usado efeito TranslucentShape no Button", "TrasnlucentShape", 429, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI();
				Button button = new Button("TESTE");
				button.setTranslucent(TranslucentShape.RECT);
				button.setForeColor(Color.WHITE);
				add(button, LEFT, TOP, FILL, PREFERRED	);
			}
		};
	};
}
