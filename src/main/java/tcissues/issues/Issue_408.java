package tcissues.issues;

import org.omg.CORBA.VM_ABSTRACT;

import tcissues.BaseIssue;
import tcissues.resources.Images;
import totalcross.game.Animation;
import totalcross.sys.Vm;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.ProgressBar;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class Issue_408 extends BaseIssue{

	public Issue_408() {
		super("Erro ao tentar usar gif no Animation", "ProgressBox Issues", 408, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				super.initUI();
				int gap = UnitsConverter.toPixels(DP + 50);
				Container c = new Container();
				c.setInsets(gap, gap, gap, gap);
				add(c, LEFT, TOP, FILL, PREFERRED);

				Label label = new Label("Atualizando aparelho, 1 de 20, aguarde...");
				c.add(label, LEFT, TOP, FILL, PREFERRED);
				label.autoSplit = true;

				Container cProgress = new Container();
				cProgress.setBackColor(0xa5cdfa);
				c.add(cProgress, LEFT, AFTER + (gap * 2), FILL, gap);

//				try {
//					Animation anim = new Animation(Images.getprogressBoxGif(), 80);
//					anim.pauseIfNotVisible = true;
//					cProgress.add(anim, LEFT, TOP, FILL, FILL);
//					anim.start(Animation.LOOPS_UNLIMITED);
//				} catch (Exception ex) {
//					ex.printStackTrace();
//				}

				
				ProgressBar pb = new ProgressBar();
				//pb.setEndlessAutomatic();
				pb.setBackForeColors(Color.getRGB(165, 205, 250), Color.getRGB(0, 118, 255));
				c.add(pb, LEFT, AFTER + (gap * 2), FILL, 5 + DP);

				c.resizeHeight();
				resizeHeight();
			}
		};
	};
};


