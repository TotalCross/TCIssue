package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;

public class Issue_409 extends BaseIssue {
	public Issue_409() {
		super("Bugs e requests diversos Gekom", "Gekon Requests", 409, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI(); 

				
				Edit gasolina = new Edit();
				gasolina.caption = "Gasolina";
				gasolina.setDecimalPlaces(3);
				gasolina.setMode(Edit.CURRENCY, true);
				gasolina.alignment = LEFT;
                add(gasolina, LEFT, TOP + 60);
                gasolina.setText("3,999");
                
                Edit kilometragem = new Edit();
				kilometragem.caption = "Quilometros (Km)";
				kilometragem.setDecimalPlaces(1);
				kilometragem.setMode(Edit.CURRENCY, true);
				kilometragem.alignment = LEFT;
                add(kilometragem, LEFT, AFTER + 60);
                kilometragem.setText("64223,1");
                
                Edit dinheiro = new Edit();
				dinheiro.caption = "Reais";
				dinheiro.setDecimalPlaces(2);
				dinheiro.setMode(Edit.CURRENCY, true);
                add(dinheiro, LEFT, AFTER + 60);
                dinheiro.setText("9,99");
                
                Button b = new Button("Print values");
                b.addPressListener(new PressListener() {
					@Override
					public void controlPressed(ControlEvent e) {
						System.out.println("" + gasolina.getValue());
						System.out.println("" + gasolina.getValueAsInt());
						System.out.println("" + gasolina.getValueAsFloat());
						System.out.println("" + gasolina.getValueAsDouble());
						System.out.println("" + gasolina.getValueAsBigDecimal());
					}
				});
                
                add(b, LEFT, AFTER + 60, FILL, PREFERRED);
			}
		};
	};
}
