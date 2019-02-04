package com.surminen.springboot.microservice.retriever.springbootmicroservicegooglesheetslogretriever;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO
 */
@FeignClient(name="log-data")
@RibbonClient(name="log-data")
public interface LogDbServiceProxy
{
    /**
     * TODO
     * 
     * @param from
     * @return the array of requested values
     */
    @GetMapping("/log-data/date/{date}")
    public LogDataBean[] retrieveLogValue(@PathVariable("date") String from);

    /**
     * TODO 
     * 
     * @param logData
     */
    @PutMapping("/log-data/add")
    public void putLogValue(@RequestBody LogDataBean logData);
}