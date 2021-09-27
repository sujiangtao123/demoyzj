package com.company.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
public class CallSessionBean implements Serializable {
    private String callCenterSessionId;
    private String seatNo;
    private String startTime;
    private String endTime;
    private String customerNumber;
    private String talkDuration;

    private String  callSessionId;

    private String agencyId;

    public String getCallCenterSessionId() {
        return callCenterSessionId;
    }

    public void setCallCenterSessionId(String callCenterSessionId) {
        this.callCenterSessionId = callCenterSessionId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getTalkDuration() {
        return talkDuration;
    }

    public void setTalkDuration(String talkDuration) {
        this.talkDuration = talkDuration;
    }

    public String getCallSessionId() {
        return callSessionId;
    }

    public void setCallSessionId(String callSessionId) {
        this.callSessionId = callSessionId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallSessionBean that = (CallSessionBean) o;
//        if(!endTime.equals(that.endTime)){
//            Long date = getDate(that.endTime, endTime);
//            if(1 == date){
//                that.endTime=endTime;
//            }
//        }
//        if(!talkDuration .equals(that.talkDuration)) {
//            if (1 == talkDuration(that.talkDuration, talkDuration)) {
//                that.talkDuration = talkDuration;
//            }
//        }
        if(!customerNumber.equals(that.customerNumber)){
            if(customerNumber.charAt(0)=='0'){
                String substring = customerNumber.substring(1);
                customerNumber=substring;
            }
            if(that.customerNumber.charAt(0)=='0'){
                String substring1 = that.customerNumber.substring(1);
                that.customerNumber=substring1;
            }
        }
        return Objects.equals(callCenterSessionId, that.callCenterSessionId) &&
                Objects.equals(seatNo, that.seatNo) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(customerNumber, that.customerNumber) &&
                Objects.equals(talkDuration, that.talkDuration) &&
                Objects.equals(callSessionId, that.callSessionId) &&
                Objects.equals(agencyId, that.agencyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callCenterSessionId, seatNo,startTime, endTime, customerNumber, talkDuration, callSessionId, agencyId);
    }

    @Override
    public String toString() {
//        return
//                "'" + callCenterSessionId + '\'' +
//                ", '" + seatNo + '\'' +
//                ", '" + startTime + '\'' +
//                ", '" + endTime + '\'' +
//                ", '" + customerNumber + '\'' +
//                ", '" + talkDuration + '\'' +
//                ", '" + callSessionId + '\'' +
//                ", '" + agencyId + '\'';
        return callCenterSessionId+" ,"+seatNo+" ,"+startTime+" ," +endTime+" ,"+customerNumber+" ,"+talkDuration+" ,"+callSessionId+" ,"+agencyId;
    }
    public static Long getDate(String endstartBd, String endstartQn){
        LocalDateTime parse = LocalDateTime.parse(endstartBd, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse1 = LocalDateTime.parse(endstartQn,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Instant instant = parse.toInstant(ZoneOffset.of("+8"));
        Instant instant1 = parse1.toInstant(ZoneOffset.of("+8"));
        return  Math.abs(Duration.between(instant,instant1).toMillis());
    }

    public static Long talkDuration(String talkDurationBd, String talkDurationQn){
        return Math.abs((Long.parseLong(talkDurationBd)-Long.parseLong(talkDurationQn)));
    }
}
