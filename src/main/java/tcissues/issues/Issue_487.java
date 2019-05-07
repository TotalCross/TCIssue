package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Issue_487 extends BaseIssue {

	public Issue_487() {
		super("", "", 487, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Button b;
				try {
					b = new Button("Fotografia", new Image("images/find.png").getSmoothScaledInstance(24, 24), LEFT,
							36);
					add(b, CENTER, AFTER + 8, PREFERRED, PREFERRED + 28);
				} catch (IOException | ImageException e) {
					e.printStackTrace();
				}
			}
		};
	}

}
