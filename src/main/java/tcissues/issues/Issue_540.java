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
				Button b = new Button("Open Window");
				b.setBackForeColors(Colors.BLUE, Colors.WHITE);
				ImageControl imgControl = new ImageControl(image);
				b.addPressListener(new PressListener() {
					
					@Override
					public void controlPressed(ControlEvent e) {
						QRCode qrcode = new QRCode();
						byte[][] byteArray = qrcode.generateCode(3, 2, "Ricardo Braga Nogueira de Aquino");
						try {
							image = new Image(byteArray.length, byteArray[0].length);
							for(int y = 0; y < image.getHeight(); y++) {
								for(int x = 0; x < image.getWidth(); x++) {
									if(byteArray[x][y] == -1) {
										image.getGraphics().foreColor = Color.WHITE;
									} else {
										image.getGraphics().foreColor = Color.BLACK;
									}
									image.getGraphics().setPixel(x, y);
								}
							}
						} catch (ImageException e1) {
							e1.printStackTrace();
						}
						
					}
				});
				add(b, CENTER, CENTER, 280 + DP, 80 + DP);
				add(imgControl, CENTER, AFTER + UnitsConverter.toPixels(DP + 12), DP + 80, DP + 80);
			
			}
		};
	}

}
