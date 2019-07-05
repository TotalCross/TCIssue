package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.qrcode.QRCode;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Issue_540 extends BaseIssue{

	Image image;
	
	public Issue_540() {
		super("Gerar QR Code", "QRCode generation", 540, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				setBackColor(Color.getRGB("4a91e1"));
				ImageControl imgControl = null;
				QRCode qrcode = new QRCode();
				byte[][] byteArray = qrcode.generateCode(3, 2, "Ricardo Braga Nogueira de Aquino");
				try {
					image = new Image(byteArray.length*10, byteArray[0].length*10);
					Graphics imgGraphics = image.getGraphics();
					imgGraphics.backColor = Color.WHITE;
					imgGraphics.foreColor = Color.BLACK;
					imgGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
					for(int y = 0; y < image.getHeight(); y++) {
						for(int x = 0; x < image.getWidth(); x++) {
							if(byteArray[y/10][x/10] != 0) {
								imgGraphics.setPixel(x, y);
							}
						}
					}
					imgControl = new ImageControl(image);
				} catch (ImageException e1) {
					e1.printStackTrace();
				}
				add(imgControl, CENTER, CENTER);
			}
		};
	}

}
