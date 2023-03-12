package com.example.kursywalutnbp;

import javafx.beans.property.SimpleStringProperty;

public class Currency {

    private SimpleStringProperty currencyName;

    private SimpleStringProperty currencyCode;

    private SimpleStringProperty currencyValue;

    private SimpleStringProperty currencyBuyExchange;

    private SimpleStringProperty currencySaleExchange;

    private SimpleStringProperty currencyRateDate;

    public Currency(){

    }

    public Currency(String currencyName, String currencyCode, String currencyValue){
        this.currencyName = new SimpleStringProperty(currencyName);
        this.currencyCode = new SimpleStringProperty(currencyCode);
        this.currencyValue = new SimpleStringProperty(currencyValue);
    }

    public Currency(String currencyName, String currencyCode, String currencyBuyExchange, String currencySaleExchange){
        this.currencyName = new SimpleStringProperty(currencyName);
        this.currencyCode = new SimpleStringProperty(currencyCode);
        this.currencyBuyExchange = new SimpleStringProperty(currencyBuyExchange);
        this.currencySaleExchange = new SimpleStringProperty(currencySaleExchange);
    }

    public Currency(String currencyName, String currencyCode, String currencyBuyExchange, String currencySaleExchange, String currencyRateDate){
        this.currencyName = new SimpleStringProperty(currencyName);
        this.currencyCode = new SimpleStringProperty(currencyCode);
        this.currencyBuyExchange = new SimpleStringProperty(currencyBuyExchange);
        this.currencySaleExchange = new SimpleStringProperty(currencySaleExchange);
        this.currencyRateDate = new SimpleStringProperty(currencyRateDate);
    }

    public Currency(String currencyBuyExchange, String currencyRateDate){
        this.currencyBuyExchange = new SimpleStringProperty(currencyBuyExchange);
        this.currencyRateDate = new SimpleStringProperty(currencyRateDate);
    }


    public String getCurrencyName() {
        return currencyName.get();
    }

    public SimpleStringProperty currencyNameProperty() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName.set(currencyName);
    }

    public String getCurrencyCode() {
        return currencyCode.get();
    }

    public SimpleStringProperty currencyCodeProperty() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode.set(currencyCode);
    }

    public String getCurrencyValue() {
        return currencyValue.get();
    }

    public SimpleStringProperty currencyValueProperty() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue.set(currencyValue);
    }

    public String getCurrencyBuyExchange() {
        return currencyBuyExchange.get();
    }

    public SimpleStringProperty currencyBuyExchangeProperty() {
        return currencyBuyExchange;
    }

    public void setCurrencyBuyExchange(String currencyBuyExchange) {
        this.currencyBuyExchange.set(currencyBuyExchange);
    }

    public String getCurrencySaleExchange() {
        return currencySaleExchange.get();
    }

    public SimpleStringProperty currencySaleExchangeProperty() {
        return currencySaleExchange;
    }

    public void setCurrencySaleExchange(String currencySaleExchange) {
        this.currencySaleExchange.set(currencySaleExchange);
    }

    public String getCurrencyRateDate() {
        return currencyRateDate.get();
    }

    public SimpleStringProperty currencyRateDateProperty() {
        return currencyRateDate;
    }

    public void setCurrencyRateDate(String currencyRateDate) {
        this.currencyRateDate.set(currencyRateDate);
    }
}
