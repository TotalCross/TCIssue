package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;

public class Issue_402 extends BaseIssue{

	public Issue_402() {
		super("Problema com componente Edit", "Edit Alto", 402, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); 

				Edit normal = new Edit();
				normal.caption = "Height = PREFERRED";
                add(normal, LEFT, TOP + 60, PREFERRED, PREFERRED);
                normal.setText("Texto");
                
                Edit _40dp = new Edit();
                _40dp.caption = "Height = 40 + DP";
                add(_40dp, LEFT, AFTER + 20, PREFERRED, 40 + DP);
                _40dp.setText("Texto");
                
                Edit _80dp = new Edit();
                _80dp.caption = "Height = 80 + DP";
                add(_80dp, LEFT, AFTER + 20, PREFERRED, 80 + DP);
                _80dp.setText("Texto");
			}
		};
	};
};


