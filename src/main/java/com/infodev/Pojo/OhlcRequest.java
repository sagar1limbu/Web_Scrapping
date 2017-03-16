package com.infodev.Pojo;

import java.util.Date;

/**
 * Created by reddevil on 2/12/2017.
 */
public class OhlcRequest {
    private String sSymbol;
    private Date fromDate;
    private Date toDate;

    public OhlcRequest() {
    }

    public OhlcRequest(String sSymbol, Date fromDate, Date toDate) {
        this.sSymbol = sSymbol;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getsSymbol() {
        return sSymbol;
    }

    public void setsSymbol(String sSymbol) {
        this.sSymbol = sSymbol;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}


