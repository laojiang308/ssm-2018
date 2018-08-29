package com.jacky.foxi.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jacky.foxi.entity.Media;
import com.jacky.foxi.service.MediaService;

/**
 * 上传控制器
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController extends ApiController {
    @Resource
    MediaService mediaService;

    @RequestMapping(value = "/file", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String file(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/") + "upload";
        String fileName = getUUID() + "."
                + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
            String src = uploadOSS(fileName, path + "/" + fileName);
            Media media = new Media();
            media.setMedia_src(src);
            media.setMedia_status(0);
            media.setCreate_time(System.currentTimeMillis() / 1000);
            media.setDelete_time(0);
            mediaService.createMedia(media);
            Map map = new HashMap();
            map.put("media", media);
            return success(map);
        }
        return error("上传文件错误");
    }

    @RequestMapping(value = "/h5_upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String h5Upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/") + "upload";
        String fileName = getUUID() + "."
                + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, fileName));
            String src = uploadOSS(fileName, path + "/" + fileName);
            Media media = new Media();
            media.setMedia_src(src);
            media.setMedia_status(0);
            media.setCreate_time(System.currentTimeMillis() / 1000);
            media.setDelete_time(0);
            mediaService.createMedia(media);
            Map map = new HashMap();
            if(media.getMedia_src().isEmpty()){
                map.put("status", 0);
                map.put("msg", "上传失败");
            }else{
                map.put("status", 1);
                map.put("url", media.getMedia_src());
            }
            return new JSONObject(map).toString();
        }
        return error("上传文件错误");
    }
}