package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.PopupMenu;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;

public class Issue_369 extends BaseIssue {

	public Issue_369() {
		super("Problem with Popupmenu TC5", "PopupMenu Issues", 369);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Button b = new Button("Open Window");
				b.setBackForeColors(Colors.BLUE, Colors.WHITE);
				b.addPressListener(new PressListener() {
					@Override
					public void controlPressed(ControlEvent arg0) {
						try {
							String popdata[] = { "menu1", "menu2" };

							PopupMenu popmenu = new PopupMenu("Menu ", popdata);
							PopupMenu.cancelString = "cancel";
							popmenu.initUI();
							popmenu.enableCancel = true;
							popmenu.resize();
							popmenu.popup();
						} catch (Exception e) {
							System.out.println("error " + e);
						}
					}
				});
				
				add(b, CENTER, CENTER, 280 + DP, 80 + DP);
			}
		};
	}
}