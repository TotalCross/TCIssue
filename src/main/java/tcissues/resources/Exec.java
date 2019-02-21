package tcissues.resources;

import totalcross.sys.Settings;
import totalcross.sys.Vm;

public final class Exec {
	public static void openUrl(String url) {
		if (Settings.onJavaSE || Settings.isWindowsDevice()) {
			Vm.exec("cmd", "/c start \"\" \"" + url + "\"", 0, false);
		} else {
			Vm.exec("url", url, 0, false);
		}
	}
}
