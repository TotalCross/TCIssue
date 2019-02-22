package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;

public class Issue_389 extends BaseIssue{

	public Issue_389() {
		super("Problema no componente edit no coletor de dados Windows CE", "Edit WinCE", 389);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				add(getUsuarioEdit(), CENTER, TOP + 40);
				add(getSenhaEdit(), CENTER, AFTER + 40);
			}
		};
	}
	
	private Edit getUsuarioEdit() {
		Edit edtUsuario = new Edit() {
			{
				hasBorder = false;
			}
		};
		edtUsuario.transparentBackground = true;
		edtUsuario.drawLine = true;
		edtUsuario.setText("sup");
		return edtUsuario;
	}

	private Edit getSenhaEdit() {
		Edit edtSenha = new Edit() {
			{
				hasBorder = false;
			}
		};
		edtSenha.transparentBackground = true;
		edtSenha.drawLine = true;
		edtSenha.setMode(Edit.PASSWORD_ALL);
		return edtSenha;
	}
}
