package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Check;
import totalcross.ui.Container;
import totalcross.ui.Insets;
import totalcross.ui.Label;
import totalcross.ui.ListContainer;
import totalcross.ui.gfx.Color;

public class Issue_393 extends BaseIssue {

	public Issue_393() {
		super("Check in ListContainer.Item - SDK 5.0.0-RC2", "Check on ListContainer", 393, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				ListContainer listContainer = new ListContainer();
				listContainer.autoScroll = true;
				add(listContainer, LEFT, AFTER, FILL, FILL);

				LCIAutorizacao.Builder builder = new LCIAutorizacao.Builder(listContainer);

				listContainer.addContainer(builder.build("Opção 1"));
				listContainer.addContainer(builder.build("Opção 2"));
				listContainer.addContainer(builder.build("Opção 3"));
				listContainer.addContainer(builder.build("Opção 4"));
				listContainer.addContainer(builder.build("Opção 5"));

			}
		};
	}

}

class LCIAutorizacao extends ListContainer.Item {
	
	LCIAutorizacao(ListContainer.Layout layout, String descricao) {
		super(layout);
		setBackColor(Color.BRIGHT);
		this.items = new String[] { descricao };
		Label label = new Label(" ");
		label.setBackColor(Color.BLUE);
		leftControl = label;
		Check check = new Check();
		rightControl = check;
	}
	
	public static class Builder {
		
		ListContainer list;
		
		ListContainer.Layout layout;
		
		Builder(ListContainer list) {
			this.list = list;
			
			layout = list.getLayout(1, 1);
			layout.boldItems[0] = true;
			layout.lineGap = 30;
			layout.insets = new Insets(50, 30, 50, 10);
			layout.setup();
		}
		
		LCIAutorizacao build(String descricao) {
			return new LCIAutorizacao(layout, descricao);
		}
	}
	
}
