package com.sucl.springbootfileupload.web;

import org.apache.catalina.core.ApplicationPart;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * @author sucl
 * @since 2019/6/19
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private ApplicationContext context;

    /**
     *  MultipartHttpServletRequest
     *  MultipartFile
     *
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public Object upload(MultipartHttpServletRequest request){

//        saveFileInPart(request);
        return "success";
    }

    private void saveFileInPart(MultipartHttpServletRequest request){
        try {
            File path = new File("upload");
            FileUtils.forceMkdirParent(path);
            Collection<Part> parts = request.getParts();
            if(parts!=null && parts.size()>0){
                for(Part part : parts){
                    InputStream in = part.getInputStream();
                    String extension = StringUtils.getFilenameExtension(part.getSubmittedFileName());
                    File file = new File(path, UUID.randomUUID().toString() + "." + extension);
                    if(in!=null){
                        FileUtils.copyInputStreamToFile(in,file);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void saveFileInMultipart(MultipartHttpServletRequest request){
        try {
            request.getParameterMap();
            Map<String, MultipartFile> files = request.getFileMap();
            File path = new File("upload");
            FileUtils.forceMkdirParent(path);
            if(files!=null && files.size()>0){
                for(Map.Entry<String,MultipartFile> entry : files.entrySet()){
                    File file = new File(path, UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(entry.getKey()));
                    entry.getValue().transferTo(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
