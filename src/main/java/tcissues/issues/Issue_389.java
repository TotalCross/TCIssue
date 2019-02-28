package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.sys.Vm;
import totalcross.ui.Container;
import totalcross.ui.Edit;

public class Issue_389 extends BaseIssue {

	public Issue_389() {
		super("Problema no componente edit no coletor de dados Windows CE", "Edit WinCE", 389, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				add(getUsuarioEdit(), CENTER, TOP + 40);
				add(getSenhaEdit(), CENTER, AFTER + 40);
				Thread t = new Thread() {
					@Override
					public void run() {
						while (true) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println(Vm.getTimeStamp() + "");
						}
					}
				};

				t.start();
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
