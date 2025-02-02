package com.example.wildanimals;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

public class Main extends Application {

    private TableView<WildAnimal> table;
    private ObservableList<WildAnimal> animalList;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wildlife Tracking Application");

        TextField speciesField = new TextField();
        speciesField.setPromptText("Вид животного");

        ComboBox<String> classComboBox = new ComboBox<>();
        classComboBox.getItems().addAll("Млекопитающее", "Птица", "Рептилия");
        classComboBox.setPromptText("Класс животного");

        ComboBox<String> feedComboBox = new ComboBox<>();
        feedComboBox.getItems().addAll("Животного происхождения", "Зерновой", "Растительный");
        feedComboBox.setPromptText("Вид корма");

        TextField licenseField = new TextField();
        licenseField.setPromptText("Номер лицензии");

        DatePicker licenseDatePicker = new DatePicker();
        licenseDatePicker.setPromptText("Дата регистрации лицензии");

        Button addButton = new Button("Добавить животное");
        Button editButton = new Button("Редактировать выбранное");
        Button deleteButton = new Button("Удалить выбранное");
        Button clearButton = new Button("Очистить поля");

        table = new TableView<>();
        animalList = FXCollections.observableArrayList();

        TableColumn<WildAnimal, String> speciesColumn = new TableColumn<>("Вид животного");
        speciesColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSpecies().getName()));

        TableColumn<WildAnimal, String> classColumn = new TableColumn<>("Класс животного");
        classColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSpecies().getAnimalClass().getName()));

        TableColumn<WildAnimal, String> feedColumn = new TableColumn<>("Вид корма");
        feedColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFeed().getType()));

        TableColumn<WildAnimal, String> licenseColumn = new TableColumn<>("Номер лицензии");
        licenseColumn.setCellValueFactory(data -> new SimpleStringProperty(licenseField.getText()));

        TableColumn<WildAnimal, String> licenseDateColumn = new TableColumn<>("Дата регистрации лицензии");
        licenseDateColumn.setCellValueFactory(data -> new SimpleStringProperty(licenseDatePicker.getValue() != null ? licenseDatePicker.getValue().toString() : ""));

        table.getColumns().addAll(speciesColumn, classColumn, feedColumn, licenseColumn, licenseDateColumn);
        table.setItems(animalList);

        addButton.setOnAction(e -> {
            AnimalClass animalClass = new AnimalClass(classComboBox.getValue());
            WildAnimalSpecies species = new WildAnimalSpecies(speciesField.getText(), animalClass);
            Feed feed = new Feed(feedComboBox.getValue(), 0.0);
            WildAnimal animal = new WildAnimal(animalList.size() + 1, speciesField.getText(), 0, 0.0, species, feed);
            animalList.add(animal);
        });

        editButton.setOnAction(e -> {
            WildAnimal selectedAnimal = table.getSelectionModel().getSelectedItem();
            if (selectedAnimal != null) {
                selectedAnimal.getSpecies().getAnimalClass().setName(classComboBox.getValue());
                selectedAnimal.getSpecies().setName(speciesField.getText());
                selectedAnimal.getFeed().setType(feedComboBox.getValue());
                table.refresh();
            }
        });

        deleteButton.setOnAction(e -> {
            WildAnimal selectedAnimal = table.getSelectionModel().getSelectedItem();
            if (selectedAnimal != null) {
                animalList.remove(selectedAnimal);
            }
        });

        clearButton.setOnAction(e -> {
            speciesField.clear();
            classComboBox.getSelectionModel().clearSelection();
            feedComboBox.getSelectionModel().clearSelection();
            licenseField.clear();
            licenseDatePicker.setValue(null);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(speciesField, classComboBox, feedComboBox, licenseField, licenseDatePicker, addButton, editButton, deleteButton, clearButton, table);

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


