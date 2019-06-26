package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Issue_543 extends BaseIssue {

	public Issue_543() {
		super("Centralizar imagem e texto no botão...", "Button new center position", 543, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() { 
			@Override
			public void initUI() {
				try {
					Button button = new Button("Teste", new Image("images/arrow-down-drop-circle.png"), Button.CENTRALIZE, UnitsConverter.toPixels(DP + 8));
					add(button, CENTER, CENTER, PARENTSIZE, PREFERRED);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ImageException e) {
					e.printStackTrace();
				}
			}
		};
	}

}
