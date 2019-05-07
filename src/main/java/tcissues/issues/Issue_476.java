package tcissues.issues;

import java.util.ArrayList;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.Spacer;
import totalcross.ui.event.DragEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.event.PenListener;
import totalcross.ui.gfx.Rect;

public class Issue_476 extends BaseIssue {

	public Issue_476() {
		super("Problema ScrollContainer pendown em uma lista de Label's", "Label Event on ScrollContainer", 476, true);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				ScrollContainer sc = new ScrollContainer(false, true);
				ArrayList<Label> lblInfo = new ArrayList<>();
				for (int i = 0; i < 100; i++) {
					lblInfo.add(new Label("Label " + i, CENTER));
					final int index = i;
					lblInfo.get(i).addPenListener(new PenListener() {

						@Override
						public void penUp(PenEvent arg0) {
							if (!lblInfo.get(index).hadParentScrolled()) {
								System.out.println("teste, label " + index);
							}
						}

						@Override
						public void penDragStart(DragEvent arg0) {
						}

						@Override
						public void penDragEnd(DragEvent arg0) {
						}

						@Override
						public void penDrag(DragEvent arg0) {
						}

						@Override
						public void penDown(PenEvent arg0) {
						}
					});
				}
				sc.setRect(new Rect(0, 0, width, height));
				add(sc);
				sc.add(new Spacer(), LEFT, TOP);
				for (Label label : lblInfo) {
					sc.add(label, SAME, AFTER, PARENTSIZE, DP + 32);
				}

			}
		};
	}

}
