package com.project.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView{

    public FileDownloadView(){
        // Content type ����. 
        setContentType("application/download; charset=utf-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, 
    		HttpServletRequest req, HttpServletResponse res) throws Exception {

        // TODO Auto-generated method stub
    	
        File file = (File) model.get("downloadFile");
        String fileName = (String) model.get("downloadName");
        
        if ( fileName == null )
        	fileName = file.getName();
        
        res.setContentType(getContentType());
        res.setContentLength((int) file.length());
        
        res.setHeader("Content-Disposition", "attachment; filename=\"" + 
                java.net.URLEncoder.encode(fileName, "utf-8") + "\";");
        
        res.setHeader("Content-Transfer-Encoding", "binary");

        OutputStream out = res.getOutputStream();

        FileInputStream fis = null;

        try {
        	
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
        	
            if(fis != null) {
            	
                try { 
                    fis.close(); 
                }catch (IOException e) {
                    e.printStackTrace();
                }
                
            } // end of if
            
        } // end of try ~ catch ~ finally
        
        out.flush();
        
    }
}