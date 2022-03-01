/**
 * Author:   claire
 * Date:    2022/3/1 - 3:45 下午
 * Description: 消息对象
 * History:
 * <author>          <time>                   <version>          <desc>
 * claire          2022/3/1 - 3:45 下午          V1.0.0          消息对象
 */
package com.example.domain;

import java.io.Serializable;
import java.lang.management.ManagementFactory;

/**
 * 功能简述 
 * 〈消息对象〉
 *
 * @author claire
 * @date 2022/3/1 - 3:45 下午
 * @since 1.0.0
 */
public class MsgId implements Serializable {
    private static final long serialVersionUID = 945466149547731811L;
    private static int ProcessID = 1010;
    private int month;
    private int day;
    private int hour;
    private int minutes;
    private int seconds;
    private int gateId;
    private int sequenceId;

    public MsgId(){

    }
    public MsgId(String msgIds) {
        this.setMonth(Integer.parseInt(msgIds.substring(0, 2)));
        this.setDay(Integer.parseInt(msgIds.substring(2, 4)));
        this.setHour(Integer.parseInt(msgIds.substring(4, 6)));
        this.setMinutes(Integer.parseInt(msgIds.substring(6, 8)));
        this.setSeconds(Integer.parseInt(msgIds.substring(8, 10)));
        this.setGateId(Integer.parseInt(msgIds.substring(10, 17)));
        this.setSequenceId(Integer.parseInt(msgIds.substring(17, 22)));
    }

    public MsgId(long timeMillis, int gateId, int sequenceId) {
        this.setMonth(Integer.parseInt(String.format("%tm", timeMillis)));
        this.setDay(Integer.parseInt(String.format("%td", timeMillis)));
        this.setHour(Integer.parseInt(String.format("%tH", timeMillis)));
        this.setMinutes(Integer.parseInt(String.format("%tM", timeMillis)));
        this.setSeconds(Integer.parseInt(String.format("%tS", timeMillis)));
        this.setGateId(gateId);
        this.setSequenceId(sequenceId);
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getGateId() {
        return this.gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getSequenceId() {
        return this.sequenceId & '\uffff';
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId & '\uffff';
    }

    @Override
    public String toString() {
        return String.format("%1$02d%2$02d%3$02d%4$02d%5$02d%6$07d%7$05d", this.month, this.day, this.hour, this.minutes, this.seconds, this.gateId, this.sequenceId);
    }

    @Override
    public int hashCode() {
        boolean prime = true;
        int result = 1;
        result = 31 * result + this.day;
        result = 31 * result + this.gateId;
        result = 31 * result + this.hour;
        result = 31 * result + this.minutes;
        result = 31 * result + this.month;
        result = 31 * result + this.seconds;
        result = 31 * result + this.sequenceId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            MsgId other = (MsgId)obj;
            if (this.day != other.day) {
                return false;
            } else if (this.gateId != other.gateId) {
                return false;
            } else if (this.hour != other.hour) {
                return false;
            } else if (this.minutes != other.minutes) {
                return false;
            } else if (this.month != other.month) {
                return false;
            } else if (this.seconds != other.seconds) {
                return false;
            } else {
                return this.sequenceId == other.sequenceId;
            }
        }
    }

    static {
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        if (vmName.contains("@")) {
            try {
                ProcessID = Integer.valueOf(vmName.split("@")[0]);
            } catch (Exception var2) {
            }
        }

    }
}
