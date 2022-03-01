/**
 * Author:   claire
 * Date:    2022/3/1 - 3:44 下午
 * Description:
 * History:
 * <author>          <time>                   <version>          <desc>
 * claire          2022/3/1 - 3:44 下午          V1.0.0
 */
package com.example;

import com.example.domain.MsgId;
import com.example.utils.DefaultMsgIdUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * 功能简述 
 * 〈〉
 *
 * @author claire
 * @date 2022/3/1 - 3:44 下午
 * @since 1.0.0
 */
public class MsgIdTransTest {

    public static MsgId hex2MsgId(String hexStr) throws DecoderException {
        MsgId msgId = DefaultMsgIdUtil.bytes2MsgId(Hex.decodeHex(hexStr.toCharArray()));
        System.out.println(msgId);
        return msgId;
    }

    public static String msgId2Hex(String msg){
        MsgId msgId = new MsgId(msg);
        String str = Hex.encodeHexString(DefaultMsgIdUtil.msgId2Bytes(msgId));
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) throws DecoderException {
        hex2MsgId("11f2311d0b369ff1"); //0103283504190341440945
        msgId2Hex("0103283504190341440945");//11f2311d0b369ff1
    }

}
