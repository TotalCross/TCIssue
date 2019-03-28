package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;

public class Issue_395 extends BaseIssue {
	public Issue_395() {
		super("Problema no calculo do time zone", "Daylight Bug", 395, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); 

				
				int tz = Settings.timeZoneMinutes;
				int dl = Settings.daylightSavingsMinutes;
				add(new Label("TimeZone (m): " + tz), LEFT + 40, TOP + 120);
				add(new Label("DayLight (m): " + dl), LEFT + 40, AFTER + 40);
				add(new Label("Diff (m): " + (tz - dl)), LEFT + 40, AFTER + 40);
			}
		};
	};
	
	/* I asked Ricardo to run this code on his mac on a simple java project to debug if it is a JVM bug
		public static void main(String[] args) {
			  java.util.TimeZone tz = java.util.TimeZone.getDefault();
			    System.out.println(tz.getDSTSavings() / 60000);
			    System.out.println(tz.getRawOffset() / 60000);
			    System.out.println(java.util.TimeZone.getDefault().getID());
		}
	 */
}
