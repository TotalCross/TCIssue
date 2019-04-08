package tcissues.issues;

import java.util.Iterator;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.MainWindow;
import totalcross.ui.event.*;
import totalcross.ui.event.KeyEvent;
import totalcross.ui.event.KeyListener;

public class Issue_469 extends BaseIssue {

    public Issue_469() {
        super("Implementação de Throwable e StackTraceElement",
                "Throwable e Stacktrace", 469, true);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                try {
                	throw new Exception();
                } catch (Exception e) {
                	Throwable t = (Throwable)e;
                	StackTraceElement[] trace = t.getStackTrace();
                	for (StackTraceElement element : trace) {
						System.out.println(element.toString());
					}
                }
            }
        };
    }
}
