package com.github.wechatcloudrun.config;

import com.github.wechatcloudrun.server.impl.WeChatServerImpl;
import org.springframework.context.annotation.Bean;

public class PluginsConfig {
    public PluginsConfig() throws Exception {
        WeChatServerImpl.getAccessToken();
    }

    @Bean
    public PluginsConfig initApplication() throws Exception {
        return new PluginsConfig();
    }
}
