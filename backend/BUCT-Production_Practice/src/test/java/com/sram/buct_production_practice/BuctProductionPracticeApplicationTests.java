package com.sram.buct_production_practice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.controller.NodeInfoController;
import com.sram.buct_production_practice.dao.*;
import com.sram.buct_production_practice.entity.*;
import lombok.val;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class BuctProductionPracticeApplicationTests {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse response;

    @Autowired
    NodeInfoDao nodeInfoDao;

    @Autowired
    EquipmentInfoDao equipmentInfoDao;

    @Autowired
    PointDetailDao pointDetailDao;

    @Autowired
    GraphInfoDao graphInfoDao;

    @Autowired
    GraphDataListboxesDao graphDataListboxesDao;

    @Autowired
    GraphDataEquipmentnameDao graphDataEquipmentnameDao;

    @Autowired
    GraphDataRevinfoDao graphDataRevinfoDao;

    @Autowired
    GraphDataTimeDao graphDataTimeDao;

    @Autowired
    ListBoxesPointsDao listBoxesPointsDao;

    @Test
    public void getNodeInfo() {
        JSONObject datas = getRequest("http://39.106.31.26:8289/node/info");
        if (datas==null) return;
        Integer status = (Integer) datas.get("code");//获取返回数据状态，get获取的字段需要根据提供的返回值去获取
        if (status == 200) {//返回的状态
            List<NodeInfo> nodeInfoList = JSONObject.parseArray(datas.get("data").toString(), NodeInfo.class);
            System.out.println(nodeInfoList);
            for (NodeInfo nodeInfo : nodeInfoList) {
                System.out.println(nodeInfoDao.insert(nodeInfo));
            }
        }
    }

    @Test
    public void getEquipmentInfo(){
        List<NodeInfo> nodeInfoList = nodeInfoDao.selectAll();
        for (NodeInfo nodeInfo : nodeInfoList) {
            String url="http://39.106.31.26:8289//equipment/node/"+nodeInfo.getNodeid()+"/info";
            JSONObject datas = getRequest(url);
            Integer status = (Integer) datas.get("code");
            if (status==200){
                List<EquipmentInfo> equipmentInfoList=JSONObject.parseArray(datas.get("data").toString(), EquipmentInfo.class);
                System.out.println(equipmentInfoList);
                for (EquipmentInfo equipmentInfo : equipmentInfoList) {
                    System.out.println(equipmentInfoDao.insert(equipmentInfo));
                }
            }
        }
        System.out.println(nodeInfoList);
    }

    @Test
    public void getPointDetail(){
        List<EquipmentInfo> equipmentInfoList = equipmentInfoDao.selectAll();
        for (EquipmentInfo equipmentInfo : equipmentInfoList) {
            String url="http://39.106.31.26:8289//point/"+equipmentInfo.getEquipmentuuid()+"/detail";
            JSONObject datas = getRequest(url);
            Integer status = (Integer) datas.get("code");
            if (status==200) {
                List<PointDetail> pointDetailList = JSONObject.parseArray(datas.get("data").toString(), PointDetail.class);
                System.out.println(pointDetailList);
                for (PointDetail pointDetail : pointDetailList) {
                    System.out.println(pointDetailDao.insert(pointDetail));
                }
            }
        }
    }

    @Test
    public void getTrendRealTime(){
        List<PointDetail> pointDetailList = pointDetailDao.selectAll();
        for (PointDetail pointDetail : pointDetailList) {
            String url="http://39.106.31.26:8289/trend/"+pointDetail.getEquipmentuuid()+"/"+pointDetail.getPointid()+"/real_time";
            System.out.println(url);
            JSONObject datas = getRequest(url);
            System.out.println(datas);
            Integer status = (Integer) datas.get("code");
            if (status==200) {
//                List<TrendRealTime> data = JSONObject.parseArray(datas.get("data").toString(), TrendRealTime.class);
//                System.out.println(data);
            }
        }
    }

    @Test
    public void getGraphInfo(){
        final List<EquipmentInfo> equipmentInfoList = equipmentInfoDao.selectAll();
        for (EquipmentInfo equipmentInfo : equipmentInfoList) {
            String url="http://39.106.31.26:8289/graph/"+equipmentInfo.getEquipmentuuid()+"/info";
            System.out.println(url);
            JSONObject datas = getRequest(url);
            Integer status = (Integer) datas.get("code");
            System.out.println(datas);
            if (status == 200) {
                GraphInfo data = JSONObject.parseObject(datas.get("data").toString(), GraphInfo.class);
                data.setEquipmentuuid(equipmentInfo.getEquipmentuuid());
                graphInfoDao.insert(data);
            }
        }
    }

    @Test
    public void getGraphData(){
        final List<EquipmentInfo> equipmentInfoList = equipmentInfoDao.selectAll();
        for (EquipmentInfo equipmentInfo : equipmentInfoList) {
            String url="http://39.106.31.26:8289/graph/"+equipmentInfo.getEquipmentuuid()+"/data";
//            System.out.println(url);
            JSONObject datas = getRequest(url);
            Integer status = (Integer) datas.get("code");
            System.out.println(datas);
            if (status == 200) {
                JSONObject data = (JSONObject) datas.get("data");
                String equipmentUUID = data.getString("equipmentUuid");

                GraphDataEquipmentname graphDataEquipmentname = data.getObject("equipmentName",GraphDataEquipmentname.class);
                graphDataEquipmentname.setEquipmentuuid(equipmentUUID);

                graphDataEquipmentnameDao.insert(graphDataEquipmentname);


                GraphDataTime graphDataTime = data.getObject("time",GraphDataTime.class);
                graphDataTime.setEquipmentuuid(equipmentUUID);

                graphDataTimeDao.insert(graphDataTime);

                JSONObject property = data.getJSONObject("revInfo");
                for (String s : property.keySet()) {
                    GraphDataRevinfo graphDataRevinfo = property.getObject(s,GraphDataRevinfo.class);
                    graphDataRevinfo.setEquipmentuuid(equipmentUUID);
                    graphDataRevinfo.setProperty(s);
                    graphDataRevinfoDao.insert(graphDataRevinfo);
                }





                JSONArray listBoxes = data.getJSONArray("listBoxes");
                for (Object listBox : listBoxes) {
                    JSONObject listo = (JSONObject) listBox;
                    GraphDataListboxes graphDataListboxes = new GraphDataListboxes(
                                equipmentUUID,
                                listo.getString("yPos"),
                                listo.getString("width"),
                                listo.getString("xPos"),
                                listo.getString("height")
                            );
                    graphDataListboxesDao.insert(graphDataListboxes);

                    JSONArray points = listo.getJSONArray("points");
                    for (Object o : points) {
                        JSONObject obj = (JSONObject) o;
                        ListBoxesPoints listBoxesPoints = new ListBoxesPoints(
                                0,
                                obj.getString("pointId"),
                                obj.getString("pointUuid"),
                                obj.getString("value"),
                                obj.getString("status"),
                                graphDataListboxes.hashCodeSB(),
                                equipmentUUID
                        );
                        listBoxesPointsDao.insert(listBoxesPoints);
                    }

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
