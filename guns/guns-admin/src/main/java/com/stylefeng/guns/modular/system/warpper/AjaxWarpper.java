package com.stylefeng.guns.modular.system.warpper;

import java.io.Serializable;

public class AjaxWarpper implements Serializable {

    private static final long serialVersionUID = 7977410648145735213L;

    //返回结果状态 1：成功；0：失败
    private int status;

    //错误信息
    private String errMsg;

    //可封装数据
    private Object data;

    //成功
    public static final int SUCCESS = 1;

    //失败
    public static final int FAILE = 0;

    //构造方法
    public AjaxWarpper() {
    }

    //构造方法
    public AjaxWarpper(int result) {
        this.status = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int result) {
        this.status = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
