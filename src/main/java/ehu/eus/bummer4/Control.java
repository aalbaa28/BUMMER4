package ehu.eus.bummer4;
import ehu.eus.bummer4.domain.Status;
import ehu.eus.bummer4.domain.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static ehu.eus.bummer4.domain.Utils.Principal;

public class Control {
    @FXML
    private Label welcomeText;


    @FXML
    private TextField autor;

    @FXML
    private TextField data;

    @FXML
    private Button next;

    @FXML
    private Button prev;

    @FXML
    private WebView web;

    private ArrayList<String> arrayData= new ArrayList<>();

    private ArrayList<String> arrayNick = new ArrayList<>();

    private ArrayList<String> arrayInfo = new ArrayList<>();

    private ArrayList<Status> arrayBoost=new ArrayList<>();

    private ArrayList<Status.Media_Attachments> arrayMedia = new ArrayList<>();

    private int cont=0;
    private int index=0;

    @FXML
    private Label alerta;

    @FXML
    private CheckBox boosted;

    @FXML
    private ImageView imagen;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void initialize(){

        System.out.println(Principal().get(cont).getMediaAttachments().get(index).getUrl());
        imagen.setVisible(false);
        boosted.setSelected(false);
        imagen();
        original();
            if (arrayBoost.get(cont)!=null){
                boosted.setSelected(true);
                data.setText(arrayBoost.get(cont).getCreated_at());
                autor.setText(arrayBoost.get(cont).getAccount().getUsername());
                web.getEngine().loadContent(arrayBoost.get(cont).getContent());
                if (Principal().get(cont).getReblog().getMediaAttachments().size()!=0){
                    Image img=new Image(Principal().get(cont).getMediaAttachments().get(0).getUrl());
                    imagen.setImage(img);
                }
            }
            else{
                data.setText(arrayData.get(cont));
                autor.setText(arrayNick.get(cont));
                web.getEngine().loadContent(arrayInfo.get(cont));
                if (Principal().get(cont).getMediaAttachments().size()!=0){
                    Image img=new Image(Principal().get(cont).getMediaAttachments().get(0).getUrl());
                    imagen.setImage(img);
                    imagen.setVisible(true);
                }

            }
    }

    public void original(){
        List<Status> lista= Utils.Principal();

        for (Status a:lista){
                arrayBoost.add(a.getReblog());
                arrayData.add(a.getCreated_at());
                arrayNick.add(a.getAccount().getUsername());
                arrayInfo.add(a.getContent());

        }


    }

    public void imagen(){


    }

    public void siguiente(){
        alerta.setText("");
        imagen.setVisible(false);

        if (cont<arrayBoost.size()-1){
            cont++;
        }

        if (cont>=arrayBoost.size()-1){
            alerta.setText("There's no next!!");
        }


        if (arrayBoost.get(cont)!=null && cont<=arrayBoost.size()-1){
            boosted.setSelected(true);
            data.setText(arrayBoost.get(cont).getCreated_at());
            autor.setText(arrayBoost.get(cont).getAccount().getUsername());
            web.getEngine().loadContent(arrayBoost.get(cont).getContent());
            if (Principal().get(cont).getReblog().getMediaAttachments().size()!=0){
                Image img=new Image(Principal().get(cont).getReblog().getMediaAttachments().get(0).getUrl());
                imagen.setImage(img);
                imagen.setVisible(true);
            }
        }
        else if(arrayBoost.get(cont)==null && cont<=arrayBoost.size()-1){
                boosted.setSelected(false);
                data.setText(arrayData.get(cont));
                autor.setText(arrayNick.get(cont));
                web.getEngine().loadContent(arrayInfo.get(cont));
                if (Principal().get(cont).getMediaAttachments().size()!=0){
                    Image img=new Image(Principal().get(cont).getMediaAttachments().get(0).getUrl());
                    imagen.setImage(img);
                    imagen.setVisible(true);
                }
        }
    }

    public void anterior(){
        imagen.setVisible(false);
        alerta.setText("");
        if (cont>0){
            cont--;
        }

        if (cont<=0){
            alerta.setText("There's no previous!!");
        }

        if (arrayBoost.get(cont)!=null && cont>=0){
            boosted.setSelected(true);
            data.setText(arrayBoost.get(cont).getCreated_at());
            autor.setText(arrayBoost.get(cont).getAccount().getUsername());
            web.getEngine().loadContent(arrayBoost.get(cont).getContent());
            if (Principal().get(cont).getReblog().getMediaAttachments().size()!=0){
                Image img=new Image(Principal().get(cont).getReblog().getMediaAttachments().get(0).getUrl());
                imagen.setImage(img);
                imagen.setVisible(true);
            }

        } else if (arrayBoost.get(cont)==null && cont>=0) {
            boosted.setSelected(false);
            data.setText(arrayData.get(cont));
            autor.setText(arrayNick.get(cont));
            web.getEngine().loadContent(arrayInfo.get(cont));
            if (Principal().get(cont).getMediaAttachments().size()!=0){
                Image img=new Image(Principal().get(cont).getMediaAttachments().get(0).getUrl());
                imagen.setImage(img);
                imagen.setVisible(true);
            }
        }
    }
    public boolean boton(){
        if (next.isPressed()){
            return true;
        }
        else{
            return false;
        }
    }

}