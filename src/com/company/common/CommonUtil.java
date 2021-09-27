package com.company.common;

import com.company.model.CallSessionBean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  class CommonUtil {
    public  static Map<String, CallSessionBean> qNmap5=new ConcurrentHashMap<>();
    public  static Map<String, CallSessionBean> bDmap5=new ConcurrentHashMap<>();
}
