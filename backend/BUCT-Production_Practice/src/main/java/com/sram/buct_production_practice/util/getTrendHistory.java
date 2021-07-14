package com.sram.buct_production_practice.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.*;
import com.sram.buct_production_practice.entity.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class getTrendHistory {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse response;

    @Autowired
    TrendRealTimeDao trendRealTimeDao;

    @Autowired
    TrendValueDao trendValueDao;

    @Autowired
    TrendWaveValueDao trendWaveValueDao;

    @Autowired
    TrendSpectrumValueDao trendSpectrumValueDao;

    @Autowired
    PointDetailDao pointDetailDao;

    public void getTrendHistory(long trendTime){
        List<PointDetail> pointDetailList = pointDetailDao.selectAll();
        for (PointDetail pointDetail : pointDetailList) {
            String url="http://39.106.31.26:8289/trend/"+pointDetail.getEquipmentuuid()+"/"+pointDetail.getPointid()+"/real_time";
            System.out.println(url);
            JSONObject datas = getRequest(url);
            System.out.println(datas);
            Integer status = (Integer) datas.get("code");
            if (status==200) {

                JSONObject data = JSONObject.parseObject(datas.get("data").toString());
                TrendRealTime trendRealTime=new TrendRealTime();
                trendRealTime.setEquipmentuuid(data.get("equipmentName").toString());
                trendRealTime.setRev(Integer.valueOf(data.get("rev").toString()));
                trendRealTime.setPointname(String.valueOf(data.get("pointName")));
                trendRealTime.setTrendtime(trendTime);
                trendRealTime.setStartindex((Integer) data.get("startIndex"));
                trendRealTime.setEndindex((Integer) data.get("endIndex"));
                trendRealTime.setEquipmentuuid(pointDetail.getEquipmentuuid());
                trendRealTime.setPointidstring(pointDetail.getPointid());
//                System.out.println(trendRealTime);
                System.out.println(trendRealTimeDao.insert(trendRealTime));

                final List<TrendValue> trendValues = JSONObject.parseArray(data.get("trendValue").toString(), TrendValue.class);

                for (TrendValue trendValue : trendValues) {
                    trendValue.setEquipmentuuid(pointDetail.getEquipmentuuid());
                    trendValue.setPointidstring(pointDetail.getPointid());
                    trendValue.setTrendtime(trendTime);
//                    System.out.println(trendValue);
                    System.out.println(trendValueDao.insert(trendValue));
                }

                if(data.containsKey("waveValue")) {
                    final JSONObject waveValue = JSONObject.parseObject(data.get("waveValue").toString());
                    final JSONArray waveX = JSONObject.parseArray(waveValue.get("waveX").toString());
                    final JSONArray waveY = JSONObject.parseArray(waveValue.get("waveY").toString());
                    final JSONObject waveUnit = JSONObject.parseObject(waveValue.get("waveUnit").toString());
                    TrendWaveValue trendWaveValue = new TrendWaveValue();
                    trendWaveValue.setEquipmentuuid(pointDetail.getEquipmentuuid());
                    trendWaveValue.setPointidstring(pointDetail.getPointid());
                    trendWaveValue.setWavex(waveX.toString());
                    trendWaveValue.setWavey(waveY.toString());
                    trendWaveValue.setX(waveUnit.get("x").toString());
                    trendWaveValue.setY(waveUnit.get("y").toString());
                    trendWaveValue.setTrendtime(trendTime);
//                    System.out.println(trendWaveValue);
                    System.out.println(trendWaveValueDao.insert(trendWaveValue));
                }

                if(data.containsKey("spectrumValue")){
                    final JSONObject spectrumValue = JSONObject.parseObject(data.get("spectrumValue").toString());
                    final JSONArray spectrumX = JSONObject.parseArray(spectrumValue.get("spectrumX").toString());
                    final JSONArray spectrumY = JSONObject.parseArray(spectrumValue.get("spectrumY").toString());
                    final JSONObject spectrumUnit = JSONObject.parseObject(spectrumValue.get("spectrumUnit").toString());
                    TrendSpectrumValue trendSpectrumValue=new TrendSpectrumValue();
                    trendSpectrumValue.setEquipmentuuid(pointDetail.getEquipmentuuid());
                    trendSpectrumValue.setPointidstring(pointDetail.getPointid());
                    trendSpectrumValue.setSpectrumx(spectrumX.toString());
                    trendSpectrumValue.setSpectrumy(spectrumY.toString());
                    trendSpectrumValue.setX(spectrumUnit.get("x").toString());
                    trendSpectrumValue.setY(spectrumUnit.get("y").toString());
                    trendSpectrumValue.setTrendtime(trendTime);
//                    System.out.println(trendSpectrumValue);
                    System.out.println(trendSpectrumValueDao.insert(trendSpectrumValue));
                }

            }
        }
    }

    public JSONObject getRequest(String url){
        HttpGet httpGet = new HttpGet(url);

        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);//转换成字符串
            return JSONObject.parseObject(s);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
