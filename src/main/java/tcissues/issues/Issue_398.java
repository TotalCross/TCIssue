package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.ui.Container;

public class Issue_398 extends BaseIssue {
	public Issue_398() {
		super("SSL Connection TC5 RC2", "Connection  Issues", 398, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				String str = null;
				try {
					String url = "https://www.google.com";

					HttpStream.Options options = new HttpStream.Options();
					options.readTimeOut = 60000; // 1 minute
					options.writeTimeOut = 50000; // 50 seconds
					options.openTimeOut = 120000; // 2 minutes
					options.httpType = HttpStream.GET;
					options.socketFactory = new SSLSocketFactory();

					HttpStream hs = new HttpStream(new URI(url), options);
					// content length returns -1
					System.out.println("" + hs.contentLength);
					if (hs.contentLength > 0) {
						byte[] buf = new byte[hs.contentLength];
						hs.readBytes(buf, 0, hs.contentLength);
						str = new String(buf);
					}

					hs.close();
				} catch (Exception e) {
					System.out.println("error " + e);
				}

				System.out.println(str);
			}
		};
	};
}
