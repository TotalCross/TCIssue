package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.notification.Notification;
import totalcross.notification.NotificationManager;
import totalcross.ui.Container;

public class Issue_316 extends BaseIssue {

    public Issue_316(){ super ("Notification no Android 8.1.0 não funciona", "Notification issue", 316, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                Notification.Builder builder = new Notification.Builder();
                Notification notification = builder
                        .title("titulo!")
                        .text("um texto qualquer!")
                        .build();
                NotificationManager.getInstance().notify(notification);


            }
        };
    }

}
