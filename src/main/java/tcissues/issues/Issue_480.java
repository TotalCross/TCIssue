package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Grid;

public class Issue_480 extends BaseIssue{

	public Issue_480() {
		super("Dimensionamento das Colunas no Grid Divergente", "Grid width", 480, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				String[] gridCaptionsPesq = { "idCliente", "Nome", "CPF", "Telefone" };
				int[] gridWidthsPesq = { 0, -50, -25, -25 };
				int[] gridAlignsPesq = { LEFT, LEFT, LEFT, LEFT };
				Grid gridClientes = new Grid(gridCaptionsPesq, gridWidthsPesq, gridAlignsPesq, false);

				add(gridClientes, LEFT, AFTER, FILL, SCREENSIZE + 20);

			}
		};
	}

}
