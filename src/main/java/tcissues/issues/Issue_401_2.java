package tcissues.issues;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;

public class Issue_401_2 extends Container {

    Container previous;

    Issue_401_2 (Container previous) {
        this.previous = previous;
    }

    @Override
    public void initUI() {
        Button back = new Button("Back");
        back.addPressListener((c) -> MainWindow.getMainWindow().swap(previous));
        add(back, CENTER, CENTER);
    }
}
