package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.*;
//import totalcross.ui.event.ScrollEvent;

public class Issue_470 extends BaseIssue {
    public Issue_470() {
        super("Problema componente calendar Edit\n",
                "calendar-not-showing", 470, true);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                Edit calendarEdit = new Edit();
                calendarEdit.caption = "Calendar Edit";
                calendarEdit.setMode(Edit.DATE, true);
                calendarEdit.setKeyboard(Edit.KBD_CALENDAR);
                add(calendarEdit, CENTER, CENTER);
            }
        };
    }
}
