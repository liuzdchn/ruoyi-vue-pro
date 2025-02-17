package com.gedeng.trade.adminserver.modules.system.service.sms;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.gedeng.trade.adminserver.BaseDbAndRedisIntegrationTest;
import com.gedeng.trade.adminserver.modules.system.mq.consumer.sms.SysSmsSendConsumer;
import com.gedeng.trade.adminserver.modules.system.mq.producer.sms.SysSmsProducer;
import com.gedeng.trade.adminserver.modules.system.service.sms.impl.SysSmsChannelServiceImpl;
import com.gedeng.trade.adminserver.modules.system.service.sms.impl.SysSmsLogServiceImpl;
import com.gedeng.trade.adminserver.modules.system.service.sms.impl.SysSmsServiceImpl;
import com.gedeng.trade.adminserver.modules.system.service.sms.impl.SysSmsTemplateServiceImpl;
import com.gedeng.trade.adminserver.modules.system.service.user.SysUserService;
import com.gedeng.trade.framework.common.enums.UserTypeEnum;
import com.gedeng.trade.framework.sms.config.YudaoSmsAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Import({YudaoSmsAutoConfiguration.class,
        SysSmsChannelServiceImpl.class, SysSmsServiceImpl.class, SysSmsTemplateServiceImpl.class, SysSmsLogServiceImpl.class,
        SysSmsProducer.class, SysSmsSendConsumer.class})
public class SysSmsServiceIntegrationTest extends BaseDbAndRedisIntegrationTest {

    @Resource
    private SysSmsServiceImpl smsService;
    @Resource
    private SysSmsChannelServiceImpl smsChannelService;

    @MockBean
    private SysUserService userService;

    @Test
    public void testSendSingleSms_yunpianSuccess() {
        // 参数准备
        String mobile = "15601691399";
        Long userId = 1L;
        Integer userType = UserTypeEnum.ADMIN.getValue();
        String templateCode = "test_01";
        Map<String, Object> templateParams = MapUtil.<String, Object>builder()
                .put("operation", "登陆").put("code", "1234").build();
        // 调用
        smsService.sendSingleSms(mobile, userId, userType, templateCode, templateParams);

        // 等待 MQ 消费
        ThreadUtil.sleep(1, TimeUnit.HOURS);
    }

    @Test
    public void testSendSingleSms_aliyunSuccess() {
        // 参数准备
        String mobile = "15601691399";
        Long userId = 1L;
        Integer userType = UserTypeEnum.ADMIN.getValue();
        String templateCode = "test_02";
        Map<String, Object> templateParams = MapUtil.<String, Object>builder()
                .put("code", "1234").build();
        // 调用
        smsService.sendSingleSms(mobile, userId, userType, templateCode, templateParams);

        // 等待 MQ 消费
        ThreadUtil.sleep(1, TimeUnit.HOURS);
    }

//    @Test
//    public void testDoSendSms() {
//        // 等待 MQ 消费
//        ThreadUtil.sleep(1, TimeUnit.HOURS);
//    }

}
