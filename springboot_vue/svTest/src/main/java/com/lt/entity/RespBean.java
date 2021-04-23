package com.lt.entity;

/**
 * @author lt
 * @date 2021/4/21 16:31
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

//    public static RespBean error(String msg, Object obj) {
//        return new RespBean(500, msg, obj);
//    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean ok(String 登陆成功, Object currentHr) {
        return null;
    }
}
