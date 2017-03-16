package com.infodev.Controllers;

import com.infodev.Entity.Stock;
import com.infodev.Entity.StockPriceDetl;
import com.infodev.Pojo.GlobalResponse;
import com.infodev.Pojo.OhlcRequest;
import com.infodev.Services.OhlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class DefaultController {

    @Autowired
    OhlcService ohlcService;


    //TO MAKE DEFAULT RESPOND
    private GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(
                status,
                message,
                data
        );
    }
    @CrossOrigin
    @RequestMapping(value = "/ohlc", method = RequestMethod.POST)
    public GlobalResponse getOhlc(@RequestBody OhlcRequest ohlcRequest) {
        Collection<StockPriceDetl> spd = ohlcService.getOhlc(ohlcRequest);
        List<Map<String, Object>> ohlcList = new ArrayList<Map<String, Object>>();
        //LinkedHashMap<String, BigDecimal> hm = new LinkedHashMap<String, BigDecimal>();
        if (spd != null) {
            for (StockPriceDetl spData : spd) {
                Map<String, Object> ohlcMap = new LinkedHashMap<String, Object>();
            ohlcMap.put("open", spData.getPreviousClosingPrice());
            ohlcMap.put("high", spData.getMaxPrice());
            ohlcMap.put("low", spData.getMinPrice());
            ohlcMap.put("close", spData.getClosingPrice());
            ohlcMap.put("date",spData.getMastByStockId().getTranDate());
            ohlcMap.put("volume",spData.getAmount());
            ohlcList.add(ohlcMap);
                System.out.println(ohlcList.size());
        }
    }
        return respond("success","successfully loaded",ohlcList);
    }
    @CrossOrigin
    @RequestMapping(value = "/symbol", method = RequestMethod.GET)
    public GlobalResponse getStockName() {
        Collection<Stock> sk = ohlcService.getAllStock();
        List<Map<String, String>> stockList = new ArrayList<Map<String, String>>();
        if (sk != null) {
            for (Stock sData : sk) {

                // Create Object
                Map<String, String> stockMap = new LinkedHashMap<String, String>();
                stockMap.put("stockName", sData.getStockName());
                stockMap.put("stockSymbol", sData.getStockSymbol());
                // Add to stock list
                stockList.add(stockMap);
            }
        }
        return respond("success", "successfully loaded", stockList);

    }

}
