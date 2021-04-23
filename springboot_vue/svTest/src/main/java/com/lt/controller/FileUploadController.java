package com.lt.controller;

import com.lt.entity.Author;
import com.lt.entity.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lt
 * @date 2021/4/19 10:10
 */
@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){
        String path = req.getSession().getServletContext().getRealPath("/uploadFile/")
                ,formt = sdf.format(new Date());
        File folder = new File(path+formt);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename()
                ,newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try {
            uploadFile.transferTo(new File(folder,newName));
            String filePth = req.getScheme()+"://" + req.getServerName()+":"+req.getServerPort()+"/uploadFile/"+formt+newName;
            return filePth;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败！";
    }

    @PostMapping("/uploads")
    public String upload(MultipartFile[] files, HttpServletRequest req){
        for (MultipartFile uploadFile : files) {
            String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
            System.out.println(realPath);
            String format = sdf.format(new Date());
            File folder = new File(realPath + format);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                uploadFile.transferTo(new File(folder, newName));
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
                System.out.println(filePath);
                return filePath;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传失败!";
    }

//    @GetMapping("/hello")
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
//        Set<String> keySet = map.keySet();
//        Iterator<String> iterator = keySet.iterator();
//        while (iterator.hasNext()){
//            String key =  iterator.next();
//            Object value = map.get(key);
//            System.out.println(key+">>"+value);
//        }
        System.out.println(map);
        return "user";
    }

    @GetMapping("/book")
    @ResponseBody
    public String book(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){
        return book.toString() + ">>" + author.toString();
    }


}
