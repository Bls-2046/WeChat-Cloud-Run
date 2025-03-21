package com.github.wechatcloudrun.utils;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class Https {

    private static final RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }

    /**
     * 发送 GET 请求，返回 JSON 数据
     *
     * @param url    请求 URL
     * @param params 请求参数（可选）
     * @param headers 请求头（可选）
     * @return JSON 格式的响应数据
     */
    public static JSONObject get(String url, Map<String, String> params, HttpHeaders headers) {
        // 构建 URL 和查询参数
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        // 创建 HTTP 实体
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 发送 GET 请求
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        // 将响应体转换为 JSONObject
        return new JSONObject(response.getBody());
    }
}
