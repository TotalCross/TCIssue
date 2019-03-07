package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;

public class Issue_347 extends BaseIssue {

    public Issue_347(){ super ("iOS: Keyboard does not appear anymore once hidden", "Edit issue", 347, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                Edit editLogin = new Edit();
                editLogin.caption = "Usuário";
                add(editLogin, LEFT, AFTER);

                Edit editSenha = new Edit();
                editSenha.caption = "Senha";
                add(editSenha, LEFT, AFTER);


            }
        };
    }
}
