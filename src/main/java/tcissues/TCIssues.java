package tcissues;

import tcissues.resources.Colors;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class TCIssues extends MainWindow {
	SideMenuContainer sideMenu;
	
	static {
		Settings.applicationId = "VKSS";
		Settings.appVersion = "2.0.1";
		Settings.iosCFBundleIdentifier = "com.totalcross.showcase";
	}

	public TCIssues() {
		super("TotalCross Issues", NO_BORDER);

		setUIStyle(Settings.MATERIAL_UI);
		Settings.uiAdjustmentsBasedOnFontHeight = true;
		setBackForeColors(Colors.BACKGROUND, Colors.SURFACE);

		sideMenu = new SideMenuContainer(null, 
				new SideMenuContainer.Item("Home", MaterialIcons._HOME, Color.BLACK, false, () -> { return new TCIssuesHome(); })
				);

		sideMenu.topMenu.header = new Container() {
			@Override
			public void initUI() {
				try {
					setBackColor(Colors.SECONDARY);

					Label title = new Label("Issues", LEFT, Color.WHITE, false);
					title.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 5));
					title.setForeColor(Color.WHITE);
					add(title, LEFT + 45, BOTTOM - 30, FILL, DP + 56);

					ImageControl profile = new ImageControl(new Image("images/logoV.png"));
					profile.scaleToFit = true;
					profile.transparentBackground = true;
					add(profile, LEFT + 45, TOP + 150, PREFERRED, FIT);
				} catch (IOException | ImageException e) {
					e.printStackTrace();
				}
			}
		};

		sideMenu.setBarFont(Font.getFont(Font.getDefaultFontSize() + 5));
		sideMenu.setBackColor(Colors.PRIMARY);
		sideMenu.setForeColor(Color.WHITE);
		sideMenu.setItemForeColor(Color.BLACK);
		sideMenu.topMenu.drawSeparators = false;
		sideMenu.topMenu.itemHeightFactor = 3;
	}

	@Override
	public void initUI() {
		add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
	}
}