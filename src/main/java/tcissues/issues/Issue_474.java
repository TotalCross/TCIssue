package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Issue_474 extends BaseIssue{

	public Issue_474() {
		super("Erro ao preencher EDIT com mascara", "Edit Issues", 474, false);
	}

	int i = 0;
	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
			Edit edtTelefone = new Edit("(99)99999-9999");
			edtTelefone.alignment = Edit.RIGHT;
			edtTelefone.setBackColor(Color.getRGB("80FFBF"));
			edtTelefone.setMaxLength(30);
	//ao comentar essa linha o texto apareceu no edit que foi preenchido atraves do setText em tempo de execução.
//			edtTelefone.setMode(Edit.KBD_NUMERIC, true);
			//Forma correta de usar
			edtTelefone.setMode(Edit.NORMAL, true);
}
		};
	}

}
