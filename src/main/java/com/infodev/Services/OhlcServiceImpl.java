package com.infodev.Services;

import com.infodev.Entity.Stock;
import com.infodev.Entity.StockPriceDetl;
import com.infodev.Pojo.Market;
import com.infodev.Pojo.OhlcRequest;
import com.infodev.Repository.OhlcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by ranji on 2/16/2017.
 */
@Service
@Transactional
public class OhlcServiceImpl implements OhlcService {

    @Autowired
    OhlcDao ohlcDao;

   //OHLC Service
    public Collection<StockPriceDetl> getOhlc(OhlcRequest ohlcRequest) {
        return ohlcDao.getOhlc(ohlcRequest);
    }



    public List<Stock> getAllStock() {
        return ohlcDao.getAllStock();
    }
    public  void saveNepse(List<Market> markets){
        ohlcDao.saveNepse(markets);
    }
}
