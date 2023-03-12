package com.example.kursywalutnbp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public abstract class XML {

    private ObservableList<Currency> data = FXCollections.observableArrayList();

    private Document document;

    private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private DocumentBuilder documentBuilder;

    private Currency[] currencies;

    private Currency[] currencies1;

    private ObservableList<Currency> data1 = FXCollections.observableArrayList();

    private NodeList nodeList;

    private Map<Integer, String[]> currencyData = new TreeMap<>();

    private String currencyName, currencyCode, currencyValue, currencyBuyExchange, currencySaleExchange, currencyRateDate = null;

    private String tableName;

    public Map<Integer, String[]> getCurrencyData() {
        return currencyData;
    }

    public ObservableList<Currency> getData() {
        return data;
    }

    public void setData(ObservableList<Currency> data) {
        this.data = data;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public DocumentBuilderFactory getDocumentBuilderFactory() {
        return documentBuilderFactory;
    }

    public void setDocumentBuilderFactory(DocumentBuilderFactory documentBuilderFactory) {
        this.documentBuilderFactory = documentBuilderFactory;
    }

    public DocumentBuilder getDocumentBuilder() {
        return documentBuilder;
    }

    public void setDocumentBuilder(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public Currency[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currency[] currencies) {
        this.currencies = currencies;
    }

    public NodeList getNodeList() {
        return nodeList;
    }

    public void setNodeList(NodeList nodeList) {
        this.nodeList = nodeList;
    }

    public void setCurrencyData(Map<Integer, String[]> currencyData) {
        this.currencyData = currencyData;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getCurrencyBuyExchange() {
        return currencyBuyExchange;
    }

    public void setCurrencyBuyExchange(String currencyBuyExchange) {
        this.currencyBuyExchange = currencyBuyExchange;
    }

    public String getCurrencySaleExchange() {
        return currencySaleExchange;
    }

    public void setCurrencySaleExchange(String currencySaleExchange) {
        this.currencySaleExchange = currencySaleExchange;
    }

    public String getCurrencyRateDate() {
        return currencyRateDate;
    }

    public void setCurrencyRateDate(String currencyRateDate) {
        this.currencyRateDate = currencyRateDate;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Currency[] getCurrencies1() {
        return currencies1;
    }

    public void setCurrencies1(Currency[] currencies1) {
        this.currencies1 = currencies1;
    }

    public ObservableList<Currency> getData1() {
        return data1;
    }

    public void setData1(ObservableList<Currency> data1) {
        this.data1 = data1;
    }

    public void getXMLABTable(ChoiceBox choiceBox, DatePicker datePicker, TableView tableView, Label label) {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        try {
            document = documentBuilder.parse(new URL(setURL(choiceBox.getValue().toString(), datePicker.getValue().toString())).openStream());
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            label.setText("Brak danych - proszę wybrać inną datę.");
            data.clear();
            throw new RuntimeException(e);
        }

        document.getDocumentElement().normalize();
        nodeList = document.getElementsByTagName("Rate");
        currencies = new Currency[nodeList.getLength()];
        tableName = document.getElementsByTagName("No").item(0).getTextContent();
        label.setText(tableName);

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node node = nodeList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                currencyName = element.getElementsByTagName("Currency").item(0).getTextContent();
                currencyCode = element.getElementsByTagName("Code").item(0).getTextContent();
                currencyValue = element.getElementsByTagName("Mid").item(0).getTextContent();
            }
            currencies[temp] = new Currency(currencyName, currencyCode, currencyValue);
            data.setAll(currencies);
            currencyData.put(temp, new String[]{currencyName, currencyCode, currencyValue});
        }
        tableView.setItems(data);
    }

    public void getXMLCTable(DatePicker datePicker, TableView tableView, Label label){
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        try {
            document = documentBuilder.parse(new URL(setURL("C", datePicker.getValue().toString())).openStream());
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            label.setText("Brak danych - proszę wybrać inną datę.");
            data.clear();
            throw new RuntimeException(e);
        }

        document.getDocumentElement().normalize();
        nodeList = document.getElementsByTagName("Rate");
        currencies = new Currency[nodeList.getLength()];
        tableName = document.getElementsByTagName("No").item(0).getTextContent();
        label.setText(tableName);

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node node = nodeList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                currencyName = element.getElementsByTagName("Currency").item(0).getTextContent();
                currencyCode = element.getElementsByTagName("Code").item(0).getTextContent();
                currencyBuyExchange = element.getElementsByTagName("Bid").item(0).getTextContent();
                currencySaleExchange = element.getElementsByTagName("Ask").item(0).getTextContent();
            }
            currencies[temp] = new Currency(currencyName, currencyCode, currencyBuyExchange, currencySaleExchange);
            data.setAll(currencies);
            currencyData.put(temp, new String[]{currencyName, currencyCode, currencyBuyExchange, currencySaleExchange});
        }
        tableView.setItems(data);

    }

    public void getXMLCurrency(ChoiceBox choiceBox, DatePicker datePicker){
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        try {
            document = documentBuilder.parse(new URL(setURLSingleCurrency()).openStream());
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            //label.setText("Brak danych - proszę wybrać inną datę.");
            data.clear();
            throw new RuntimeException(e);
        }

        document.getDocumentElement().normalize();
        nodeList = document.getElementsByTagName("Rate");
        currencies = new Currency[nodeList.getLength()];
        currencies1 = new Currency[nodeList.getLength()];
        // tableName = document.getElementsByTagName("No").item(0).getTextContent();
        currencyName = document.getElementsByTagName("Currency").item(0).getTextContent();
        currencyCode = document.getElementsByTagName("Code").item(0).getTextContent();
        //label.setText(tableName);

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node node = nodeList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                currencyBuyExchange = element.getElementsByTagName("Bid").item(0).getTextContent();
                currencySaleExchange = element.getElementsByTagName("Ask").item(0).getTextContent();
                currencyRateDate = element.getElementsByTagName("EffectiveDate").item(0).getTextContent();
            }
            //currencies[temp] = new Currency(currencyBuyExchange, currencyRateDate);
            currencies[temp] = new Currency(currencyName, currencyCode, currencyBuyExchange, currencySaleExchange, currencyRateDate);
            currencies1[temp] = new Currency();
            data.setAll(currencies);
            data1.setAll(currencies1);
            currencyData.put(temp, new String[]{currencyBuyExchange});
            System.out.println(currencyBuyExchange);
            System.out.println(currencySaleExchange);
        }
    }



    public static String setURL(String table, String date){
        return "http://api.nbp.pl/api/exchangerates/tables/" + table + "/" + date + "/?format=xml";
    }

    // Change URL, because it's only downloading last 10 rates
    public static String setURLSingleCurrency(){
        //return "http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/" + date + "/?format=xml";
        return "http://api.nbp.pl/api/exchangerates/rates/c/usd/last/10/?format=xml";
    }
}
