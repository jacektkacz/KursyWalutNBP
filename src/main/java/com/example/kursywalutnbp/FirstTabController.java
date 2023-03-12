package com.example.kursywalutnbp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class FirstTabController extends XML {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Currency, String> currencyNameColumn;

    @FXML
    private TableColumn<Currency, String> currencyCodeColumn;

    @FXML
    private TableColumn<Currency, String> currencyValueColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button buttonDownload;

    @FXML
    private Button buttonExcel;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label labelTableName;

    private ObservableList<String> checkBoxItems = FXCollections.observableArrayList("A", "B");

    // Setters and getters

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public TableColumn getCurrencyNameColumn() {
        return currencyNameColumn;
    }

    public void setCurrencyNameColumn(TableColumn currencyNameColumn) {
        this.currencyNameColumn = currencyNameColumn;
    }

    public TableColumn getCurrencyCodeColumn() {
        return currencyCodeColumn;
    }

    public void setCurrencyCodeColumn(TableColumn currencyCodeColumn) {
        this.currencyCodeColumn = currencyCodeColumn;
    }

    public TableColumn getCurrencyValueColumn() {
        return currencyValueColumn;
    }

    public void setCurrencyValueColumn(TableColumn currencyValueColumn) {
        this.currencyValueColumn = currencyValueColumn;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public Button getButtonDownload() {
        return buttonDownload;
    }

    public void setButtonDownload(Button buttonDownload) {
        this.buttonDownload = buttonDownload;
    }

    public Button getButtonExcel() {
        return buttonExcel;
    }

    public void setButtonExcel(Button buttonExcel) {
        this.buttonExcel = buttonExcel;
    }

    public ChoiceBox getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox choiceBox) {
        this.choiceBox = choiceBox;
    }

    public void initialize(){
        datePicker.setValue(LocalDate.now());
        choiceBox.setItems(checkBoxItems);
        currencyNameColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyName"));
        currencyCodeColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyCode"));
        currencyValueColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyValue"));
    }

    public void getXMLButton(ActionEvent actionEvent) {
        getXMLABTable(choiceBox, datePicker, tableView, labelTableName);
    }

    public void excelButton(){
        ExcelFile file = new ExcelFile();
        file.saveExcelFile(labelTableName.getText(), getCurrencyData());
    }

}
