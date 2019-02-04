package com.surminen.springboot.microservice.retriever.springbootmicroservicegooglesheetslogretriever;

import java.time.LocalDate;

/**
 * TODO
 */
public class LogDataBean
{
    private Long id;
    private LocalDate date;
    private String log;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * @return the logData
     */
    public String getLog()
    {
        return log;
    }

    /**
     * @param log
     *            the logData to set
     */
    public void setLog(String log)
    {
        this.log = log;
    }

    /**
     * Default constructor
     */
    public LogDataBean()
    {

    }

    /**
     * Constructor that takes the date and data to use
     * 
     * @param date
     * @param log
     */
    public LogDataBean(LocalDate date, String log)
    {
        super();
        this.id = null;
        this.date = date;
        this.log = log;
    }
    
    @Override
    public String toString()
    {
        return id + ", " + date + ", " + log;
    }
}