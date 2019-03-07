package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.util.regex.Matcher;
import totalcross.util.regex.Pattern;

public class Issue_410 extends BaseIssue {
	public Issue_410() {
		super("Implementação de Matcher.group() é possível?", "Matcher.group()", 410, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); 

				String typename = "ABC:xxxxx;";
				String pattern = "(.*):";
				
				Pattern pattern4 = Pattern.compile(pattern);
				Matcher m = pattern4.matcher(typename);
				if (m.find()) {
					add(new Label("String: " + typename), LEFT + 40, TOP + 120);
					add(new Label("Pattern: " + pattern), LEFT + 40, AFTER + 40);
					
					add(new Label("Result:"), LEFT + 40, AFTER + 120);
					add(new Label("Group(): " + m.group()), SAME, AFTER + 40);
					add(new Label("Group(0): " + m.group(0)), SAME, AFTER + 40);
					add(new Label("Group(1): " + m.group(1)), SAME, AFTER + 40);
					
					add(new Label("Expected:"), SAME, AFTER + 120);
					add(new Label("Group(): ABC:"), SAME, AFTER + 40);
					add(new Label("Group(0): ABC:"), SAME, AFTER + 40);
					add(new Label("Group(1): ABC"), SAME, AFTER + 40);
				}
			}
		};
	};
}
