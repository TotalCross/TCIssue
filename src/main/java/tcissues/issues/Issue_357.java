package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.TabbedContainer;
import totalcross.ui.gfx.Color;

public class Issue_357 extends BaseIssue{

	public Issue_357() {
		super("Erro ao montar tela", "Label Issues", 357, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {

				Cliente apontamentoInc = new Cliente("","");

				Label txOT = new Label(apontamentoInc.ot != null ? ""+ apontamentoInc.ot : "");
				txOT.setForeColor(Color.BLACK);
				add(txOT, AFTER, SAME, PREFERRED, PREFERRED);

				if (apontamentoInc.idCliente != null){
					Label txUC = new Label(apontamentoInc.idCliente != null ? "" + apontamentoInc.idCliente :"");
					txUC.setForeColor(Color.BLACK);
					txUC.align = RIGHT;
					add(txUC, RIGHT, TOP, PREFERRED, PREFERRED);
					
					Label lbUC = new Label("UC:");
					lbUC.setForeColor(Color.BLACK);
					lbUC.align = RIGHT;
					add(lbUC, BEFORE, SAME, PREFERRED, PREFERRED, txUC);
				}
			}
		};
	};


	private class Cliente {
		String idCliente;
		String ot;

		public Cliente(String id, String ot) {
			this.idCliente = id;
			this.ot = ot;
		}
	}

}
