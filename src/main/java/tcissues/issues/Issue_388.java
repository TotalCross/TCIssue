package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.MaterialWindow;
import totalcross.ui.Presenter;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;

public class Issue_388 extends BaseIssue {

	public Issue_388() {
		super("TC5 issue with screen rotation", "Screen Rotation NPE", 388, false);
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
						new PortraitOnlyWindow().popup();
					}
				});
				
				add(b, CENTER, CENTER, 280 + DP, 80 + DP);
			}
		};
	}

	private class PortraitOnlyWindow extends MaterialWindow {
		public PortraitOnlyWindow() {
			super("Rotate your Phone", false, new Presenter() {
				@Override
				public Container getView() {
					return new Container();
				}
			});
		}
		
		@Override
		public void screenResized() {
			if (Settings.isLandscape()) {
				MessageBox mb = new MessageBox("Attention",
						"This program must be run in portrait mode.\nPlease rotate the device.", null) {
					public void setRect(int x, int y, int w, int h) {
						super.setRect(x, y, Settings.screenWidth, Settings.screenHeight);
					}
				};
				mb.transitionEffect = TRANSITION_NONE;
				mb.popupNonBlocking();
				while (Settings.isLandscape()) {
					pumpEvents();
				}
				
				mb.unpop();
			} else {
				super.screenResized();
			}
		}
	}
}
