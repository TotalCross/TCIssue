package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.dialog.InputBox;

public class Issue_506 extends BaseIssue{

	public Issue_506() {
		super("Problema no InputBox versão 5 final", "InputBox wrogn input", 506, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				InputBox ib = new InputBox("Atualizar quantidade","","");
				ib.setValue("teste");
				Button button = new Button("Click to open InputBox");
				button.addPressListener(e -> {
					ib.popup();
				});
				add(button, CENTER, CENTER);
			}
		};
	}

}
