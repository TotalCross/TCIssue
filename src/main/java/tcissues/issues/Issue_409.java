package tcissues.issues;

import org.omg.CORBA.VM_ABSTRACT;

import tcissues.BaseIssue;
import tcissues.resources.Images;
import totalcross.game.Animation;
import totalcross.sys.Vm;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.util.UnitsConverter;

public class Issue_409 extends BaseIssue{

	public Issue_409() {
		super("Bugs e requests diversos Gekom", "Gekon Edit", 409, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); //To change body of generated methods, choose Tools | Templates.
                
                add(new Edit("Preferred"), LEFT, TOP);
                add(new Edit("Custom Height"), LEFT, TOP, PREFERRED, 40 + DP);
			}
		};
	};
};


