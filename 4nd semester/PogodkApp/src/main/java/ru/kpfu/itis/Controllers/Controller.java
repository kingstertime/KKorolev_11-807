package ru.kpfu.itis.Controllers;

import ru.kpfu.itis.Models.ImageHandler;
import ru.kpfu.itis.Models.WeatherManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    WeatherManager weatherManager;
    String citySet;

    @FXML
    private ImageView img;
    @FXML
    private JFXButton change, set, cancel;
    @FXML
    private JFXTextField cityName, invis;
    @FXML
    private Label city, temperature, day, desc, errors, windSpeed, cloudiness, pressure, humidity;

    public Controller() {
        this.citySet = "Kazan".toUpperCase();
    }

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent ae) {
        String initialCity = city.getText();

        if(ae.getSource() == change){
            cityName.setText("");
            bottomSet(true);
            cityName.requestFocus();
        }else if (ae.getSource() == set) {
            setPressed();
        } else if (ae.getSource() == cancel) {
            cityName.setText(initialCity);
            bottomSet(false);
            invis.requestFocus();
        }
    }

    private void reset() {
        bottomSet(false);
        day.setText("");
        temperature.setText("");
        desc.setText("");
        windSpeed.setText("");
        cloudiness.setText("");
        pressure.setText("");
        humidity.setText("");
        img.setImage(null);
    }

    private void setPressed(){
        //if user enters nothing into cityName field
        if(cityName.getText().equals("")){
            showToast("City Name cannot be blank");
            return;
        }else {
            try {
                errors.setText("");
                this.citySet = cityName.getText().trim();
                cityName.setText((cityName.getText().trim()).toUpperCase());
                weatherManager = new WeatherManager(citySet);
                showWeather();
                bottomSet(false);
                invis.requestFocus();
            }catch(Exception e){
                city.setText("Error!!");
                city.setTextFill(Color.TOMATO);
                showToast("City with the given name was not found.");
                reset();
                invis.requestFocus();
            }
        }
    }

    private void bottomSet(boolean statement){
        cityName.setDisable(!statement);
        set.setVisible(statement);
        change.setVisible(!statement);
        cancel.setVisible(statement);
    }

    private void showToast(String message) {
        errors.setText(message);
        errors.setTextFill(Color.TOMATO);
        errors.setStyle("-fx-background-color: #fff; -fx-background-radius: 50px;");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), errors);
        fadeIn.setToValue(1);
        fadeIn.setFromValue(0);
        fadeIn.play();

        fadeIn.setOnFinished(event -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.play();
            pause.setOnFinished(event2 -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), errors);
                fadeOut.setToValue(0);
                fadeOut.setFromValue(1);
                fadeOut.play();
            });
        });
    }

    private void showWeather(){
        weatherManager.getWeather();
        city.setText(weatherManager.getCity().toUpperCase());
        temperature.setText(weatherManager.getTemperature().toString()+"°C");
        desc.setText(weatherManager.getDescription().toUpperCase());
        img.setImage(new Image(ImageHandler.getImage(weatherManager.getIcon())));
    }

    public void initialize(URL location, ResourceBundle resources) {
        cityName.setText(citySet);
        cityName.setDisable(true);
        set.setVisible(false);
        cancel.setVisible(false);
        errors.setText("");
        weatherManager = new WeatherManager(citySet);
        invis.requestFocus();

        try{
            showWeather();
        } catch (Exception e){
            city.setText("Error!! - No Internet");
            city.setTextFill(Color.TOMATO);
            showToast("Internet Down. Please Connect");
            reset();
            change.setDisable(true);
            cityName.setText("");
        }

        cityName.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                setPressed();
            }
        });
    }
}