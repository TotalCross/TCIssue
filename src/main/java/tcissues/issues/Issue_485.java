package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Toast;
import totalcross.ui.effect.UIEffects;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;

public class Issue_485 extends BaseIssue {

	public Issue_485() {
		super("Lentidão no WinCE por conta dos efeitos do Material", "Ripple Lento WCE", 485, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Button b1 = new Button("Com Ripple");
				b1.addPressListener(new PressListener() {
					@Override
					public void controlPressed(ControlEvent arg0) {
						System.out.println("b1: Clicado");
					}
				});
				add(b1, CENTER, CENTER - 60, 200 + DP, 30 + DP);
				
				Button b2 = new Button("Sem Ripple");
				b2.setDoEffect(false);
				b2.addPressListener(new PressListener() {
					@Override
					public void controlPressed(ControlEvent arg0) {
						System.out.println("b2: Clicado");
					}
				});
				add(b2, CENTER, CENTER + 80, 200 + DP, 30 + DP);
			}
		};
	}

}
