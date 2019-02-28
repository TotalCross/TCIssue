package tcissues.resources;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public final class Images {
	private static Image totalCrossLogo;
	private static Image infoIcon;

	private static Image getImage(String path) {
		try {
			return new Image(path);
		} catch (IOException | ImageException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Image getTotalCrossLogo() {
		if (totalCrossLogo == null) {
			totalCrossLogo = getImage("images/logoV.png");
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

	public static Image getInfoIcon() {
		if (infoIcon == null) {
			infoIcon = getImage("images/bt_info.png");
		}
		
		return infoIcon;
	}
	public static Image getInfoIcon(int w, int h) {
		Image img = null;
		try {
			img = getInfoIcon().getHwScaledInstance(UnitsConverter.toPixels(w), UnitsConverter.toPixels(h));
		} catch (ImageException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	private static Image progressBoxGif; 
	public static Image getprogressBoxGif () {
		if(progressBoxGif == null) {
			try {
				progressBoxGif = new Image("images/progress.gif");
			} catch (IOException | ImageException e) {
				e.printStackTrace();
			}
		}
		return progressBoxGif;
	}

}
