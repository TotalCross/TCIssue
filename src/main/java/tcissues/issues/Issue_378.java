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

public class Issue_378 extends BaseIssue {

	public Issue_378() {
		super("Repaint no TabContainner ", "TabContainner Issues", 378, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Edit campo1 = new Edit();
				campo1.setBackForeColors(Color.WHITE, Color.BLACK);
				campo1.caption = "Campo 1";

				Edit campo2 = new Edit();
				campo2.setBackForeColors(Color.WHITE, Color.BLACK);
				campo2.caption = "Campo 2";

				String[] caps = new String[2];
				for (int i = 0; i < caps.length; i++) {
					caps[i] = "Aba " + (i + 1);
				}

				TabbedContainer tc = new TabbedContainer(caps);
				tc.setType(TabbedContainer.TABS_TOP);
				tc.setBackColor(Color.DARK);
				tc.useOnTabTheContainerColor = true;
				add(tc, LEFT, TOP, FILL, PARENTSIZE);

				tc.getContainer(0).add(campo1, LEFT, TOP);
				tc.getContainer(0).add(campo2, LEFT, AFTER + UnitsConverter.toPixels(DP + 50));
				tc.getContainer(1).add(new Label("Só pode entrar aqui se tiver \npreenchido os campos da aba 1"), LEFT, CENTER);

				tc.addPressListener(e -> {
					if (tc.getActiveTab() > 0 ){
						if(campo1.getText().length() == 0 || campo2.getText().length() == 0){
							Toast.show("É necessario preencher os dois campos na primeira aba :D", 2000);
							tc.setActiveTab(0);
						}
					}
				});


			}
		};

	}


}
