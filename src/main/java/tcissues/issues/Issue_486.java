package tcissues.issues;

import tcissues.BaseIssue;
import java.io.IOException;
import totalcross.io.File;
import totalcross.io.FileNotFoundException;
import totalcross.io.IllegalArgumentIOException;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.MainWindow;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.ui.image.ImageLoader;

public class Issue_486 extends BaseIssue {

	public Issue_486() {
		super("Existe alguma forma de capturar uma printscreen programaticamente?", "Printscreen", 486, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Image img = MainWindow.getScreenShot();
				
				File f;
				String path = Settings.appPath + "/screen.png";
				try {
					f = new File(path,File.CREATE_EMPTY);
					img.createPng(f);
					f.close();
					
					File f2 = new File(path, File.READ_ONLY);
					Image img2 = new Image(f2);
					ImageControl ic = new ImageControl(img);
					add(ic, LEFT + 20, TOP + 20, FILL - 20, FILL - 20);
					f2.close();
				} catch (IllegalArgumentIOException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ImageException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		};
	}

}
