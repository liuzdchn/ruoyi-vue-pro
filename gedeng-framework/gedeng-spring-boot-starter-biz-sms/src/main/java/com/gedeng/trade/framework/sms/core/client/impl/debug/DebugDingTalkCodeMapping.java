package com.gedeng.trade.framework.sms.core.client.impl.debug;

import com.gedeng.trade.framework.common.exception.ErrorCode;
import com.gedeng.trade.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.gedeng.trade.framework.sms.core.client.SmsCodeMapping;
import com.gedeng.trade.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author 芋道源码
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
