package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.*;
import totalcross.util.UnitsConverter;

public class Issue_290 extends BaseIssue {
    public Issue_290() {
        super("Scanner IOS",
                "Scanner-ios", 290, false);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                Button scan;
                add(scan = new Button("Scan"), CENTER, CENTER);
                Label result = new Label("...");
                add(result, CENTER, AFTER + UnitsConverter.toPixels(DP + 16));
                scan.addPressListener((c) -> {
                    String code = totalcross.io.device.scanner.Scanner.readBarcode("");
                    result.setText(code);
                    result.repaintNow();
                });
            }
        };
    }
}
