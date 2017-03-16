package com.infodev.Entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ranji on 2/17/2017.
 */
@Entity
public class StockPriceDetl {
    private int id;
    private BigDecimal amount;
    private BigDecimal closingPrice;
    private BigDecimal diffAmount;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
    private int numberOfTransaction;
    private BigDecimal previousClosingPrice;
    private Timestamp statusChgDate;
    private int statusChgUserId;
    private int tradedShares;
    private Stock stockByStockId;
    private StockPriceMast stockPriceMastByStockId;
    //private StockPriceMast

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "ClosingPrice", nullable = false, precision = 2)
    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    @Basic
    @Column(name = "DiffAmount", nullable = false, precision = 2)
    public BigDecimal getDiffAmount() {
        return diffAmount;
    }

    public void setDiffAmount(BigDecimal diffAmount) {
        this.diffAmount = diffAmount;
    }

    @Basic
    @Column(name = "MaxPrice", nullable = false, precision = 2)
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "MinPrice", nullable = false, precision = 2)
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Basic
    @Column(name = "NumberOfTransaction", nullable = false)
    public int getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public void setNumberOfTransaction(int numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    @Basic
    @Column(name = "PreviousClosingPrice", nullable = false, precision = 2)
    public BigDecimal getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(BigDecimal previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
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
    @Column(name = "TradedShares", nullable = false)
    public int getTradedShares() {
        return tradedShares;
    }

    public void setTradedShares(int tradedShares) {
        this.tradedShares = tradedShares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPriceDetl that = (StockPriceDetl) o;

        if (id != that.id) return false;
        if (numberOfTransaction != that.numberOfTransaction) return false;
        if (statusChgUserId != that.statusChgUserId) return false;
        if (tradedShares != that.tradedShares) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (closingPrice != null ? !closingPrice.equals(that.closingPrice) : that.closingPrice != null) return false;
        if (diffAmount != null ? !diffAmount.equals(that.diffAmount) : that.diffAmount != null) return false;
        if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
        if (previousClosingPrice != null ? !previousClosingPrice.equals(that.previousClosingPrice) : that.previousClosingPrice != null)
            return false;
        if (statusChgDate != null ? !statusChgDate.equals(that.statusChgDate) : that.statusChgDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (closingPrice != null ? closingPrice.hashCode() : 0);
        result = 31 * result + (diffAmount != null ? diffAmount.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + numberOfTransaction;
        result = 31 * result + (previousClosingPrice != null ? previousClosingPrice.hashCode() : 0);
        result = 31 * result + (statusChgDate != null ? statusChgDate.hashCode() : 0);
        result = 31 * result + statusChgUserId;
        result = 31 * result + tradedShares;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StockId", referencedColumnName = "Id", nullable = false)
    //@JoinColumn(name = "MastId",referencedColumnName = "Id",nullable = false)
    @Fetch(FetchMode.JOIN)
    public Stock getStockByStockId() {

        return stockByStockId;
    }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }

    @ManyToOne
    @JoinColumn(name = "MastId",referencedColumnName = "Id",nullable = false)
    public StockPriceMast getMastByStockId(){
        return stockPriceMastByStockId;
    }
    public void setMastByStockId(StockPriceMast stockPriceMastByStockId){
        this.stockPriceMastByStockId=stockPriceMastByStockId;
    }


/*   @ManyToOne
   @JoinTable(name = "StockPriceDetl",
            joinColumns =@JoinColumn(name = "StockId",referencedColumnName = "Id",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "MastId",referencedColumnName = "Id",nullable = false))
   public Stock getStockByStockId() {
       return stockByStockId;
   }

    public void setStockByStockId(Stock stockByStockId) {
        this.stockByStockId = stockByStockId;
    }

   public StockPriceMast getStockPriceMastByStockId(){
       return
    }*/



}
