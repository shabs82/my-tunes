package mediaplayer.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import mediaplayer.be.Song;
import mediaplayer.dal.SongDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteSongController implements Initializable {
    private String songTitle = "";
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField textfieldTitle;

    @FXML
    private void deleteTheSong(ActionEvent event) {
        //implement this
        //put this in the database
        SongDAO songDAO = null;
        try {
            songDAO = new SongDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final boolean success = true;
       // final boolean success = songDAO.deleteSong(textfieldTitle.getText());
        if(success){
            songTitle = textfieldTitle.getText();
        }


    }

    public String getSongTitle() {
        return songTitle;
    }
}
