package com.lt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lt
 * @date 2021/4/19 16:17
 */

/**
 * 用来处理全局数据
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void uploadException(MaxUploadSizeExceededException e,
//                                HttpServletResponse rsp) throws IOException {
//        rsp.setContentType("text/html;charset==utf-8");
//        PrintWriter out = rsp.getWriter();
//        out.write("上传文件大小超出");
//        out.flush();
//        out.close();
//    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","文件大小超出");
        mv.setViewName("error");
        return mv;
    }
}
