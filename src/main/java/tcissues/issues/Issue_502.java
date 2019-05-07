package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Grid;
import totalcross.ui.Label;

public class Issue_502 extends BaseIssue{

	public Issue_502() {
		super("Grid test screen", "Grid test screen", 502, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Label label = new Label("This test screen can be used for issues #480 and #186", CENTER);
				label.autoSplit = true;
				String[] gridCaptionsPesq = { "idCliente", "Nome", "CPF", "Telefone" };
				int[] gridWidthsPesq = { 0, -50, -25, -25 };
				int[] gridAlignsPesq = { LEFT, LEFT, LEFT, LEFT };
				Grid gridClientes = new Grid(gridCaptionsPesq, gridWidthsPesq, gridAlignsPesq, false);
				
				add(label, LEFT, AFTER, SCREENSIZE, PREFERRED);
				add(gridClientes, LEFT, AFTER, FILL, SCREENSIZE + 20);

			}
		};
	}

}
