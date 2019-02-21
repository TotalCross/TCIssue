package tcissues;

import tcissues.resources.Exec;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.MaterialWindow;
import totalcross.ui.Presenter;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public abstract class BaseIssue {
	public abstract String getIssueName();

	public abstract String getIssueNickname();

	public abstract int getIssueNumber();

	public String getIssuePresentableName() {
		String name = "#" + getIssueNumber() + " - " + getIssueName();
		if (name.length() > 30) {
			name = name.substring(0, 27) + "...";
		}

		return name;
	}

	protected abstract Container InitIssue();

	public void ShowIssue() {
		MaterialWindow mw = new MaterialWindow(getIssuePresentableName(), false, new Presenter() {
			@Override
			public Control getView() {
				return InitIssue();
			}
		});

		final int buttonNumber = mw.getBar().addButton(new Icon(MaterialIcons._OPEN_IN_NEW), true);
		mw.getBar().addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				if (mw.getBar().getSelectedIndex() == buttonNumber) {
					Exec.openUrl("https://gitlab.com/totalcross/TotalCross/issues/" + getIssueNumber());
				}
			}
		});
		mw.popup();
	}
}
