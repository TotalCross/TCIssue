package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.ui.Container;
import totalcross.ui.media.Camera;

public class Issue_346 extends BaseIssue {
    public Issue_346(){ super ("IOException when opening the camera", "Camera issue", 346, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                try {
                    Camera camera = new Camera();
                    camera.click();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        };
    }
}
