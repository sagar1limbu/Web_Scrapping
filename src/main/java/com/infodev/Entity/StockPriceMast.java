package com.infodev.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by ranji on 2/17/2017.
 */
@Entity
public class StockPriceMast {
    private int id;
    private Date entryDate;
    private int entryUserId;
    private String remarks;
    private int status;
    private Timestamp statusChgDate;
    private int statusChgUserId;
    private Date tranDate;

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
    @Column(name = "Remarks", nullable = false, length = 100)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    @Column(name = "TranDate", nullable = false)
    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPriceMast that = (StockPriceMast) o;

        if (id != that.id) return false;
        if (entryUserId != that.entryUserId) return false;
        if (status != that.status) return false;
        if (statusChgUserId != that.statusChgUserId) return false;
        if (entryDate != null ? !entryDate.equals(that.entryDate) : that.entryDate != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (statusChgDate != null ? !statusChgDate.equals(that.statusChgDate) : that.statusChgDate != null)
            return false;
        if (tranDate != null ? !tranDate.equals(that.tranDate) : that.tranDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + entryUserId;
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (statusChgDate != null ? statusChgDate.hashCode() : 0);
        result = 31 * result + statusChgUserId;
        result = 31 * result + (tranDate != null ? tranDate.hashCode() : 0);
        return result;
    }

}
