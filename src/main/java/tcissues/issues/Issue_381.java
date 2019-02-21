package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.TabbedContainer;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;

public class Issue_381 extends BaseIssue {

	public Issue_381() {
		super("Distorção no tamanho do botão no TabbedContainer" , "TabbedContainer Issues", 381);
	}

	@Override
	protected Container InitIssue() {

		return new Container() {
			@Override
			public void initUI() {

				String[] caps = new String[9];
				for (int i = 0; i < caps.length; i++) {
					caps[i] = "Aba " + (i + 1);
				}

				TabbedContainer tc = new TabbedContainer(caps);
				tc.setType(TabbedContainer.TABS_TOP);
				tc.setBackColor(Color.DARK);
				tc.useOnTabTheContainerColor = true;
				add(tc, LEFT, TOP, FILL, PARENTSIZE);

			}
		};

	}


}
