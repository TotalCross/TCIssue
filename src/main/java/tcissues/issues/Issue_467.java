package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.*;
//import totalcross.ui.event.ScrollEvent;

public class Issue_467 extends BaseIssue {
    public Issue_467() {
        super("ScrollEvent and ScrollEventListener implementation",
                "ScrollEvent", 467, false);
    }

    @Override
    protected Container InitIssue() {
        Label indicator = new Label("...");
        Label indicator2 = new Label("...");
        indicator.setFloating(true);
        indicator2.setFloating(true);
        indicator.align = Control.CENTER;
        indicator2.align = Control.CENTER;
        ScrollContainer sc = new ScrollContainer(true, true) {
            @Override
            public void initUI() {
                super.initUI();
                add(new Container() {}, 0, 0, 2000, 2000);
                add(indicator, CENTER, CENTER, PARENTSIZE, PREFERRED);
                add(indicator2, CENTER, AFTER, PARENTSIZE, PREFERRED, indicator);
            }
        };
        sc.addScrollEventHandler((e) -> {
            if(e.type == ScrollEvent.SCROLL_ON_TOP) {
                indicator.setText("Top Reached!");
                indicator.repaintNow();
            }
            if(e.type == ScrollEvent.SCROLL_ON_BOTTOM) {
                indicator.setText("Bottom Reached!");
            }
            if(e.type == ScrollEvent.SCROLL_ON_LEFT) {
                indicator.setText("LEFT Reached!");
            }
            if(e.type == ScrollEvent.SCROLL_ON_RIGHT) {
                indicator.setText("RIGHT Reached!");
            }
            if(e.type == ScrollEvent.SCROLL_UP) {
                indicator.setText("SCROLL_UP");
            }
            if(e.type == ScrollEvent.SCROLL_DOWN) {
                indicator.setText("SCROLL_DOWN");
            }
            if(e.type == ScrollEvent.SCROLL_LEFT) {
                indicator.setText("SCROLL_LEFT");
            }
            if(e.type == ScrollEvent.SCROLL_RIGHT) {
                indicator.setText("SCROLL_RIGHT!");
            }
            if(e.type == ScrollEvent.SCROLL_START) {
                indicator2.setText("SCROLL START!");
            }

            if(e.type == ScrollEvent.SCROLL_END) {
                indicator2.setText("SCROLL END!");
            }
            indicator.repaintNow();
        });
        return sc;
    }
}
