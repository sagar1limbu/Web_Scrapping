package com.infodev.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by reddevil on 3/8/2017.
 */

@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String index_name;
    private String turnover;
    private String current_value;
    private String pointschange;
    private String currentP;

    private String currentClass;
    private String pointsChangeClass;
    private String percentClass;

    public Market(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getindex_name() {
        return index_name;
    }

    public void setindex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getCurrent_value() {
        return current_value;
    }

    public void setCurrent_value(String current_value) {
        this.current_value = current_value;
    }

    public String getPointschange() {
        return pointschange;
    }

    public void setPointschange(String pointschange) {
        this.pointschange = pointschange;
    }

    public String getCurrentP() {
        return currentP;
    }

    public void setCurrentP(String currentP) {
        this.currentP = currentP;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public String getPointsChangeClass() {
        return pointsChangeClass;
    }

    public void setPointsChangeClass(String pointsChangeClass) {
        this.pointsChangeClass = pointsChangeClass;
    }

    public String getPercentClass() {
        return percentClass;
    }

    public void setPercentClass(String percentClass) {
        this.percentClass = percentClass;
    }
}
