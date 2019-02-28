package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.ui.Container;
import totalcross.ui.chart.ArcChart;
import totalcross.ui.chart.Chart;
import totalcross.ui.gfx.Color;

public class Issue_350 extends BaseIssue {

	public Issue_350() {
		super("Problemas no gráfico de pizza", "Chart Issues", 350, false);
	}

	@Override
	protected Container InitIssue() {
		return new Container() {
			@Override
			public void initUI() {
				Chart chart = new ArcChart();
				chart.xDecimalPlaces = chart.yDecimalPlaces = 0;
				chart.showTitle = true;
				chart.showLegend = false;
				chart.legendPosition = BOTTOM;
				chart.showCategories = true;

				chart.series.addElement(new totalcross.ui.chart.Series("nada", new double[] { 40d }, Color.GREEN));
				chart.series.addElement(new totalcross.ui.chart.Series("tudo", new double[] { 40d }, Color.BLUE));

				chart.series.addElement(new totalcross.ui.chart.Series("nada", new double[] { 10000d }, Color.GREEN));
				chart.series.addElement(new totalcross.ui.chart.Series("tudo", new double[] { 1d }, Color.RED));

				chart.series.addElement(new totalcross.ui.chart.Series("nada", new double[] { 10000d }, Color.GREEN));
				chart.series.addElement(new totalcross.ui.chart.Series("tudo", new double[] { 10d }, Color.RED));
			
				add(chart, LEFT, TOP, FILL, FILL);
			}
		};
	};
}
