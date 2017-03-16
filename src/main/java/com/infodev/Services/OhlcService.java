package com.infodev.Services;

import com.infodev.Entity.Stock;
import com.infodev.Entity.StockPriceDetl;
import com.infodev.Pojo.Market;
import com.infodev.Pojo.OhlcRequest;

import java.util.Collection;
import java.util.List;

/**
 * Created by ranji on 2/16/2017.
 */
public interface OhlcService {
    Collection<StockPriceDetl> getOhlc(OhlcRequest ohlcRequest);
    List<Stock> getAllStock();

    void saveNepse(List<Market> markets);
}
