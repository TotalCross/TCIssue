package tcissues.resources;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public final class Images {
	private static Image totalCrossLogo;
	public static Image getTotalCrossLogo() {
		if (totalCrossLogo == null) {
			try {
				totalCrossLogo = new Image("images/logoV.png");
			} catch (IOException | ImageException e) {
				e.printStackTrace();
			}
		}
		
		return totalCrossLogo;
	}
	public static Image getTotalCrossLogo(int w, int h) {
		Image img = null;
		try {
			img = getTotalCrossLogo().getHwScaledInstance(UnitsConverter.toPixels(w), UnitsConverter.toPixels(h));
		} catch (ImageException e) {
			e.printStackTrace();
		}
		
		return img;
	}
}
