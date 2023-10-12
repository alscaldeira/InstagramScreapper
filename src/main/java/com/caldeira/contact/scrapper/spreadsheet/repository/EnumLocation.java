/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.repository;

/**
 *
 * @author alscaldeira
 */
public enum EnumLocation {
 
    LOCAL_GECKO_DRIVER("/src/main/java/com/caldeira/resources/geckodriver"),
    LOCAL_CREDENTIALS("/src/main/resources/credentials");
    
    private final String value;
        
    EnumLocation(String value) {
        String currentDir = System.getProperty("user.dir");
        this.value = currentDir + value;
    }
    
    public String getValue() {
        return this.value;
    }
    
}
