package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.Grid;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class Issue_384 extends BaseIssue {
    public Issue_384() {
        super("Cor nas linhas do grid", "Grid issue", 384, false);
    }

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                String[] gridCaptions = {"Código", "Descritivo", "Login"};
                int[] gridWidths = {-15, -50, -35};
                int[] gridAlingns = {RIGHT, LEFT, LEFT};

                Grid gridUsuarios = new Grid(gridCaptions, gridWidths, gridAlingns, false);
                gridUsuarios.firstStripeColor = Color.WHITE;
                gridUsuarios.secondStripeColor = Color.CYAN;
                gridUsuarios.verticalLineStyle = Grid.VERT_LINE;
                gridUsuarios.disableSort = true;
                gridUsuarios.enableColumnResize = true;

                add(gridUsuarios, LEFT, AFTER + UnitsConverter.toPixels(DP + 80), FILL, DP + 200);

            }
        };
    };

}
