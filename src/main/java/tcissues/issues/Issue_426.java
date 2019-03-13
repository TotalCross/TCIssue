package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.util.regex.Matcher;
import totalcross.util.regex.Pattern;

public class Issue_426 extends BaseIssue {
	public Issue_426() {
		super("Erro ao usar componente Slider", "Slider NPE", 426, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); 

				add(new Label("Apenas um Teste"), CENTER, CENTER - 20, PREFERRED, PREFERRED);
				
				Slider slider = new Slider();
				slider.setMinimum(0);
				slider.setMaximum(100);
				add(slider, CENTER, AFTER + 40, 300 + DP, 40 + DP);
			}
		};
	};
}
