package com.hb.spr.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
    private static final Logger log = Logger.getLogger(FileController.class);

    @RequestMapping("/uploadpage")
    public String uploadPage(){
        return "file/upload";
    }
    
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String upload(MultipartFile file){
        try {
            log.info(">>>>文件名称：" + file.getOriginalFilename());
            FileUtils.writeByteArrayToFile(new File("D:/tmp/"+file.getName()), file.getBytes());
            return "redirect:/success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
    
}
