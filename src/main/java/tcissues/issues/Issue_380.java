package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Issue_380 extends BaseIssue {

	public Issue_380() {
		super("Centralizar Imagem e Texto no Botão", "Button Issues", 380);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				try {
					Image img = new Image("images/bt_search.png").getHwScaledInstance(UnitsConverter.toPixels(DP + 18), UnitsConverter.toPixels(DP + 18));
					Button btn = new Button("Pesquisara", img, LEFT, UnitsConverter.toPixels(DP + 0));
					btn.setBackForeColors(Color.WHITE, Color.BLACK);
					add(btn, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);

					Button btn3 = new Button("Pesquisar", img, RIGHT, UnitsConverter.toPixels(DP + 0));
					btn3.setBackForeColors(Color.WHITE, Color.BLACK);
					add(btn3, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);


					Button btn2 = new Button("Pesquisar");
					btn2.setBackForeColors(Color.WHITE, Color.BLACK);
					add(btn2, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);


				} catch (ImageException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
