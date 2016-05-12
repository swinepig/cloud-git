package com.habuma.spitter.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

@Controller
@RequestMapping("/uploader")
public class UploaderController implements ServletConfigAware,ServletContextAware {
	private static final long serialVersionUID = 1L;
	private ServletConfig servletConfig;
	 private ServletContext servletContext;
//	String repositoryPath = "D:";
//	String uploadPath ="D:";
	String repositoryPath;
	String uploadPath ;
	@RequestMapping(value="/zx")
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(servletConfig);
		response.setCharacterEncoding("UTF-8");
		Integer schunk = null;//�ָ����
		Integer schunks = null;//�ָܷ���
		String name = null;//�ļ���
		BufferedOutputStream outputStream=null; 
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1024);
				factory.setRepository(new File(repositoryPath));//������ʱĿ¼
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");
				upload.setSizeMax(5 * 1024 * 1024);//���ø�����С
				List<FileItem> items = upload.parseRequest(request);
				//�������ļ���
				String newFileName = null;
				for (FileItem item : items) {
					if (!item.isFormField()) {// ������ļ�����
						name = item.getName();// ����ļ���
						newFileName = UUID.randomUUID().toString().replace("-","").concat(".").concat(FilenameUtils.getExtension(name));
						if (name != null) {
							String nFname = newFileName;
							if (schunk != null) {
								nFname = schunk + "_" + name;
							}
							File savedFile = new File(uploadPath, nFname);
							item.write(savedFile);
						}
					} else {
						//�ж��Ƿ���ָ���Ϣ
						if (item.getFieldName().equals("chunk")) {
							schunk = Integer.parseInt(item.getString());
						}
						if (item.getFieldName().equals("chunks")) {
							schunks = Integer.parseInt(item.getString());
						}
					}
				}
				
				if (schunk != null && schunk + 1 == schunks) {
					outputStream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath, newFileName)));
					//�����ļ��ϲ�
					for (int i = 0; i < schunks; i++) {
						File tempFile=new File(uploadPath,i+"_"+name);
						byte[] bytes=FileUtils.readFileToByteArray(tempFile);  
						outputStream.write(bytes);
						outputStream.flush();
						tempFile.delete();
					}
					outputStream.flush();
				}
				response.getWriter().write("{\"status\":true,\"newName\":\""+newFileName+"\"}");
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.getWriter().write("{\"status\":false}");
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"status\":false}");
			}finally{  
	            try {  
	            	if(outputStream!=null)
	            		outputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }   
		}
	}

	public void init(ServletConfig config) throws ServletException {
//		D:\apache-tomcat-7.0.62\temp
		
		
		repositoryPath = FileUtils.getTempDirectoryPath();
		uploadPath = config.getServletContext().getRealPath(config.getInitParameter("uploadPath"));
		File up = new File(uploadPath);
		if(!up.exists()){
			up.mkdir();
		}
	}

	@Override
	public void setServletConfig(ServletConfig arg0) {
		this.servletConfig=arg0;
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
		
	}
}
