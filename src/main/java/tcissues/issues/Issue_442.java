package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.font.Font;

public class Issue_442 extends BaseIssue {
    public Issue_442() {
        super("IPhone x Android -> Deslocamento na tela no combobox", "iOSxAndroid-Combo", 442, true);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                ComboBox cbEmpresa = new ComboBox();
                cbEmpresa.setFont(Font.getFont(false, 14));
                cbEmpresa.caption = "Empresa";

                cbEmpresa.add(new Object[] {"Emp1", "Emp2"});
                cbEmpresa.setSelectedIndex(0);
                add(cbEmpresa, LEFT + 12, AFTER + 12, FILL - 12, SCREENSIZE + 6);
            }
        };
    }
}
