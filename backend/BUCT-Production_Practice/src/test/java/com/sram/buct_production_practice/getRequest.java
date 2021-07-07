package com.sram.buct_production_practice;

import com.alibaba.fastjson.JSONObject;
import com.sram.buct_production_practice.dao.NodeInfoDao;
import com.sram.buct_production_practice.entity.NodeInfo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class getRequest {

    @Autowired
    NodeInfoDao nodeInfoDao;
    @Test
    public void getNodeInfo() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://39.106.31.26:8289/node/info");
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);//转换成字符串
            JSONObject datas = JSONObject.parseObject(s);//转换成JSON格式
            Integer status = (Integer) datas.get("code");//获取返回数据状态，get获取的字段需要根据提供的返回值去获取
            System.out.println(datas);
            System.out.println(status);
            if (status == 200) {//返回的状态
                List<NodeInfo> nodeInfoList = JSONObject.parseArray(datas.get("data").toString(), NodeInfo.class);
                System.out.println(nodeInfoList);
                for (NodeInfo nodeInfo : nodeInfoList) {
                    System.out.println(nodeInfoDao.insert(nodeInfo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}