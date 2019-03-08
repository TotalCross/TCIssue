package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;

public class Issue_320 extends BaseIssue {



    public Issue_320(){ super ("Vm.exec(\"viewer\",\"/sdcard/Download/handbook.pdf\",0,true) not working anymore", "Vm issue", 320, false);}


    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();


                //Para testar é necessario possuir um arquivo Samble.pdf na pasta Download do smartphone.
                Button btn = new Button("click here");
                btn.addPressListener(e -> {
                    Vm.exec("viewer","/sdcard/Download/Sample.pdf",0,true);
                });
                add(btn, CENTER, CENTER);

            }
        };
    }




}
