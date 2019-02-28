package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

public class Issue_351 extends BaseIssue {

	public Issue_351() {
		super("Mudar imagem de um Button após criado", "Button Issues", 351, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Image img1 = Images.getTotalCrossLogo(DP + 18, DP + 18);
				Image img2 = Images.getInfoIcon(DP + 18, DP + 18);
				Button btn = new Button("oi", img1, LEFT, UnitsConverter.toPixels(DP + 4));
				add(btn, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);

				btn.addPressListener(e -> {
					if (btn.getImage() != img1) {
						btn.setImage(img1);
					} else {
						btn.setImage(img2);
					}
					
					repaintNow();
				});
			}
		};
	};
}
