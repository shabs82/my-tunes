/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer.gui.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import mediaplayer.be.Playlist;
import mediaplayer.be.Song;
import mediaplayer.dal.SongDAO;


/**
 *
 * @author a
 */
public class mainController implements Initializable {

    //DBConnect test = new DBConnect();
    @FXML private Label nowPlayingLabel;
    @FXML private ListView<Playlist> playlistView;
    @FXML private ListView<Song> songView = new ListView<>();
    @FXML private TextField TextFieldFilter;
    @FXML private Button button;
    @FXML private MediaView MediaView;

    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private void openNewSong(ActionEvent event) throws IOException{
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mediaplayer/gui/view/newSong.fxml"));
        Parent root = fxmlLoader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("/mediaplayer/gui/view/newSong.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/view/newSong.fxml"));
        //Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) new Stage();
        stage.setScene(scene);
        stage.showAndWait();
        //((Node) (event.getSource())).getScene().getWindow().hide();
        final NewSongController fxmlLoaderController = fxmlLoader.<NewSongController>getController();

        final Song newSong = fxmlLoaderController.getNewSong();
        if(newSong != null)
            songView.getItems().add(newSong);

    }

    @FXML
    private void deleteSelectedSong(ActionEvent deleteEvent) throws IOException{
        //read the song title and call the SongDao.delete the id and
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mediaplayer/gui/view/deleteSong.fxml"));
        Parent root = fxmlLoader.load();
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/view/newSong.fxml"));
        //Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) new Stage();
        stage.setScene(scene);
        stage.showAndWait();
        //((Node) (event.getSource())).getScene().getWindow().hide();
        final DeleteSongController fxmlLoaderController = fxmlLoader.<DeleteSongController>getController();

        int index =0;
        final Iterator<Song> iterator = songView.getItems().iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            if(song.getTitle() != null && song.getTitle().equalsIgnoreCase(fxmlLoaderController.getSongTitle())){
                iterator.remove();
            }
            index++;
        }

    }

    @FXML
    private void openNewPlaylist(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/mediaplayer/gui/view/newPlaylist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        //test.getItemsFromList();
        nowPlayingLabel.setText("You're Not Playing a Song :)");
    }

    @FXML
    private void testCreateSong(ActionEvent event) {
        //SongDAO test = new SongDAO();
        //test.createSong("Megan", "Megan", "Pop", 2018, 10.01);
        String path = new File("src/life.mp3").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }


    @FXML
    private void exitAction(ActionEvent event) throws InterruptedException {
        System.exit(0);
    }
}
