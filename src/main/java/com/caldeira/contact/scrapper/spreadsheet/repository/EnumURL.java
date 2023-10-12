/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.repository;

/**
 *
 * @author alscaldeira
 */
public enum EnumURL {
    
    GOOGLE("https://www.google.com/"),
    INSTAGRAM("instagram.com");
    
    private final String value;
        
    EnumURL(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
    
}
