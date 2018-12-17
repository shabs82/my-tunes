/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer.gui.controller;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mediaplayer.be.Song;
import mediaplayer.dal.SongDAO;

import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author a
 */
public class NewSongController implements Initializable {

    @FXML
    private Label testLabel;
    @FXML
    private TextField textfieldTitle;
    @FXML
    private TextField textfieldArtist;
    @FXML
    private TextField textfieldFile;

    private Song newSong;
    private static int songId = 0;
    public Song getNewSong() {
        return newSong;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void saveTheSong(ActionEvent event) {
        //implement this
        //put this in the database
        int year =2010;
        try {
            SongDAO songDAO = new SongDAO();
           // newSong = songDAO.createSong(textfieldTitle.getText(), textfieldArtist.getText(), "textFieldGenre", year, 5d);
            newSong =new Song(textfieldTitle.getText(), textfieldArtist.getText(), "textFieldGenre", year, 5d);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
    @FXML
    private void openSong(ActionEvent event) {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        Component aComponent = null;
        //In response to a button click:
        int returnVal = fc.showOpenDialog(aComponent);
        File file = fc.getSelectedFile();
        textfieldFile.setText(file.getName());
    }
    
    /*
    better way of selecting files from directory:
    @FXML
    private void chooseURL(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
        chooser.setDialogTitle("Select song database");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "MP3 and Wav files", "mp3",".wav");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            urlField.setText(chooser.getSelectedFile().getAbsolutePath());
            mediaPlayer = new MediaPlayer(new Media(new File(chooser.getSelectedFile().getAbsolutePath()).toURI().toString()));
            mediaPlayer.setOnReady(() -> {
                timeField.setText("" + mediaPlayer.getMedia().getDuration().toSeconds());
            });
        }
    }
    */
    
}
