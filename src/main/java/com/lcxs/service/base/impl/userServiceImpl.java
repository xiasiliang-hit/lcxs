package com.lcxs.service.base.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.search.aggregator.Count;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.base.bankBeanMapper;
import com.lcxs.mapper.base.invitationBeanMapper;
import com.lcxs.mapper.base.userBankBeanMapper;
import com.lcxs.mapper.base.userBeanMapper;
import com.lcxs.mapper.base.userRedBeanMapper;
import com.lcxs.mapper.finance.UserReceiptBeanMapper;
import com.lcxs.mapper.finance.receiptBeanMapper;
import com.lcxs.mapper.product.caseBeanMapper;
import com.lcxs.mapper.product.productBeanMapper;
import com.lcxs.mapper.product.shopBeanMapper;
import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.base.userBankBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.base.userRedBean;
import com.lcxs.model.finance.UserReceiptBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.model.product.bannerBean;
import com.lcxs.model.product.caseBean;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.base.IUserService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.ReadExcel;
import com.lcxs.utils.Time;
import com.lcxs.utils.UserExcel;
import com.lcxs.utils.banner;
import com.lcxs.utils.caseexce;
import com.lcxs.utils.product;
import com.lcxs.utils.redExcel;
@Service
public class userServiceImpl implements IUserService{
	@Resource
	private userBeanMapper dao;
	@Resource
	private invitationBeanMapper inMapper;
	@Resource
	private productBeanMapper proMapper;
	@Resource
	private shopBeanMapper shopMapper;
	@Resource
	private caseBeanMapper caseMapper;
	@Resource
	private bankBeanMapper bankMapper;
	@Resource
	private receiptBeanMapper receiptMapper;
	@Resource
	private userBankBeanMapper ubMapper;
	@Resource
	private UserReceiptBeanMapper userReceiptMapper;
	
