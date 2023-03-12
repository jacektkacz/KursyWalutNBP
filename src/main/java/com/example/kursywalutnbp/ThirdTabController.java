package com.example.kursywalutnbp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Collections;

public class ThirdTabController extends XML {

    @FXML
    private LineChart lineChart;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button buttonDownload;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private ObservableList<String> checkBoxItems = FXCollections.observableArrayList("USD");

    private XYChart.Series<Double, String[]> series = new XYChart.Series<>();

    public LineChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChart lineChart) {
        this.lineChart = lineChart;
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

    public ChoiceBox getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox choiceBox) {
        this.choiceBox = choiceBox;
    }

    public void initialize(){
        datePicker.setValue(LocalDate.now());
        xAxis.setLabel("Data");
        yAxis.setLabel("Kurs");
        choiceBox.setItems(checkBoxItems);
        yAxis.setUpperBound(10);
        // Disabled animation, because it stacks data on screen
        lineChart.setAnimated(false);


    }

    public void getXMLButton(ActionEvent actionEvent){
        getXMLCurrency(choiceBox, datePicker);
        ObservableList<XYChart.Series<String, Double>> list = FXCollections.observableArrayList();
        XYChart.Series<String,Double> series1 = new XYChart.Series<>();
        XYChart.Series<String,Double> series2 = new XYChart.Series<>();
        series1.setName("Kurs kupna");
        series2.setName("Kurs sprzedaży");
        for (int i = 0; i < getCurrencies().length; i++){
            series1.getData().add(new XYChart.Data<>(getData().get(i).getCurrencyRateDate(), Double.parseDouble(getData().get(i).getCurrencyBuyExchange())));
            series2.getData().add(new XYChart.Data<>(getData().get(i).getCurrencyRateDate(), Double.parseDouble(getData().get(i).getCurrencySaleExchange())));
        }
        list.addAll(series1, series2);
        lineChart.setData(list);
        yAxis.setForceZeroInRange(false);


    }



}
