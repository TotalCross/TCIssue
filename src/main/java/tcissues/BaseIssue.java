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
	private String name;
	private String nickname;
	private int number;
	private boolean open;
	private MaterialWindow window;
	public BaseIssue(String name, String nickname, int number, boolean open) {
		this.name = name;
		this.nickname = nickname;
		this.number = number;
		this.open = open;
	}

	protected abstract Container InitIssue();

	public void ShowIssue() {
		window = new MaterialWindow(getIssuePresentableName(), false, new Presenter() {
			@Override
			public Control getView() {
				return InitIssue();
			}
		});

		final int buttonNumber = window.getBar().addButton(new Icon(MaterialIcons._OPEN_IN_NEW), true);
		window.getBar().addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				if (window.getBar().getSelectedIndex() == buttonNumber) {
					Exec.openUrl("https://gitlab.com/totalcross/TotalCross/issues/" + getIssueNumber());
				}
			}
		});
		window.popup();
	}
	
	public String getIssueName() {
		return name;
	}

	public String getIssueNickname() {
		return nickname;
	}

	public int getIssueNumber() {
		return number;
	}

	public String getIssuePresentableName() {
		String name = "#" + getIssueNumber() + " - " + getIssueNickname();
		if (name.length() > 30) {
			name = name.substring(0, 27) + "...";
		}

		return name;
	}
	
	public boolean isOpen() {
		return open;
	}

	public MaterialWindow getWindow() {
		return window;
	}

	public void setWindow(MaterialWindow window) {
		this.window = window;
	}
}