	@Override
	public PageInfo<userBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<userBean> list=dao.findAll(vo);
		for (int i = 0; i < list.size(); i++) {
			Long vid=list.get(i).getVid();
			Integer count = dao.findFriendAll(vid);
			list.get(i).setCount(count);
			Object totaltmoney = dao.findTotalMoney(vid);
			Object totalJMoney=dao.findTotalReturnAmount(vid);
			Object totalRMoney=dao.findReadyAmount(vid);
			Object totalRedMoney=dao.findTotalRedAmount(vid);
			if(totalJMoney==null||totalJMoney=="")totalJMoney=0.0;
			if(totalRedMoney==null||totalRedMoney=="")totalRedMoney=0.0; 
			list.get(i).setTotalJMoney((Double)totalJMoney);
			list.get(i).setTotalRedMoney((Double)totalRedMoney);
			int bankCount=dao.findBankCount(vid);
			list.get(i).setBankCount(bankCount);
			int friendCount=dao.findFriendAll(vid);
			list.get(i).setFriendCount(friendCount);
			if(totalRMoney==null || "".equals(totalRMoney)){
				list.get(i).setTotalRMoney(0.0);
			}else{
				list.get(i).setTotalRMoney((Double) totalRMoney);
			}
			if(totaltmoney==null || "".equals(totaltmoney)){
				list.get(i).setTotalMoney(0.0);
			}else{
				list.get(i).setTotalMoney((Double) totaltmoney);
			}
		}
		PageInfo<userBean> pageinfo=new PageInfo<userBean>(list);
		return pageinfo;
	}
	@Override
	public userBean findUserByVid(Long vid) {
		return dao.findUserByVid(vid);
	}
	@Override
	public boolean deleteByVid(Long vid) {
		if(dao.deleteUserByVid(vid)<1){
			return false;
		}
		return true;
	}
	@Override
	public boolean updateUserByVid(userBean user) {
		if(dao.updateUserByVid(user)<1){
			return false;
		}
		return true;
	}
	@Override
	public PageInfo<receiptBean> findInvestment(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<receiptBean> list=dao.findInvestment(vo);
		PageInfo<receiptBean> pageinfo=new PageInfo<receiptBean>(list);
		return pageinfo;
	}
	@Override
	public PageInfo<bankBean> findBankByVid(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<bankBean> list=dao.findBankByVid(vo);
		PageInfo<bankBean> pageinfo=new PageInfo<bankBean>(list);
		return pageinfo;
	}
	@Override
	public PageInfo<userBean> findFriendInfo(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<userBean> list=dao.findFriendInfo(vo);
		Double sum=0.0;
		Double rsum=0.0;
		Double jsum=0.0;
		int number=0;
		for (int i = 0; i < list.size(); i++) {
			Long vid=list.get(i).getVid();
			Object num = receiptMapper.queryReceiptNumByVid(vid);
			if(num==null || "".equals(num)){
				list.get(i).setCount(0);
			}else{
				list.get(i).setCount(Integer.valueOf(String.valueOf(num)));
			}
			Object totaltmoney = dao.findTotalMoney(vid);
			Object totalJMoney=dao.findTotalReturnAmount(vid);
			Object totalRedMoney=dao.findTotalRedAmount(vid);
			if(totalJMoney==null||totalJMoney=="")totalJMoney=0.0;
			if(totalRedMoney==null||totalRedMoney=="")totalRedMoney=0.0;
			list.get(i).setTotalJMoney((Double)totalJMoney);
			list.get(i).setTotalRedMoney((Double)totalRedMoney);
			if(totaltmoney==null || "".equals(totaltmoney)){
				totaltmoney=0.0;
				list.get(i).setTotalMoney(0.0);
			}else{
				list.get(i).setTotalMoney((Double) totaltmoney);
			}
			sum=sum+(Double)totaltmoney;
			rsum=rsum+(Double)totalRedMoney;
			jsum=jsum+(Double)totalJMoney;	
			number+=list.get(i).getCount();
		}
		vo.setSum(sum);
		vo.setRsum(rsum);
		vo.setJsum(jsum);
		vo.setNumber(number);
		PageInfo<userBean> pageinfo=new PageInfo<userBean>(list);
		return pageinfo;
	}
	@Override
	@Transactional(rollbackFor = Throwable.class)//事务回滚
	public boolean deleteBank(Long id) {
		bankBean bank=new bankBean();
		bank.setId(id);
		bankMapper.updateByPrimaryKey(bank);
		return true;
	}
	@Override
	public PageInfo<userBean> findATodayR(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<userBean> list=dao.findTodayR(vo);
		PageInfo<userBean> pageinfo=new PageInfo<userBean>(list);
		return pageinfo;
	}
	@Override
	public boolean updatePwd(String pwd,Long vid) {
		BaseConditionVO vo=new BaseConditionVO();
		Md5Hash md5=new Md5Hash(pwd,"cjlc0577",1);
		String password=md5.toString();
		vo.setKeywords(password);
		vo.setKeywordsauid(vid);
		int row=dao.changePwd(vo);
		if(row<1){
			return false;
		}
		return true;
	}
	@Override
	public PageInfo<friendMessage> queryFriendMessage(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<friendMessage> list=inMapper.queryFriendMessage(vo);
		for (int i = 0; i < list.size(); i++) {
			Integer lis = dao.findFriendAll(Long.valueOf(list.get(i).getVid()));
			list.get(i).setCount(lis);
		}
		PageInfo<friendMessage> pageinfo=new PageInfo<friendMessage>(list);
		return pageinfo;
	}
	@Override
	public void payMoneyForUser(HttpServletResponse response,invitationBean invi) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		PrintWriter pw = null;
		String json="";
		invitationBean in = inMapper.selectByUserid(invi.getUserid());
		if(invi.getDkmoney()>in.getLjmoney()){
			try {
				pw=response.getWriter();
				json="{'code':'2'}";
				pw.print(json);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			in.setDkmoney(in.getDkmoney()+invi.getDkmoney());
			in.setMtime(Time.getTime());
			in.setLjmoney(in.getLjmoney()-invi.getDkmoney());
			inMapper.updateByPrimaryKeySelective(in);
			try {
				pw=response.getWriter();
				json="{'code':'1'}";
				pw.print(json);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public boolean batchImport(String name, MultipartFile file) {
		int label=1;
		boolean b = false;		
	    //创建处理EXCEL
		banner ban=new banner();
	    //解析excel，获取客户信息集合。
	    List<receiptBean> list = ban.getExcelInfo(name,file,label);
	    if(list != null){
	        b = true;
	    }
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    for (int i = 0; i < list.size(); i++) {
	    	List<userBean> user = dao.findUserByPhone(list.get(i).getVid());
	    	list.get(i).setRid(Time.getId());
	    	if(list.get(i).getStatus()==0){
	    		list.get(i).setStatus(3);
	    	}else{
	    		list.get(i).setStatus(1);
	    	}
	    	productBean pro = proMapper.selectByPrimaryKey(list.get(i).getProductid());
	    	list.get(i).setShopname(pro.getShopname());
	    	list.get(i).setProductname(pro.getPname());
	    	list.get(i).setChannel(pro.getChannel());
			String d = format.format(Long.parseLong(list.get(i).getCtime())*1000L); 
			String f = format.format(Long.parseLong(list.get(i).getTtime())*1000L);
			if(list.get(i).getMtime()==null || "".equals(list.get(i).getMtime())){
			}else{
				String e = format.format(Long.parseLong(list.get(i).getMtime())*1000L);
				list.get(i).setMtime(e);
			}
			list.get(i).setCtime(d);
			list.get(i).setTtime(f);
			UserReceiptBean uu=new UserReceiptBean();
			uu.setRid(list.get(i).getRid());
			uu.setVid(user.get(0).getVid());
			userReceiptMapper.insert(uu);
			receiptMapper.insertSelective(list.get(i));
		}
		return b;
	}
	@Override
	public bankBean queryBankByVid(Long vid) {
		// TODO Auto-generated method stub
		return bankMapper.queryBankByVid(vid);
	}
	@Override
	public void excelDownloadUser(HttpServletResponse response,BaseConditionVO vo) throws Exception {
		 // 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();    
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("理财先生回单");    
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);    
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
		sheet.setColumnWidth(0, 4888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(1, 4888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(2, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(3, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(4, 4888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(5, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(6, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(7, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(8, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(9, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(10, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
        HSSFCell cell = row.createCell((short) 0); 
        cell.setCellValue("用户编号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 1);    
        cell.setCellValue("电话号码");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 2);    
        cell.setCellValue("支付宝姓名");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 3); 
        cell.setCellValue("支付宝账号");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("总投资金额");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 5);
        cell.setCellValue("总返现金额");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 6); 
        cell.setCellValue("注册时间");    
        cell.setCellStyle(style); 
        cell = row.createCell((short) 7);
        cell.setCellValue("个人邀请码");    
        cell.setCellStyle(style); 
        cell = row.createCell((short) 8);
        cell.setCellValue("邀请人邀请码");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 9);
        cell.setCellValue("已邀请人数");    
        cell.setCellStyle(style);
        cell = row.createCell((short) 10);
        cell.setCellValue("对应客服");    
        cell.setCellStyle(style);
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
			List<userBean> list = dao.findAll(vo);
			int j=0;
				 for (userBean userBean : list) {
					    row=sheet.createRow(j+1);
					    Integer count = dao.findFriendAll(userBean.getVid());
						Object totaltmoney = dao.findTotalMoney(userBean.getVid());
						Object totalJMoney=dao.findTotalReturnAmount(userBean.getVid());
						Object totalRedMoney=dao.findTotalRedAmount(userBean.getVid());
						if(totalJMoney==null||totalJMoney=="")totalJMoney=0.0;
						if(totalRedMoney==null||totalRedMoney=="")totalRedMoney=0.0; 
						if(totaltmoney==null || "".equals(totaltmoney))totaltmoney=0.0;
						row.createCell((short) 0).setCellValue(" "+userBean.getVid());
					 	row.createCell((short) 1).setCellValue(" "+userBean.getPhone());    
			            row.createCell((short) 2).setCellValue(userBean.getRealname()); 
			            row.createCell((short) 3).setCellValue(userBean.getAlipay());
			            row.createCell((short) 4).setCellValue(String.valueOf(totaltmoney));
			            row.createCell((short) 5).setCellValue(totalJMoney+"+"+totalRedMoney);
			            row.createCell((short) 6).setCellValue(userBean.getCtime());
			            row.createCell((short) 7).setCellValue(userBean.getOwninvitation());
			            row.createCell((short) 8).setCellValue(userBean.getInvitation());
			            row.createCell((short) 9).setCellValue(count);
			            row.createCell((short) 10).setCellValue(userBean.getKf());
			            j++;
			    }     
			// 第六步，将文件存到指定位置    
		        Date nowTime = new Date();
		        Long fileName = nowTime.getTime();
		        ByteArrayOutputStream os = new ByteArrayOutputStream();
		        wb.write(os);
		        byte[] content = os.toByteArray();
		        InputStream is = new ByteArrayInputStream(content);
		        // 设置response参数，可以打开下载页面
		        response.reset();
		        response.setContentType("application/vnd.ms-excel;charset=utf-8");
		        response.setHeader("Content-Disposition", "attachment;filename="
		            + new String((fileName+".xls").getBytes(), "utf-8"));
		        ServletOutputStream out = response.getOutputStream();
		        BufferedInputStream bis = null;
		        BufferedOutputStream bos = null;
		        try {
		          bis = new BufferedInputStream(is);
		          bos = new BufferedOutputStream(out);
		          byte[] buff = new byte[2048];
		          int bytesRead;
		          // Simple read/write loop.
		          while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		            bos.write(buff, 0, bytesRead);
		          }
		        } catch (Exception e) {
		          e.printStackTrace();
		        } finally {
		          if (bis != null)
		            bis.close();
		          if (bos != null)
		            bos.close();
		          if(is !=null)
			        is.close();
		          if(os !=null)
		        	os.close();
		        }
		
	}

	@Override
	public boolean updateOwnByVid(long vid) {
		dao.updateOwnByVid(vid);
		return true;
	}

	
}
