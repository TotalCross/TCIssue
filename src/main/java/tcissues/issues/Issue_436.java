package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.gfx.Color;

public class Issue_436 extends BaseIssue {
	public Issue_436() {
		super("Os botões ficam com borda branca quando definido como transparent?", "Botões Borda Branca", 436, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Button button = new Button("<");
				button.setForeColor(Color.BLACK);
				button.transparentBackground = true;
				button.setBorder(BORDER_NONE);
				button.setNinePatch(null);

				add(button, CENTER, CENTER);
			}
		};
	}
}
