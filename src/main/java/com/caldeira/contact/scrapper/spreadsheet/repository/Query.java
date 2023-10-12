/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.repository;

/**
 *
 * @author alscaldeira
 */
public class Query {
    
    private String keyWord;
    private String ddd;
    private int limitResults;
    
    public Query() {}
    
    public Query(String keyWord, String ddd, int limitResults) {
        this.keyWord = keyWord;
        this.ddd = ddd;
        this.limitResults = limitResults;
    }
    
    public String getDdd() {
        return this.ddd;
    }
    
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    
    public String getKeyWord() {
        return this.keyWord;
    }
    
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
    public int getLimitResults() {
        return this.limitResults;
    }
    
    public void setLimitResults(int limitResults) {
        this.limitResults = limitResults;
    }
    
}
