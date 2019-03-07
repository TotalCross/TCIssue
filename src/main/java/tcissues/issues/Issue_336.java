package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.*;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.*;

public class Issue_336 extends BaseIssue {

    public Issue_336(){ super ("Erro ao utilizar o MessageBox.Builder", "MessageBox issue", 336, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                Edit email = new Edit();

                MessageBox mb = new MessageBox.Builder()
                        .setButtons(new String[]{"Enviar"})
                        .setTitle("Digite o e-mail associado à conta que deseja recuperar")
                        .setBaseContainer(new Container() {
                            @Override
                            public void initUI() {
                                add (email, CENTER, TOP, PREFERRED, PREFERRED);
                            }
                        })
                        .build();

                mb.getButton(0).addPressListener(new PressListener() {
                    @Override
                    public void controlPressed(ControlEvent controlEvent) {
                        Toast.show("Work", 2000);
                    }
                });

                Button btn = new Button("Click here");
                btn.addPressListener(e -> {
                    mb.popupNonBlocking();
                });

                add(btn, CENTER, CENTER);

            }
        };
    }
}
