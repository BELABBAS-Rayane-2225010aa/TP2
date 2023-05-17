package com.example.tp2.exo1;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ConteneurBorderPaine extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;
    private IntegerProperty nbFois = new SimpleIntegerProperty();
    private StringProperty message = new SimpleStringProperty();

    private Button vert;
    private Button rouge;
    private Button bleu;


    private BorderPane root;
    private Label labelChoice;
    private Label label;
    private Pane colorPane;
    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");
    private BorderPane botlane;
    private HBox btnBot;
    private VBox labelBot;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        label = new Label();
        label.setAlignment(Pos.BASELINE_RIGHT);

        labelChoice = new Label();
        labelChoice.setAlignment(Pos.CENTER);

        colorPane = new Pane();
        colorPane.setPrefSize(400,200);

        botlane = new BorderPane();

        btnBot = new HBox();
        btnBot.setAlignment(Pos.CENTER);
        btnBot.setPadding(new Insets(10,5,10,5));

        labelBot = new VBox();
        labelBot.setAlignment(Pos.TOP_RIGHT);
        labelBot.getChildren().add(label);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        labelChoice.textProperty().bind(Bindings.concat(message, " choisi ", nbFois.asString(), " fois"));
        colorPane.styleProperty().bind(couleurPanneau);
        rouge.setOnAction(event -> {
            nbFois.set(++nbRouge);
            couleurPanneau.set("-fx-background-color: red");
            message.set(rouge.getText());
            label.setText(message.get()+" est une jolie couleur!!! ");
            label.setStyle("-fx-text-fill: red");

        });
        vert.setOnAction(event -> {
            nbFois.set(++nbVert);
            couleurPanneau.set("-fx-background-color: green");
            message.set(vert.getText());
            label.setText(message.get()+" est une jolie couleur!!! ");
            label.setStyle("-fx-text-fill: green");
        });
        bleu.setOnAction(event -> {
            nbFois.set(++nbBleu);
            couleurPanneau.set("-fx-background-color: blue");
            message.set(bleu.getText());
            label.setText(message.get()+" est une jolie couleur!!! ");
            label.setStyle("-fx-text-fill: blue");
        });
        btnBot.getChildren().addAll(vert, rouge, bleu);
        botlane.setCenter(btnBot);
        botlane.setBottom(labelBot);

        root.setCenter(colorPane);
        root.setTop(labelChoice);
        root.setBottom(botlane);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createBindings(BooleanProperty pasEncoreDeClic){

    }
}