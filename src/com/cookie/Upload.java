package com.cookie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "Upload",urlPatterns = "/Upload")
public class Upload extends HttpServlet {

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(-1);
        // 判断提交表单的类型是否为multipart/form-data
//        if (!upload.isMultipartContent(request)) {
//
//            return;
//        }

        List list;
        try {
            list = upload.parseRequest(request);
            Iterator it = list.iterator();

            while (it.hasNext()) {
                FileItem item = (FileItem) it.next();// 每一个item就代表一个表单输出项

                if (item.isFormField()) {// 判断input是否为普通表单输入项

                    String name = item.getFieldName();// input的名称

                    String value = item.getString();// input的值
                } else {// 判断input是否为文件表单输入项

                    // 得到上传文件的名称,并截取
                    String filename = item.getName();
                    int index = filename.lastIndexOf(File.separator);
                    if(index >0){
                        filename = filename.substring(index+1,filename.length());
                    }
                    // 得到上传文件要写入的目录
                    String filedir = this.getServletContext().getRealPath("/upload");
                    // 根据目录和文件创建输出流
                    //filename = path + "\";
                    StringBuffer path = new StringBuffer();
                    path.append(filedir);
                    path.append("\\");
                    path.append(filename);
                    FileOutputStream out = new FileOutputStream(path.toString());

                    InputStream in = item.getInputStream();
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }

                    in.close();
                    out.close();
                }
            }

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }


    public void init() throws ServletException {
        // Put your code here
    }

}
