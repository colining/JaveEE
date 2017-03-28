package com.cookie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "download",urlPatterns = "/download")
public class Download extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filename = request.getParameter("filename");
		// 得到上传文件要写入的目录
		String filedir = this.getServletContext().getRealPath("/upload");
		String filePath = filedir + "\\" + filename;
        /*读取文件*/
		File file = new File(filePath);
        /*如果文件存在*/
		if (file.exists()) {
//            String filename = URLEncoder.encode(file.getName(), enc);
//            response.reset();
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			int fileLength = (int) file.length();
			response.setContentLength(fileLength);
            /*如果文件长度大于0*/
			if (fileLength != 0) {
                /*创建输入流*/
				InputStream inStream = new FileInputStream(file);
				byte[] buf = new byte[4096];
                /*创建输出流*/
				ServletOutputStream servletOS = response.getOutputStream();
				int readLength;
				while (((readLength = inStream.read(buf)) != -1)) {
					servletOS.write(buf, 0, readLength);
				}
				inStream.close();
				servletOS.flush();
				servletOS.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}
