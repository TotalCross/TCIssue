package tcissues.resources;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

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
}
