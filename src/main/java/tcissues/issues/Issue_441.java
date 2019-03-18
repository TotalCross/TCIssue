package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.util.UnitsConverter;
import totalcross.util.regex.Matcher;
import totalcross.util.regex.Pattern;

public class Issue_441 extends BaseIssue {
	public Issue_441() {
		super("Teclado Nativo Numérico", "Matcher.group()", 441, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI();
				Edit.useNativeNumericPad = true;
				Edit edit = new Edit();
				edit.caption = "Numeric";

				edit.setKeyboard(Edit.KBD_NUMERIC);
				add(edit, CENTER, TOP, PARENTSIZE, PREFERRED);


				Edit edt2 = new Edit();
				edt2.caption = "Non-Numeric";
				add(edt2, CENTER, AFTER + UnitsConverter.toPixels(DP + 15), PARENTSIZE, PREFERRED);
			}
		};
	};
}
