package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import tcissues.resources.Images;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ScrollContainer;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Issue_380 extends BaseIssue {

	public Issue_380() {
		super("Centralizar Imagem e Texto no Botão", "Button Issues", 380, false);
	}

	@Override
	protected Container InitIssue() {
		return new ScrollContainer() {
			Image img;
			@Override
			public void initUI() {
				img = Images.getTotalCrossLogo(DP + 18, DP + 18);
				AddButtons(LEFT, "Left");
				AddButtons(RIGHT, "Right");
				AddButtons(CENTER, "Center");
				AddButtons(TOP, "Top");
				AddButtons(BOTTOM, "Bottom");
			}
			
			private void AddButtons(int alignment, String name) {
				name = name + " aligned text";
				
				Button btn = new Button(name, img, alignment, UnitsConverter.toPixels(DP + 4));
				btn.setBackForeColors(Color.WHITE, Color.BLACK);
				add(btn, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);

				Button btn2 = new Button(name, img, alignment, UnitsConverter.toPixels(DP + 4));
				btn2.setBackForeColors(Color.WHITE, Color.BLACK);
				add(btn2, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);
				
				Button btn3 = new Button("", img, alignment, UnitsConverter.toPixels(DP + 4));
				btn3.setBackForeColors(Color.WHITE, Color.BLACK);
				add(btn3, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);
			}
		};
	}
}
