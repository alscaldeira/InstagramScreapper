/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.repository;

/**
 *
 * @author alscaldeira
 */
public class SearchConfiguration {
    
    public SearchConfiguration(Query query) {
        System.setProperty("webdriver.gecko.driver", EnumLocation.LOCAL_GECKO_DRIVER.getValue());
        this.query = query;
    }
    
    public void setConfigUsingTestValues() {
        this.query = new Query();
        this.query.setDdd("");
        this.query.setKeyWord("consultor seguros");
        this.query.setLimitResults(2);
    }
    
    private Query query;
    
    public Query getSeachProperty() {
        return this.query;
    }
    
    public void setSeachProperty(Query property) {
        this.query = property;
    }
}
