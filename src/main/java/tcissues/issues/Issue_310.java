package tcissues.issues;

import tcissues.BaseIssue;
import tcissues.resources.Colors;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Issue_310 extends BaseIssue {

    private ScrollContainer sc;
    private Container contTopo,contRodape;
    private Edit edtIdentificador;
    private Button btIdentificador,btFinalizar;
    private Label lblMultiplicacao,lblMensagem;


    public Issue_310(){ super ("Aplicação totalcross com imagens, quando faço o deploy para windows CE todo conteúdo some", "Image issue", 310, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                setBackColor(Colors.GRAY);
                setBorderStyle(BORDER_SIMPLE);

                try {


                    edtIdentificador = new Edit();
                    edtIdentificador.caption = "Insira o identificador";
                    edtIdentificador.setFont(Font.getFont("Lato Medium", false, edtIdentificador.getFont().size -2));
                    edtIdentificador.setBackForeColors(Color.BLACK, Color.BLACK);
                    edtIdentificador.requestFocus();

                    btIdentificador =
                            new Button(
                                    new Image("images/bt_edit.png")
                                            .hwScaledFixedAspectRatio((int) (Settings.screenDensity * 24), true));

                    btIdentificador.setBorder(Button.BORDER_NONE);
                    btIdentificador.setBackForeColors(Color.WHITE, Color.WHITE);


                    contTopo = new Container();
                    contTopo.setBackForeColors(Color.WHITE, Color.WHITE);
                    add(contTopo, CENTER, TOP, PARENTSIZE, PARENTSIZE+15);
                    contTopo.add(edtIdentificador, LEFT+170, TOP, PARENTSIZE+60, PARENTSIZE+80);
                    contTopo.add(btIdentificador, RIGHT, TOP, PARENTSIZE+20, PARENTSIZE+100);



                    lblMensagem = new Label("Adicione um indicador para listagem",CENTER);
                    lblMensagem.setBackForeColors(Colors.GRAY,0x999999 );
                    lblMensagem.setFont(Font.getFont("Lato Medium", false, lblMensagem.getFont().size -5));
                    add(lblMensagem,CENTER,CENTER,PARENTSIZE,PARENTSIZE+10);


                    contRodape = new Container();
                    contRodape.setBackForeColors(Colors.BLUE, Color.WHITE);
                    add(contRodape, CENTER, BOTTOM, PARENTSIZE, PARENTSIZE+10);
                    btFinalizar = new Button("Finalizar");
                    btFinalizar.transparentBackground = true;
                    contRodape.add(btFinalizar, RIGHT, CENTER, (int) (Settings.screenDensity * 100), PREFERRED+20);



                } catch (IOException | ImageException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        };
    }

}
