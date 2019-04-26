package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Issue_509 extends BaseIssue {

	public Issue_509() {
		super("Divergência do alinhamento no conteúdo do Button", "Button alignment", 509, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Container a = new Container();
				a.setRect(0, 0, FILL, FILL);
				add(a);
				final String nm = "abcdef";
				try {
					Button b = new Button(nm, new Image("images/bt_home.png").getSmoothScaledInstance(15, 15), RIGHT, 5);
					a.add(b, CENTER, AFTER + 10);

					Button c = new Button(nm, new Image("images/bt_home.png").getSmoothScaledInstance(15, 15), LEFT, 5);
					a.add(c, CENTER, AFTER + 10, PREFERRED, PREFERRED);

					/*
					 * Conseguimos um comportamento parecido com a versão RC2 utilizando RIGHT_OF,
					 * porém não temos o mesmo recurso para LEFT
					 */
					Button d = new Button(nm, new Image("images/bt_home.png").getSmoothScaledInstance(15, 15), RIGHT_OF,
							5);
					d.relativeToText = nm;
					a.add(d, CENTER, AFTER + 10);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ImageException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}

}
