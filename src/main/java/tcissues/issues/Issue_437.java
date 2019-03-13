package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Issue_437 extends BaseIssue {
	public Issue_437() {
		super("Há a possibilidade dos botões ficarem redondos?", "Botões Redondos", 437, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Image original = Images.getTotalCrossLogo();
				// Se precisar mudar o tamanho dela, essa é a chamada
				Image aumentada;
				try {
					aumentada = original.hwScaledBy(0.5, 0.5);
					Button btn = new Button(aumentada);
					// Se quiser mudar a imagem quando o botão for clicada, use essa propriedade
					// O método "getTouchedUpInstance" é um bom place-holder.
					btn.pressedImage = aumentada.getTouchedUpInstance((byte) 64, (byte) 0);
					// Por fim, tire a borda padrão do botão e o ninepatch
					btn.setBorder(Button.BORDER_NONE);
					btn.setNinePatch(null);
					
					add(btn, CENTER, CENTER);
				} catch (ImageException e) {
					e.printStackTrace();
				}
			}
		};
	}
}


