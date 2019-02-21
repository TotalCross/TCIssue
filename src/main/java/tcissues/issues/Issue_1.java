package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Label;

public class Issue_1 extends BaseIssue {
	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				add(new Label("EAEAEAEE"), CENTER, CENTER);
			}
		};
	}

	@Override
	public String getIssueName() {
		return "Test Issue";
	}

	@Override
	public String getIssueNickname() {
		return "First Issue :)";
	}

	@Override
	public int getIssueNumber() {
		return 1;
	}
}
