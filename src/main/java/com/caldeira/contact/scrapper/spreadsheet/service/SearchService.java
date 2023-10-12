/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.service;

import com.caldeira.contact.scrapper.spreadsheet.repository.EnumURL;
import com.caldeira.contact.scrapper.spreadsheet.repository.SearchConfiguration;
import com.caldeira.contact.scrapper.spreadsheet.repository.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author alscaldeira
 */
public class SearchService {
    
    public static void initializeSearch(SearchConfiguration config) {
        FirefoxDriver driver = new FirefoxDriver();
        List<String> inputs = new ArrayList();
        
        try {
            Query property = config.getSeachProperty();

            driver.get(EnumURL.GOOGLE.getValue());
            Thread.sleep(Long.parseLong("1000"));
            String query = "site:instagram.com \"" + property.getKeyWord()+ "\" \"" + property.getDdd() + "\" -linktr.ee -tinyurl.com -linktree.com.br";

            driver.findElement(By.name("q")).sendKeys(query + Keys.ENTER);
            Thread.sleep(Long.parseLong("1000"));

            // pega os links pelo google
            for(int count=0; count < property.getLimitResults(); count++) {
                Thread.sleep(Long.parseLong("1000"));

                List<String> list = extract(driver);
                for(int i=0; i < list.size(); i++) {				
                    inputs.add(list.get(i));
                }
                try {
                    WebElement nxtBtn = driver.findElement(By.id("pnnext"));
                    nxtBtn.click();
                } catch (Exception e) {
                    System.err.println("Não existe nenhum botão de próxima página");
                    break;
                }
            }
            new ExcelService().generateSpreadsheet(inputs);
        } catch(InterruptedException | NumberFormatException e) {
            System.err.print(e.getMessage());
        } finally {
            driver.quit();
        }
    }
    
    public static List<String> extract(FirefoxDriver driver) throws NumberFormatException, InterruptedException {
        List<WebElement> list = driver.findElements(By.className("g"));
        List<WebElement> allLinks = new ArrayList<>();
        List<String> links = new ArrayList<>();

        for(int i=0; i < list.size(); i++) {
            allLinks.add(list.get(i).findElement(By.tagName("a")));
            allLinks.stream()
                    .filter(link -> isFromInstagram(link))
                    .collect(Collectors.toList());
            
            for(WebElement a : allLinks) {
                links.add(a.getAttribute("href"));
            }
        }

        return links;
    }
    
    private static boolean isFromInstagram(WebElement link) {
        return link.getAttribute("href").contains(EnumURL.INSTAGRAM.getValue());
    }
    
}
