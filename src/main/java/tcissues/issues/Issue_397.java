package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.gfx.Color;

public class Issue_397 extends BaseIssue {

	Container header = null;
	Container body = null;
	Container footer = null;
	ScrollContainer sc = null;
	Edit houseno = null;
	Label name = null;

	public Issue_397() {
		super("Virtual keyboard issues", "Keyboard emulated visuals", 397, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				totalcross.ui.font.Font f = font.adjustedBy(1, false);
				header = new Container();
				body = new Container();
				footer = new Container();
				Settings.uiAdjustmentsBasedOnFontHeight = false;

				try {
					add(header);
					header.setRect(LEFT, TOP, SCREENSIZE, SCREENSIZE + 10);
					header.setBackColor(Color.BLUE);

					add(body);
					body.setRect(LEFT, AFTER, SCREENSIZE, SCREENSIZE + 80);
					body.setBackColor(Color.WHITE);

					add(footer);
					footer.setRect(LEFT, AFTER, SCREENSIZE, SCREENSIZE + 10);
					footer.setBackColor(Color.BLUE);

					name = new Label("House No ");
					body.add(name, LEFT, TOP);

					houseno = new Edit("XXXXXXXXXX");
					houseno.setFont(f);
					houseno.setKeyboard(Edit.KBD_KEYBOARD);
					body.add(houseno);
					houseno.setRect(AFTER, TOP, 100, 50);

				} catch (Exception e) {
					System.out.println("error " + e);
				}
			}

		};
	}

}
