package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Edit;
import totalcross.ui.ScrollContainer;
import totalcross.ui.dialog.TimeBox;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.ui.layout.HBox;
import totalcross.ui.layout.VBox;
import totalcross.util.UnitsConverter;

public class Issue_488 extends BaseIssue{

	final int[] alignment = { Edit.LEFT, Edit.CENTER, Edit.RIGHT };
	public Issue_488() {
		super("Edit Test Screen", "Edit Screen", 488, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container () {
			@Override
			public void initUI() {
				Settings.is24Hour = true;
				ScrollContainer scroll = new ScrollContainer();
				this.add(scroll, LEFT, TOP + 40, PARENTSIZE, PARENTSIZE);
				VBox v = new VBox();
				for(int i = 0; i < 16; i++) {
					HBox h = new HBox();
					h.setInsets(2, 2, 2, 2);
					h.setBackColor(0xCCCCCC);
					h.add(generateEdits(i % 8, i < 8 ? null : "images/bt_back.png"));
					v.add(h);
				}
				scroll.add(v, LEFT, TOP, PREFERRED, PREFERRED);
			}
		};
	}
	
	public Control[] generateEdits(int line, String iconPath) {
		Control[] controls = new Control[3];
		Image captionIcon = null;
		if (iconPath != null) {
			try {
				captionIcon = new Image(iconPath).getSmoothScaledInstance(UnitsConverter.toPixels(Control.DP + 32), UnitsConverter.toPixels(Control.DP + 32));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ImageException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 3; i++) {
			switch (line) {
			case 0:
				controls[i] = new Edit();
				((Edit) controls[i]).caption = "Simple Edit";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).alignment = alignment[i];
				break;
			case 1:
				controls[i] = new Edit();
				((Edit) controls[i]).caption = "NumericBox Edit";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).alignment = alignment[i];
				((Edit) controls[i]).setMode(Edit.CURRENCY);
				((Edit) controls[i]).setKeyboard(Edit.KBD_NUMERIC);
				break;
			case 2:
				controls[i] = new Edit();
				((Edit) controls[i]).caption = "Calculator Edit";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).alignment = alignment[i];
				((Edit) controls[i]).setMode(Edit.CURRENCY, false);
				break;
			case 3:
				 controls[i] = new Edit("99/99/99");
					((Edit) controls[i]).captionIcon = captionIcon;
				 ((Edit) controls[i]).caption = "Calendar Edit"; 
				 ((Edit) controls[i]).setMode(Edit.DATE, true);  
				break;
			case 4:
				controls[i] = new Edit("99" + Settings.timeSeparator + "99" + Settings.timeSeparator + "99");
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).caption = "TimeBox Edit (24-hour format)";
				TimeBox.hideIfInvalid = false;
				((Edit) controls[i]).setValidChars("0123456789AMP");
				((Edit) controls[i]).setMode(Edit.NORMAL, true);
				((Edit) controls[i]).setKeyboard(Edit.KBD_TIME);
				break;
			case 5:
				controls[i] = new Edit("");
				((Edit) controls[i]).caption = "Password Edit (last character is shown)";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).setMode(Edit.PASSWORD);
				break;
			case 6:
				controls[i] = new Edit("");
				((Edit) controls[i]).caption = "Password Edit (all characters are hidden)";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).setMode(Edit.PASSWORD_ALL);
				break;
			case 7:
				controls[i] = new Edit("999.999.999-99");
				((Edit) controls[i]).caption = "Masked Edit (999.999.999-99)";
				((Edit) controls[i]).captionIcon = captionIcon;
				((Edit) controls[i]).setMode(Edit.NORMAL, true);
				((Edit) controls[i]).setValidChars(Edit.numbersSet);
				break;
			}
		}
		return controls;
	}

}