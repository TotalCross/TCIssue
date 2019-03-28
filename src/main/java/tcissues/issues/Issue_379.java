package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.TabbedContainer;
import totalcross.ui.Toast;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class Issue_379 extends BaseIssue {

	public Issue_379() {
		super("Efeito estranho ao usar Edit com Caption ", "Edit Issues", 379, false);
	}

	@Override
	protected Container InitIssue() {

		return new Container() {
			@Override
			public void initUI() {
				// SetText ANTES do add dá problema
				Edit editBug = new Edit();
				editBug.caption = "Dt.Inicial Meta";
				editBug.setBackForeColors(Color.WHITE, Color.BLACK);
				editBug.setText("13/02/2019");
				add(editBug, LEFT + UnitsConverter.toPixels(DP + 40), AFTER, DP + 170, PREFERRED);

				// Sem SetText
				Edit editNormal = new Edit();
				editNormal.caption = "Dt.Final Meta";
				editNormal.setBackForeColors(Color.WHITE, Color.BLACK);
				add(editNormal, LEFT + UnitsConverter.toPixels(DP + 40), AFTER + 40, DP + 170, PREFERRED);
				
				// SetText DEPOIS do add não dá problema
				Edit setTextDepois = new Edit();
				setTextDepois.caption = "Dt.Final Meta";
				setTextDepois.setBackForeColors(Color.WHITE, Color.BLACK);
				add(setTextDepois, LEFT + UnitsConverter.toPixels(DP + 40), AFTER + 40, DP + 170, PREFERRED);
				setTextDepois.setText("13/02/2019");
			}
		};
	}
}
