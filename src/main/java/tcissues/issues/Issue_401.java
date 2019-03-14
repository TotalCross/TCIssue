package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.MainWindow;
import totalcross.ui.event.*;
import totalcross.ui.event.KeyEvent;
import totalcross.ui.event.KeyListener;

public class Issue_401 extends BaseIssue {

    public Issue_401() {
        super("Erro ao pressionar a tecla Enter quando o focus está em um campo Edit",
                "Add-act-to-enter-key-edit", 401, true);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                Edit edt = new Edit();
//                edt.addFocusListener(new FocusListener() {
//                    @Override
//                    public void focusIn(ControlEvent controlEvent) {
//
//                    }
//
//                    @Override
//                    public void focusOut(ControlEvent controlEvent) {
//                        proximaTela();
//                    }
//                });
                edt.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        if(keyEvent.isActionKey()){
                            proximaTela();
                        }

                    }

                    @Override
                    public void actionkeyPressed(KeyEvent keyEvent) {
                        proximaTela();
                    }

                    @Override
                    public void specialkeyPressed(KeyEvent keyEvent) {
                        if(keyEvent.isActionKey()){
                            proximaTela();
                        }
                    }
                });
                add(edt, CENTER, CENTER, PARENTSIZE, PREFERRED);
            }
        };
    }

    private void proximaTela() {
        getWindow().unpop();
    }
}
