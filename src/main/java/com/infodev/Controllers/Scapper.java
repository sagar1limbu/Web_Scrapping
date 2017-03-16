package com.infodev.Controllers;

import com.infodev.Pojo.Market;
import com.infodev.Pojo.SubIndi;
import com.infodev.Services.OhlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Scapper {

    @Autowired
    private OhlcService ohlcService;

    @RequestMapping(value = "/getTable")
    public @ResponseBody List<Market> getTable(){

        List<Market> mket =new ArrayList<Market>();
                String link = "http://www.nepalstock.com/";
                try{
                    URL url = new URL(link);
                    HttpURLConnection conn =(HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    OutputStream os = conn.getOutputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    while((line=reader.readLine())!=null){
                        builder.append(line+"\n");
                    }
                    String index="<td align=\"left\"><b>\n" +
                            "                (.*?) </b></td>";

                    String turnover = "<td align=\"right\"><b>\n" +
                            "                (.*?) </b></td>\n" +
                            "               <td align=\"right\" nowrap=\"\" class=\"(.*?)\" align=\"left\"> ";

                    String current="<td align=\"right\" nowrap=\"\" class=\"(.*?)\" align=\"left\"> \n" +
                            "                 (.*?)</td>";
                    String pointsChange="<td align=\"right\" nowrap=\"\" class=\"(.*?)\" align=\"left\"> \n" +
                            "                 (.*?) \n" +
                            "               </td>";
                    String pChange="<td align=\"right\" nowrap=\"\" class=\"(.*?)\" align=\"left\">\n" +
                            "                 (.*?)&nbsp;&nbsp;</td>";
                    Pattern pattern1 = Pattern.compile(turnover);
                    Matcher matcher1 = pattern1.matcher(builder.toString());

                    Pattern pattern2 = Pattern.compile(current);
                    Matcher matcher2 = pattern2.matcher(builder.toString());

                    Pattern pattern3 = Pattern.compile(pointsChange);
                    Matcher matcher3 = pattern3.matcher(builder.toString());

                    Pattern pattern4 = Pattern.compile(pChange);
                    Matcher matcher4 = pattern4.matcher(builder.toString());

                    Pattern pattern5 = Pattern.compile(index);
                    Matcher matcher5 = pattern5.matcher(builder.toString());

                    while(matcher1.find()&&matcher2.find()&&matcher3.find()&&matcher4.find() && matcher5.find()){
                        System.out.println(matcher1.group(1));
                        System.out.println(matcher2.group(2));
                        System.out.println(matcher3.group(2));
                        System.out.println(matcher4.group(2));
                        System.out.println(matcher5.group(1));

                        Market market = new Market();
                        market.setindex_name(matcher5.group(1));
                        market.setTurnover(matcher1.group(1));
                        market.setCurrent_value(matcher2.group(2));
                        market.setPointschange(matcher3.group(2));
                        market.setCurrentP(matcher4.group(2));

                        market.setCurrentClass(matcher2.group(1));
                        market.setPointsChangeClass(matcher3.group(1));
                        market.setPercentClass(matcher4.group(1));
                        mket.add(market);

                    }
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
                ohlcService.saveNepse(mket);
            return mket;
            }

    @RequestMapping(value = "/getSubIndices")
    public @ResponseBody List<SubIndi> getSubIndices(){
        String link = "http://www.nepalstock.com/";
        List<SubIndi> subIndis = new ArrayList<SubIndi>();

        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }


            String subIndices = "  <td align=\"left\"><b>\n" +
                    "                 (.*?) </b></td>\n" +
                    "                 <td class=\"alnright\"><b>\n" +
                    "                   (.*?) </b></td>";
            String turnover = "<td class=\"alnright\"><b>\n" +
                    "                   (.*?) </b></td>";

            String currentPointChange=" <td nowrap=\"\" class=\"(.*?) alnright\"> \n" +
                    "                 (.*?)   </td>\n" +
                    "               <td nowrap=\"\" class=\"(.*?)\"> \n" +
                    "                 (.*?)               </td>";

            String pointsChange=" <td nowrap=\"\" class=\"(.*?)\"> \n" +
                    "                 (.*?)   </td>\n" +
                    "               <td nowrap=\"\" class=\"(.*?) alnright\"> \n" +
                    "                 (.*?)               </td>";
            String percentChange ="<td nowrap=\"\" class=\"(.*?)t\"> \n" +
                    "                 (.*?)             </td>\n" +
                    "               <td nowrap=\"\" class=\"(.*?) alnright\">\n" +
                    "                 (.*?)&nbsp;&nbsp; </td>";


            Pattern pattern5 = Pattern.compile(turnover);
            Matcher matcher5 = pattern5.matcher(builder.toString());

            Pattern pattern6 = Pattern.compile(subIndices);
            Matcher matcher6 = pattern6.matcher(builder.toString());

            Pattern pattern7 = Pattern.compile(currentPointChange);
            Matcher matcher7 = pattern7.matcher(builder.toString());

            Pattern pattern8 = Pattern.compile(pointsChange);
            Matcher matcher8 = pattern8.matcher(builder.toString());

            Pattern pattern9 = Pattern.compile(percentChange);
            Matcher matcher9 = pattern9.matcher(builder.toString());

            while ( matcher5.find() && matcher6.find() && matcher7.find() && matcher8.find()  && matcher9.find()) {

                SubIndi subIndi = new SubIndi();
                subIndi.setSubIndices(matcher6.group(1));
                subIndi.setTurnover(matcher5.group(1));
                subIndi.setCurrent(matcher7.group(2));
                subIndi.setPointsChange(matcher8.group(4));
                subIndi.setpChange(matcher9.group(4));

                subIndi.setCurrentColor(matcher7.group(1));
                subIndi.setPointsColor(matcher8.group(3));
                subIndi.setPercentColor(matcher9.group(3));

                System.out.println(matcher6.group(1));
                System.out.println(matcher5.group(1));
                System.out.println(matcher7.group(2));
                System.out.println(matcher8.group(4));
                System.out.println(matcher9.group(4));

                subIndis.add(subIndi);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return subIndis;

    }

}
