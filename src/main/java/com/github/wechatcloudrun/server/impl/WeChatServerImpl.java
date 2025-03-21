package com.github.wechatcloudrun.server.impl;

import com.github.wechatcloudrun.WeChatCloudRunApplication;
import com.github.wechatcloudrun.dto.ScheduleRequest;
import com.github.wechatcloudrun.dto.ScheduleResponse;
import com.github.wechatcloudrun.server.WeChatServer;
import com.github.wechatcloudrun.utils.Https;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeChatServerImpl implements WeChatServer {

    private static String ACCESE_TOKEN;

    @Override
    public ScheduleResponse.ReminderMessage sendReminderMessage(ScheduleRequest request) {


        return null;
    }

    @Scheduled(fixedRate = 5000000)
    private static void getAccessToken() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", System.getenv("WECHAT_APPID"));
        params.put("secret", System.getenv("WECHAT_SECRET"));

        JSONObject response = Https.get("https://api.weixin.qq.com/cgi-bin/token", params, null);

        String access_token = response.getString("access_token");

        if (access_token == null) {
            throw new Exception("获取数据失败");
        }

        WeChatServerImpl.ACCESE_TOKEN = access_token;
    }
}
