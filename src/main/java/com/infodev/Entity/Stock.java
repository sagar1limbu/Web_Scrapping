package com.infodev.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by ranji on 2/17/2017.
 */
@Entity
public class Stock {
    private int id;
    private Date entryDate;
    private int entryUserId;
    private BigDecimal parValue;
    private int status;
    private Timestamp statusChgDate;
    private int statusChgUserId;
    private String stockName;
    private String stockSymbol;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EntryDate", nullable = false)
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Basic
    @Column(name = "EntryUserID", nullable = false)
    public int getEntryUserId() {
        return entryUserId;
    }

    public void setEntryUserId(int entryUserId) {
        this.entryUserId = entryUserId;
    }

    @Basic
    @Column(name = "ParValue", nullable = false, precision = 2)
    public BigDecimal getParValue() {
        return parValue;
    }

    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    @Basic
    @Column(name = "Status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "StatusChgDate", nullable = false)
    public Timestamp getStatusChgDate() {
        return statusChgDate;
    }

    public void setStatusChgDate(Timestamp statusChgDate) {
        this.statusChgDate = statusChgDate;
    }

    @Basic
    @Column(name = "StatusChgUserID", nullable = false)
    public int getStatusChgUserId() {
        return statusChgUserId;
    }

    public void setStatusChgUserId(int statusChgUserId) {
        this.statusChgUserId = statusChgUserId;
    }

    @Basic
    @Column(name = "StockName", nullable = false, length = 100)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "StockSymbol", nullable = false, length = 15)
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (entryUserId != stock.entryUserId) return false;
        if (status != stock.status) return false;
        if (statusChgUserId != stock.statusChgUserId) return false;
        if (entryDate != null ? !entryDate.equals(stock.entryDate) : stock.entryDate != null) return false;
        if (parValue != null ? !parValue.equals(stock.parValue) : stock.parValue != null) return false;
        if (statusChgDate != null ? !statusChgDate.equals(stock.statusChgDate) : stock.statusChgDate != null)
            return false;
        if (stockName != null ? !stockName.equals(stock.stockName) : stock.stockName != null) return false;
        if (stockSymbol != null ? !stockSymbol.equals(stock.stockSymbol) : stock.stockSymbol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + entryUserId;
        result = 31 * result + (parValue != null ? parValue.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (statusChgDate != null ? statusChgDate.hashCode() : 0);
        result = 31 * result + statusChgUserId;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
        return result;
    }
}
