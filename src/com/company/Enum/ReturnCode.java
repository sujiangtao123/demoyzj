package com.company.Enum;

public enum ReturnCode {

    OK(0, "success"),

    LEAD_ADD_SUCCESS(1000, "线索增补成功");

    private int retCode;

    private String msg;

    ReturnCode(int retCode, String msg) {
        this.retCode = retCode;
        this.msg = msg;
    }

    public int code() {
        return this.retCode;
    }

    public String msg() {
        return this.msg;
    }

    public static ReturnCode parseCode(int retCode) {
        ReturnCode[] values = ReturnCode.values();
        for (ReturnCode apiRetCode : ReturnCode.values()) {
            if (apiRetCode.retCode == retCode) {
                return apiRetCode;
            }
        }
        return null;
    }
}
