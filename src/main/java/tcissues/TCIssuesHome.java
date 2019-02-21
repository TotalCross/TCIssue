package tcissues;

import java.util.ArrayList;

import tcissues.issues.Issue_1;
import tcissues.issues.Issue_388;
import tcissues.resources.Colors;
import tcissues.resources.Exec;
import tcissues.resources.Images;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.image.Image;

public class TCIssuesHome extends Container {
	ArrayList<BaseIssue> issues;
	public TCIssuesHome() {
		issues = new ArrayList<BaseIssue>();
		issues.add(new Issue_1());
		issues.add(new Issue_388());
	}
	
	@Override
	public void initUI() {
		setBackColor(Colors.PRIMARY);

		ImageControl ic = new ImageControl(Images.getTotalCrossLogo());
		ic.scaleToFit = true;
		ic.centerImage = true;
		add(ic, CENTER, TOP + 50, PARENTSIZE, PARENTSIZE + 20);

		add(new Label("Issues List"), CENTER, AFTER + 20);
		Button goToGitlab = new Button("GitLab Website");
		goToGitlab.setBackForeColors(Colors.BLUE, Colors.WHITE);
		goToGitlab.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent arg0) {
				Exec.openUrl("https://gitlab.com/totalcross/TotalCross/issues");
			}
		});
		add(goToGitlab, CENTER, AFTER, 280 + DP, 40 + DP);
		
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
