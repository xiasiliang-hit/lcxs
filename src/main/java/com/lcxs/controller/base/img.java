package com.lcxs.controller.base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
@RequestMapping("/img")
public class img {
	/*
     * 图片命名格式
     */
    private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyyMMddHHmmss";

    @RequestMapping("/addImg")
    public void addTopImg(HttpServletResponse response,@RequestParam("myfile") CommonsMultipartFile myfile,HttpServletRequest request) {
		response.setHeader("Content-type","text/html;charset=UTF-8");  
		PrintWriter pw = null;	
		String json="";
			try {
				pw=response.getWriter();
				//文件类型
	            String uploadContentType = myfile.getContentType();
	            String expandedName = "";
	            //判断是否为照片
	            if (uploadContentType.equals("image/pjpeg")
	                    || uploadContentType.equals("image/jpeg")) {
	            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
	                expandedName = ".jpg";
	            } else if (uploadContentType.equals("image/png")
	                    || uploadContentType.equals("image/x-png")) {
	                // IE6上传的png图片的headimageContentType是"image/x-png"
	                expandedName = ".png";
	            } else if (uploadContentType.equals("image/gif")) {
	                expandedName = ".gif";

	            } else if (uploadContentType.equals("image/bmp")) {
	                expandedName = ".bmp";

	            } else {
						json="{'code':'2','msg':'文件格式不正确(必须为.jpg/.gif/.bmp/.png文件)'}";
						pw.print(json);
	            }
				//设置图片大小必须小于2M
				if (myfile.getSize() > 1024 * 1024 * 2) {
					json="{'code':'1','msg':'图片大小必须小于2M'}";
					pw.print(json);
				}else{
					DateFormat df = new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO);
					//重命名文件
					String fileName = df.format(new Date()) + expandedName;
					//完整路径
					String newPath="/home/fileupload/"+fileName;
					String contextPath = request.getContextPath();
					String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
					//写入文件
					File newFile=new File(newPath);
					//判断路径，如果没有则创建一个
					if (!newFile.exists()) newFile.mkdirs();
					//上传文件到服务器
					myfile.transferTo(newFile);
					String pp=basePath+"fileupload/"+fileName;
					json="{'code':'3','url':'"+pp+"'}";
					pw.print(json);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(pw!=null){
					pw.flush();
					pw.close();
				}
			}
	}

    /*
     * 上传图片
     */
    @RequestMapping("/uploadImg")
    public void uplodaImg(@RequestParam("upload") MultipartFile file,//
            HttpServletRequest request, //
            HttpServletResponse response)//
    {
    		PrintWriter out=null;
        try {
            out = response.getWriter();
            //ckeditor必填的参数
            String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
            //获取文件名
            String fileName = file.getOriginalFilename();
            //上传地址
            String path =request.getSession().getServletContext().getRealPath("/fileupload/");
            //文件类型
            String uploadContentType = file.getContentType();
            String expandedName = "";
            //判断是否为照片
            if (uploadContentType.equals("image/pjpeg")
                    || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
                expandedName = ".jpg";
            } else if (uploadContentType.equals("image/png")
                    || uploadContentType.equals("image/x-png")) {
                // IE6上传的png图片的headimageContentType是"image/x-png"
                expandedName = ".png";
            } else if (uploadContentType.equals("image/gif")) {
                expandedName = ".gif";
            } else if (uploadContentType.equals("image/bmp")) {
                expandedName = ".bmp";
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("
                        + CKEditorFuncNum + ",'',"
                        + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
                out.println("</script>");
                return;
            }
            //设置图片大小必须小于2M
            if (file.getSize() > 1024 * 1024 * 2) {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("
                        + CKEditorFuncNum + ",''," + "'文件大小不得大于2M');");
                out.println("</script>");
                return;
            }
            //获取当前时间yyyyMMddHHmmss格式
            DateFormat df = new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO);
            //重命名文件
            fileName = df.format(new Date()) + expandedName;
            //完整路径
            String newPath=path+fileName;
            String contextPath = request.getContextPath();    
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
	        //写入文件
            File newFile=new File(newPath);
            //判断路径，如果没有则创建一个
            if (!newFile.exists()) newFile.mkdirs();
            //上传文件到服务器
            file.transferTo(newFile);
            String pp= basePath+"fileupload/"+fileName;
            //回调js ckeditor预览框
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction("
                    + CKEditorFuncNum + ",'"  +pp+ "','')");
            out.println("</script>");
            return;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	if(out!=null){
        		out.close();
        	}
        }
        	
        
    }
}
