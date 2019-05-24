package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;

public class Issue_532 extends BaseIssue
{

	public Issue_532() {
		super("Problemas com Edit utilizando Mascara fr", "Edit setDecimal", 532, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() { 
			@Override
			public void initUI() {
				Edit edit = new Edit("99:99");
				edit.setMode(Edit.NORMAL, true);
				edit.setKeyboard(Edit.KBD_NUMERIC);
				edit.caption = "H. Final";
				edit.capitalise = Edit.ALL_UPPER;
				add(edit, CENTER, CENTER);
			}
		};
	}

}
