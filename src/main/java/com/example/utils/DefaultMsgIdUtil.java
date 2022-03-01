/**
 * Author:   claire
 * Date:    2022/3/1 - 3:48 下午
 * Description: msgid帮助类
 * History:
 * <author>          <time>                   <version>          <desc>
 * claire          2022/3/1 - 3:48 下午          V1.0.0          msgid帮助类
 */
package com.example.utils;

import com.example.domain.MsgId;

import java.nio.ByteBuffer;

/**
 * 功能简述 
 * 〈msgid帮助类〉
 *
 * @author claire
 * @date 2022/3/1 - 3:48 下午
 * @since 1.0.0
 */
public class DefaultMsgIdUtil {
//    MSGID(CmppDataType.UNSIGNEDINT, true, 8);

    public DefaultMsgIdUtil() {
    }

    public static byte[] msgId2Bytes(MsgId msgId) {
        byte[] bytes = new byte[8];
        long result = 0L;
        if (msgId != null) {
            result |= (long)msgId.getMonth() << 60;
            result |= (long)msgId.getDay() << 55;
            result |= (long)msgId.getHour() << 50;
            result |= (long)msgId.getMinutes() << 44;
            result |= (long)msgId.getSeconds() << 38;
            result |= (long)msgId.getGateId() << 16;
            result |= (long)msgId.getSequenceId() & 65535L;
        }

        ByteBuffer.wrap(bytes).putLong(result);
        return bytes;
    }

    public static MsgId bytes2MsgId(byte[] bytes) {
        long result = ByteBuffer.wrap(bytes).getLong();
        MsgId msgId = new MsgId();
        msgId.setMonth((int)(result >>> 60 & 15L));
        msgId.setDay((int)(result >>> 55 & 31L));
        msgId.setHour((int)(result >>> 50 & 31L));
        msgId.setMinutes((int)(result >>> 44 & 63L));
        msgId.setSeconds((int)(result >>> 38 & 63L));
        msgId.setGateId((int)(result >>> 16 & 4194303L));
        msgId.setSequenceId((int)(result & 65535L));
        return msgId;
    }
}
