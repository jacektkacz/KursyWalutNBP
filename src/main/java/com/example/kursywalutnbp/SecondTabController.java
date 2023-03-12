package com.example.kursywalutnbp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class SecondTabController extends XML {
    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Currency, String> currencyNameColumn;

    @FXML
    private TableColumn<Currency, String> currencyCodeColumn;

    @FXML
    private TableColumn<Currency, String> currencyExchangeColumn;

    @FXML
    private TableColumn<Currency, String> buyExchangeColumn;

    @FXML
    private TableColumn<Currency, String> saleExchangeColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button buttonDownload;

    @FXML
    private Button buttonExcel;

    @FXML
    private Label labelTableName;

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

    public TableColumn getCurrencyExchangeColumn() {
        return currencyExchangeColumn;
    }

    public void setCurrencyExchangeColumn(TableColumn currencyExchangeColumn) {
        this.currencyExchangeColumn = currencyExchangeColumn;
    }

    public TableColumn getBuyExchangeColumn() {
        return buyExchangeColumn;
    }

    public void setBuyExchangeColumn(TableColumn buyExchangeColumn) {
        this.buyExchangeColumn = buyExchangeColumn;
    }

    public TableColumn getSaleExchangeColumn() {
        return saleExchangeColumn;
    }

    public void setSaleExchangeColumn(TableColumn saleExchangeColumn) {
        this.saleExchangeColumn = saleExchangeColumn;
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

    public Label getLabelTableName() {
        return labelTableName;
    }

    public void setLabelTableName(Label labelTableName) {
        this.labelTableName = labelTableName;
    }

    public void initialize(){
        datePicker.setValue(LocalDate.now());
        currencyNameColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyName"));
        currencyCodeColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyCode"));
        buyExchangeColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencyBuyExchange"));
        saleExchangeColumn.setCellValueFactory(new PropertyValueFactory<Currency, String>("currencySaleExchange"));
    }

    public void getXMLButton(ActionEvent actionEvent){
        getXMLCTable(datePicker, tableView, labelTableName);
    }

    public void excelButton(){
        ExcelFile file = new ExcelFile();
        file.saveExcelFileC(labelTableName.getText(), getCurrencyData() );
    }


}
