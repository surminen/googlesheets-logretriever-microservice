package com.surminen.springboot.microservice.retriever.springbootmicroservicegooglesheetslogretriever;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 */
@RestController
public class StaticLogRetrieverController
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogDbServiceProxy proxy;

    /**
     * TODO
     * 
     * @param from
     * @param to
     * @return TODO
     */
    @GetMapping("/read-logs/from/{from}/to/{to}")
    public String readLogs(@PathVariable String from, @PathVariable String to)
    {
        
        
//        LogDataBean log = new LogDataBean(decodeDate(from), logData);
//        proxy.putLogValue(log);

        return "Logs read: " + from + " to " + to + "<br />";
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