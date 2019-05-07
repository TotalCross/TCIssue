package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.gfx.Color;

public class Issue_512 extends BaseIssue{

	public Issue_512() {
		super("Comportamento do Check ao colocar imagem maior", "Check size", 512, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Container a = new Container();
				a.setRect(0, 0, FILL, FILL);
				add(a);
				
				//Nenhum problema com largura e altura padrão (PREFERRED)
				Check ck = new Check("asd-f");
				ck.setForeColor(Color.getRGB(20, 20, 20));
				a.add(ck, LEFT, AFTER + 5, PREFERRED, PREFERRED);

				
				//o calculo da largura do componente não considera que a imagem está maior, e o texto fica cortado
				Check ck2 = new Check("asd-f");
				ck2.setForeColor(Color.getRGB(20, 20, 20));
				a.add(ck2, LEFT, AFTER + 5, PREFERRED, 50);
				//Ao rotacionar a tela, o check se reajusta corretamente.

			}
		};
	}

}
