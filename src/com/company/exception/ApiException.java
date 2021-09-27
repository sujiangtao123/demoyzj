package com.company.exception;

public class ApiException extends Exception {

    private int code;
    private final static int errorCode = -1;
    private final static int rightCode = 0;

    private  static String getMessage(int code) {
        switch (code) {
            case errorCode:
                return "调用错误";
            default:
                return null;
        }

    }

    public int getCode() {
        return code;
    }


    public ApiException(int code) {
        super(getMessage(code));
        this.code = code;
    }

}
