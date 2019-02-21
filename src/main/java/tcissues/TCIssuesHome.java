package tcissues;

import java.util.ArrayList;
import java.util.Comparator;

import tcissues.issues.Issue_369;
import tcissues.issues.Issue_388;
import tcissues.resources.Colors;
import tcissues.resources.Exec;
import tcissues.resources.Images;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.ImageControl;
import totalcross.ui.MainWindow;
import totalcross.ui.PopupMenu;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.image.ImageException;

public class TCIssuesHome extends Container {
	ArrayList<BaseIssue> issues;
	public TCIssuesHome() {
		issues = new ArrayList<BaseIssue>();
		issues.add(new Issue_369());
		issues.add(new Issue_388());
		
		issues.sort(new Comparator<BaseIssue>() {
			@Override
			public int compare(BaseIssue o1, BaseIssue o2) {
				return Integer.compare(o1.getIssueNumber(), o2.getIssueNumber());
			}
		});
	}
	
	@Override
	public void initUI() {
		setBackColor(Colors.PRIMARY);

		ImageControl ic = new ImageControl(Images.getTotalCrossLogo());
		ic.scaleToFit = true;
		ic.centerImage = true;
		add(ic, CENTER, TOP + 50, PARENTSIZE, PARENTSIZE + 20);
		
		Button goToGitlab = new Button("GitLab Website");
		goToGitlab.setBackForeColors(Colors.BLUE, Colors.WHITE);
		goToGitlab.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent arg0) {
				Exec.openUrl("https://gitlab.com/totalcross/TotalCross/issues");
			}
		});
		add(goToGitlab, CENTER, AFTER + 50, 280 + DP, 40 + DP);
		
		Button changeStyle = new Button("Change Style");
		changeStyle.setBackForeColors(Colors.BLUE, Colors.WHITE);
		changeStyle.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent arg0) {
				String popdata[] = { "Flat (deprecated)", "Vista (deprecated)", "Android (deprecated)", "Holo", "Material" };

				PopupMenu popmenu;
				try {
					popmenu = new PopupMenu("Style", popdata);
					PopupMenu.cancelString = "cancel";
					popmenu.enableCancel = true;
					popmenu.resize();
					popmenu.popup();
					
					byte style = (byte)(popmenu.getSelectedIndex() + 2);
					if (style < 2 || style > 6) {
						style = 6; // material
					}
							
					Control.ResetStyle();
					MainWindow.getMainWindow().setUIStyle(style);
				} catch (IOException | ImageException e) {
					e.printStackTrace();
				}
			}
		});
		add(changeStyle, CENTER, AFTER, 280 + DP, 40 + DP);
		
		for (BaseIssue issue : issues) {
			Button b = new Button(issue.getIssuePresentableName());
			b.setBackForeColors(Colors.BLUE, Colors.WHITE);
			b.addPressListener(new PressListener() {
				@Override
				public void controlPressed(ControlEvent arg0) {
					issue.ShowIssue();
				}
			});
			
			add(b, CENTER, AFTER, 280 + DP, 40 + DP);
		}
	}
}
