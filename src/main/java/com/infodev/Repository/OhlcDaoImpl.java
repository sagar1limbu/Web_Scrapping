package com.infodev.Repository;

import com.infodev.Entity.Stock;
import com.infodev.Entity.StockPriceDetl;
import com.infodev.Pojo.Market;
import com.infodev.Pojo.OhlcRequest;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by ranji on 2/16/2017.
 */
@Repository
public class OhlcDaoImpl implements OhlcDao {

    @Autowired
    SessionFactory sessionFactory;
    Session session;

    Transaction trans;

   /* public Collection<StockPriceDetl> getOhlc(OhlcRequest ohlcRequest) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria c1=session.createCriteria(StockPriceDetl.class,ohlc);
        Criteria c2=session.createCriteria(Stock.class,"sName");
        c1.setProjection(Projections.projectionList()
                        .add(Projections.property("maxPrice"))
        .add(Projections.property("minPrice"))
        .add(Projections.property("closingPrice"))
        .add(Projections.property("previousClosingPrice"))
        .add(Restrictions.and(Property.forName()))
        );
        return null;
    }*/
    //Transaction transaction;


    public Collection<StockPriceDetl> getOhlc(OhlcRequest ohlcRequest) {
        //sessionFactory.openSession();
        session = sessionFactory.openSession();
//        Query query = session.createQuery("FROM StockPriceDetl spd WHERE spd.=:sSymbol");
        Query query = session.createQuery("FROM StockPriceDetl spd WHERE stockByStockId.stockSymbol=:sSymbol AND mastByStockId.tranDate BETWEEN :fromDate AND :toDate order by mastByStockId.tranDate");
        query.setParameter("sSymbol", ohlcRequest.getsSymbol());
        query.setParameter("fromDate",ohlcRequest.getFromDate());
        query.setParameter("toDate",ohlcRequest.getToDate());
        System.out.println(query + " " + ohlcRequest.getsSymbol());
        System.out.println(ohlcRequest.getFromDate()+ " " +ohlcRequest.getToDate());
        List<StockPriceDetl> list = query.list();
        session.close();
        return list;
    }

    public List<Stock> getAllStock() {
        List<Stock> stockList;
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Stock");
        stockList = query.list();
        session.close();
        return stockList;

    }

    public void saveNepse(List<Market> markets){
        session=sessionFactory.openSession();
        for(Market market : markets) {
            trans=session.beginTransaction();
            session.save(market);
            trans.commit();
        }

        session.close();
    }

}
