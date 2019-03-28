package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;

public class Issue_455 extends BaseIssue {
    public Issue_455() {
        super("autoSplit não está quebrando o texto para a linha abaixo\n",
                "autosplit-not-working", 455, true);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                Label l = new Label("abcdefghijlmnopqrstuwxyz");
                l.autoSplit = true;
                add(l, CENTER, CENTER, PARENTSIZE + 50, DP+200);
            }
        };
    }
}
