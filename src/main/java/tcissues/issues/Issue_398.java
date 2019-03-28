package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.ByteArrayStream;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.ui.Container;

public class Issue_398 extends BaseIssue {
	public Issue_398() {
		super("SSL Connection TC5 RC2", "Connection  Issues", 398, false);
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
					ByteArrayStream bas = new ByteArrayStream(4096);
					bas.readFully(hs, 10, 2048);
					String data = new String(bas.getBuffer(), 0, bas.available());
					System.out.println(data);
					hs.close();
				} catch (Exception e) {
					System.out.println("error " + e);
				}

				System.out.println(str);
			}
		};
	};
}
