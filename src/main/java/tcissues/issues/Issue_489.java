package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.MultiEdit;

public class Issue_489 extends BaseIssue{

	public Issue_489() {
		super("Distância entre texto e borda no MultiEdit", "MultiEdit text border", 489, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container(){
			@Override
			public void initUI() {
				MultiEdit me = new MultiEdit(4,2);
				me.setTextGap(16, 16, 16, 16);
				add(me, LEFT+16, CENTER, FILL-16, PREFERRED);
			}
		};
	}

}
