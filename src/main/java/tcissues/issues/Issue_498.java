package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Toast;
import totalcross.ui.font.Font;

public class Issue_498 extends BaseIssue{

	public Issue_498() {
		super("Toast.show não está aceitando quebra de linha \"\\n\"", "Toast quebra de linha", 498, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Button button = new Button("Click here");
				button.addPressListener(e -> {
					Toast.show("Test text with \na break line.", 2000, this.getParentWindow());
				});
				add(button, CENTER, CENTER);
			}
		};
	}

}
