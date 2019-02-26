package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

public class Issue_351 extends BaseIssue{

	public Issue_351() {
		super("Mudar imagem de um Button após criado", "Button Issues", 351, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Image img1 = Images.getTotalCrossLogo(DP + 18, DP + 18);
				Button btn = new Button("oi", img1, LEFT, UnitsConverter.toPixels(DP + 4));
				add(btn, LEFT, AFTER + UnitsConverter.toPixels(DP + 50), DP + 300, PREFERRED);
				
				btn.addPressListener(e -> {
					try {
						Image img2 = new Image("images/bt_info.png").getHwScaledInstance(UnitsConverter.toPixels(DP + 18), UnitsConverter.toPixels(DP + 18));
						btn.setImage(img2);
						repaintNow();					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				});
			}
		};
	};
}
