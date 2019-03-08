package tcissues.issues;

import tcissues.BaseIssue;
import totalcross.io.IOException;
import totalcross.sys.Vm;
import totalcross.ui.Container;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.ui.media.Camera;

public class Issue_331 extends BaseIssue {

    public Issue_331(){ super ("Camera buscando screenshots da galeria não funciona!", "Camera issue", 331, false);}

    @Override
    protected Container InitIssue() {
        return new Container() {
            @Override
            public void initUI() {
                super.initUI();

                System.out.println(Funcoes.retornaDataHora());

                Camera camera = new Camera();
                camera.cameraType = Camera.CAMERA_FROM_GALLERY;
                camera.captureMode = Camera.CAMERACAPTURE_MODE_STILL;
                camera.stillQuality = 999;
                camera.defaultFileName = "GPM_" + Funcoes.retornaDataHora() + ".jpg";
                String ret = null;
                try {
                    ret = camera.click();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vm.debug("RRRRRRRRRRRRRRR = "+ret);

                try {
                    Image img = new Image(ret);
                } catch (ImageException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                Image img = Funcoes.abreImagem(ret, imc.getWidth(), imc.getHeight());


            }
        };
    }


    private static class Funcoes{
        private static int number = -1;

        public static String retornaDataHora(){
            return number++ + "";
        }
    }
}
