package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.ImageException;

public class Issue_497 extends BaseIssue {
	public Issue_497() {
		super("Comportamentos problemáticos com o Flick", "Flick Issue", 497, true);
	}

	@Override
	protected Container InitIssue() {
		return new ScrollContainer() {
			private void MakeMaterialIcons() {
				final int ICON_WIDTH = 64;
				int cols = (int)(Math.min(Settings.screenWidth, Settings.screenHeight)
						/ (ICON_WIDTH * Settings.screenDensity));

				
				for (int i = 0, j = 0; i < 10; i++, j++) {
					Icon icon = new Icon(MaterialIcons.values()[i]);
					icon.setFont(icon.getFont().adjustedBy(10));
					add(icon, (j % cols) == 0 ? LEFT : AFTER, (j % cols) == 0 ? AFTER : SAME, PARENTSIZE + (100 / cols),
							DP + ICON_WIDTH);
				}
			}
			
			private void CreateTextOnlyTabbedContainer() {
				final int gap = (int)(Settings.screenDensity * 30);
				String[] caps = new String[3];
				caps[0] = "Home";
				caps[1] = "Photos";
				caps[2] = "Profile";
				
				
				Label sampleTitle = new Label("This is a text only Tabbed Container", CENTER);
				sampleTitle.autoSplit = true;
				add(sampleTitle, LEFT + gap, AFTER + gap*2, FILL - gap, PREFERRED);
				
				Container spacing = new Container();
				add(spacing, LEFT + gap*2, AFTER + gap/2, FILL - gap*2, (int) (Settings.screenHeight * 0.3));
				
				final TabbedContainer tc = new TabbedContainer(caps);
				tc.setType(TabbedContainer.TABS_BOTTOM);
				tc.setBackColor(Color.DARK);
				tc.getContainer(0).setBackColor(0x73b1eb);
				tc.getContainer(1).setBackColor(0x5ba0e7);
				tc.getContainer(2).setBackColor(0x4a91e2);
				tc.useOnTabTheContainerColor = true;
				tc.allSameWidth = true;
				tc.extraTabHeight = fmH / 2;
				spacing.add(tc, LEFT, TOP, FILL, PARENTSIZE);
				for(int i = 0; i < 3; i++)
					tc.getContainer(i).add(new Label("Container " + (i+1)), CENTER, CENTER);
			}
			
			@Override
			public void initUI() {
				CreateTextOnlyTabbedContainer();
				for (int i = 0; i < 10; i++) {
					MakeMaterialIcons();
					MakeMaterialIcons();
					MakeMaterialIcons();
					MakeMaterialIcons();
				}
			}
		};
	}
}
