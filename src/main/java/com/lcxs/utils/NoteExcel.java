package com.lcxs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lcxs.model.product.noteBean;

public class NoteExcel {
	 //总行数
    private int totalRows = 0;  
    //总条数
    private int totalCells = 0; 
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public NoteExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;} 
    //获取总列数
    public int getTotalCells() {  return totalCells;} 
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }  
    
  /**
   * 验证EXCEL文件
   * @param filePath
   * @return
   */
  public boolean validateExcel(String filePath){
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
            errorMsg = "文件名不是excel格式";  
            return false;  
        }  
        return true;
  }
    
  /**
   * 读EXCEL文件，获取客户信息集合
   * @param fielName
   * @return
   */
  public List<noteBean> getExcelInfo(String fileName,MultipartFile Mfile,int label){
      
      //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
       File file = new  File("D:\\fileupload");
       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
     
       if (!file.exists()) file.mkdirs();
       //新建一个文件
       File file1 = new File("D:\\fileupload" +"/"+ new Date().getTime() + ".xlsx"); 
       //将上传的文件写入新建的文件中
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }    
       //初始化客户信息的集合    
       List<noteBean> list=new ArrayList<noteBean>();
     
       //初始化输入流
       InputStream is = null;  
       try{
          //验证文件名是否合格
          if(!validateExcel(fileName)){
              return null;
          }
          //根据文件名判断文件是2003版本还是2007版本
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //根据新建的文件实例化输入流
          is = new FileInputStream(file1);
          //根据excel里面的内容读取客户信息
          list = getExcelInfo(is, isExcel2003, label); 
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return list;
  }
  /**
   * 根据excel里面的内容读取客户信息
   * @param is 输入流
   * @param isExcel2003 excel是2003还是2007版本
   * @return
   * @throws IOException
   */
  public  List<noteBean> getExcelInfo(InputStream is,boolean isExcel2003,int label){
	   List<noteBean> list =new ArrayList<noteBean>();
       try{
           /** 根据版本选择创建Workbook的方式 */
           Workbook wb = null;
           //当excel是2003时
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//当excel是2007时
               wb = new XSSFWorkbook(is); 
           }
           if( label==1){
        	   //读取Excel里面客户的学生家长信息
        	   list=readExcelValue(wb);
           }
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return list;
  }
  /**
   * 读取Excel里面客户的信息
   * @param wb
   * @return
   */
private List<noteBean> readExcelValue(Workbook wb){ 
	  List<noteBean> noteList=null;
	  //得到第一个sheet
	  Sheet[] sheet=new Sheet[wb.getNumberOfSheets()];
	  for(int i=0;i<wb.getNumberOfSheets();i++){
		  sheet[i]=wb.getSheetAt(i);
		  if(sheet[i]!=null){
			//得到Excel的行数
		       this.totalRows=sheet[i].getPhysicalNumberOfRows();
		      //得到Excel的列数(前提是有行数)
		       if(totalRows>=1 && sheet[i].getRow(0) != null){
		            this.totalCells=sheet[i].getRow(0).getPhysicalNumberOfCells();
		       }
		       noteList=new ArrayList<noteBean>();
		       noteBean note;  
		      //循环Excel行数,从第2行开始。标题不入库
		       for(int r=1;r<totalRows;r++){
		           Row row = sheet[i].getRow(r);
		           if (row == null) continue;
		           note = new noteBean();
		           //循环Excel的列
		           for(int c = 0; c <this.totalCells; c++){    
		        	   try {
						Thread.currentThread().sleep(1);
						Cell cell = row.getCell(c);
			               if (null != cell){
			            	   row.getCell(c).setCellType(Cell.CELL_TYPE_STRING);
			            	   if(c==1){
			            		   note.setTitle(cell.getStringCellValue());
			            	   }else if(c==2){
			            		   note.setContent(cell.getStringCellValue());
			                   }else if(c==3){
			                	   note.setStatus(Integer.parseInt(cell.getStringCellValue()));
			                   }else if(c==4){
			                	   note.setType(Integer.parseInt(cell.getStringCellValue()));	
			                   }
			              
			               }
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           }
		           //		           添加客户
		           noteList.add(note);
		       } 
		       continue;
	      }
	  } 
      return noteList; 
  }
}
