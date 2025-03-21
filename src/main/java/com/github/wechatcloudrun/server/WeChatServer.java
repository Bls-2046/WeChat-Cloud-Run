package com.github.wechatcloudrun.server;

import com.github.wechatcloudrun.dto.ScheduleRequest;
import com.github.wechatcloudrun.dto.ScheduleResponse;

public interface WeChatServer {
    ScheduleResponse.ReminderMessage sendReminderMessage(ScheduleRequest request);
}
