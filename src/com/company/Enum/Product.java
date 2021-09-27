package com.company.Enum;

public enum  Product {
    TO_LOCK_FLOW("待锁定"),
    LOCK_FLOW_FAIL("排期失败"),
    LOCK_FLOW_ING("等待排期结果"),
    ADSTATUS_PENDING("审核中"),
    ADSTATUS_DENIED("未通过"),
    ADSTATUS_READY("待投放"),
    ADSTATUS_NORMAL("投放中"),
    ADSTATUS_SUSPEND("暂停投放"),
    ADSTATUS_FINISH("投放结束"),
    ADSTATUS_CANCEL("取消投放"),
    COOPERATION_PENDING("合作确认中"),
    COOPERATION_NOT_OK("合作未达成"),
    ADSTATUS_UNKNOWN("异常状态"),
    HOST_ARTICLE_PREPARING("文章编辑中"),
    HOST_ARTICLE_PENDING("文章待确认"),
    ADSTATUS_CREATING("创建中"),
    LOCK_FLOW_SUC("公众号底部的锁定排期"),
    ADSTATUS_PAID_SUC("已支付"),
    ADSTATUS_SYSTEM_SUSPEND("系统暂停"),
    ADSTATUS_REFUND("已失效");

    private String message;

    Product(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public static String parseCode(String retCode) {
        Product[] values = Product.values();
        for (Product apiRetCode : Product.values()) {
            if (apiRetCode.name().equals(retCode)) {
                return apiRetCode.getMessage();
            }
        }
        return null;
    }
}
