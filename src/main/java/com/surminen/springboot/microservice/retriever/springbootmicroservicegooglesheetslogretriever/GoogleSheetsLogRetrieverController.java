package com.surminen.springboot.microservice.retriever.springbootmicroservicegooglesheetslogretriever;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets.Values.Get;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

/**
 * TODO
 */
@RestController
public class GoogleSheetsLogRetrieverController
{

    private static final String SPREADSHEET_ID = "1E883zDTOeyELLgnCKNPKEe1zEUuK7_oZk_2fUmxrQ1E";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogDbServiceProxy proxy;

    /**
     * TODO
     * 
     * @param from
     * @param to
     * @return TODO
     * @throws GeneralSecurityException 
     * @throws IOException 
     */
    @GetMapping("/read-logs/from/{from}/to/{to}")
    public String readLogs(@PathVariable String from, @PathVariable String to) throws IOException, GeneralSecurityException
    {
        
        Sheets service = SheetsServiceUtil.getSheetsService();

        
        ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                  Arrays.asList("Expenses January"), 
                  Arrays.asList("books", "30"), 
                  Arrays.asList("pens", "10"),
                  Arrays.asList("Expenses February"), 
                  Arrays.asList("clothes", "20"),
                  Arrays.asList("shoes", "5")));
        UpdateValuesResponse result = service.spreadsheets().values()
                .update(SPREADSHEET_ID, "A1", body)
                .setValueInputOption("RAW")
                .execute();

//        SpreadsheetProperties properties = new SpreadsheetProperties().setTitle("myTestSheet1");
//        Spreadsheet test = new Spreadsheet().setProperties(properties).setSpreadsheetId("1E883zDTOeyELLgnCKNPKEe1zEUuK7_oZk_2fUmxrQ1E");
//        service.spreadsheets().create(test).execute();
        
        return "Values updated. <br />";
//        return "Logs read: " + from + " to " + to + "<br />";
    }

    /**
     * TODO
     * 
     * @return TODO
     */
    @GetMapping("/read-logs")
    public String readLogs()
    {
        
        
//        LogDataBean log = new LogDataBean(decodeDate(from), logData);
//        proxy.putLogValue(log);
        
        return "All logs read." + "<br /";
    }
    
    /**
     * TODO
     * 
     * @param date
     * @return TODO
     */
    private LocalDate decodeDate(String date)
    {
        System.out.println("Converting: " + date);
        LocalDate localDate = LocalDate.parse(date.replace("_", "/"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return localDate;
    }
}