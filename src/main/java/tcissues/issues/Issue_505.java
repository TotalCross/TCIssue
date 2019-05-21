package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;

public class Issue_505 extends BaseIssue {

	public Issue_505() {
		super("Erro ao implementar o Edit().setDecimalPlaces()", "idk might change later", 505, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Edit editQtd = new Edit();
				editQtd.setDecimalPlaces(3);
				editQtd.setMode(Edit.CURRENCY, true);
				editQtd.setText(String.valueOf(5));
				editQtd.autoSelect = true;
				add(editQtd, LEFT, TOP + 50, PREFERRED, DP + 50);
			}
		};
	}

}
