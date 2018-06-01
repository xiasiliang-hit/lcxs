package com.lcxs.service.finance.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.base.invitationBeanMapper;
import com.lcxs.mapper.base.userBeanMapper;
import com.lcxs.mapper.base.userRedBeanMapper;
import com.lcxs.mapper.finance.UserReceiptBeanMapper;
import com.lcxs.mapper.finance.receiptBeanMapper;
import com.lcxs.mapper.product.caseBeanMapper;
import com.lcxs.mapper.finance.priceBeanMapper;
import com.lcxs.mapper.product.productBeanMapper;
import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.base.userRedBean;
import com.lcxs.model.finance.UserReceiptBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.model.finance.priceBean;
import com.lcxs.model.product.caseBean;
import com.lcxs.model.product.productBean;
import com.lcxs.service.finance.IReceiptService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;

@Service
public class receiptServiceImpl implements IReceiptService{

	@Resource
	private receiptBeanMapper receiptMapper;
	@Resource
	private UserReceiptBeanMapper urMapper;
	@Resource
	private userBeanMapper userMapper;
	@Resource
	private caseBeanMapper caseMapper;
	@Resource
	private productBeanMapper proMapper;
	@Resource
	private invitationBeanMapper inMapper;
	@Resource
	private userRedBeanMapper urbMapper;
	@Resource
	private priceBeanMapper priceMapper;


	@Override
	public PageInfo<receiptBean> queryAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<receiptBean> list=receiptMapper.queryAll(vo);
		for (int i = 0; i < list.size(); i++) {
			userBean user = userMapper.findUserByRid(list.get(i).getRid());
			list.get(i).setName(user.getRealname());
			list.get(i).setVid(String.valueOf(user.getVid()));
			list.get(i).setTtime(list.get(i).getTtime().substring(0,10));
			caseBean casee = caseMapper.selectByPrimaryKey(list.get(i).getCaseid());
			list.get(i).setDtime(casee.getDtime());
			priceBean price = priceMapper.selectByRid(list.get(i).getRid());
			if(price == null){
				price = new priceBean();
				if(casee.getTprice()=="1" || "1".equals(casee.getTprice())){
					price.setPrice(casee.getTexttime());
				}else{
					price.setPrice(String.valueOf(Math.round(list.get(i).getTmoney()*Double.valueOf(casee.getTexttime())/100)));
				}
				price.setRid(list.get(i).getRid());
				priceMapper.insert(price);
			}
			list.get(i).setTprice(price.getPrice());
			list.get(i).setTotalMoney(String.valueOf(list.get(i).getJmoney()+list.get(i).getRedmoney()));
		}
		PageInfo<receiptBean> pageinfo=new PageInfo<receiptBean>(list);
		return pageinfo;
	}

	@Override
	public int insert(receiptBean record) {
		// TODO Auto-generated method stub
		return receiptMapper.insert(record);
	}
	@Override
	public int insertSelective(receiptBean record) {
		// TODO Auto-generated method stub
		return receiptMapper.insertSelective(record);
	}
	@Override
	public receiptBean selectByRid(Long id) {
		// TODO Auto-generated method stub
		return receiptMapper.selectByRid(id);
	}
	@Override
	public int updateByPrimaryKeySelective(receiptBean record) {
		// TODO Auto-generated method stub
		return receiptMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(receiptBean record) {
		// TODO Auto-generated method stub
		return receiptMapper.updateByPrimaryKey(record);
	}

	@Override
	public void updateToPass(receiptBean receipt,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		receipt.setMtime(Time.getTime());
		receipt.setStatus(1);
		receiptMapper.updateByPrimaryKeySelective(receipt);
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

	@Override
	public void updateToReject(receiptBean receipt,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		receipt.setMtime(Time.getTime());
		receipt.setStatus(2);
		userRedBean cas = urbMapper.queryUserRedByRid(receipt.getRid());
		if(cas==null || "".equals(cas)){
		}else{
			cas.setType("0");
			urbMapper.updateByPrimaryKeySelective(cas);
		}
		receiptMapper.updateByPrimaryKeySelective(receipt);
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

	@Override
	public void updateToMoney(receiptBean receipt,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		receipt.setMtime(Time.getTime());
		receipt.setStatus(4);
		receiptMapper.updateByPrimaryKeySelective(receipt);
		userBean user = urMapper.queryUserByRid(receipt.getRid());
		if(user.getInvitation()==null || "".equals(user.getInvitation())){
		}else{
			userBean us = userMapper.queryUserByInvitation(user.getInvitation());
			if(us==null || "".equals(us)){
			}else{
				invitationBean invi = inMapper.selectByUserid(us.getVid());
				invitationBean in=new invitationBean();
				if(receipt.getTmoney()>=5000){
					if(invi==null || "".equals(invi)){
						in.setCtime(Time.getTime());
						in.setUserid(us.getVid());
						in.setUcode(us.getOwninvitation());
						in.setLjmoney(10.0);
						in.setMtime(Time.getTime());
						inMapper.insertSelective(in);
					}else{
						Object count = urMapper.queryReceiptNumByVid(user.getVid());
						if(String.valueOf(count)=="1" || "1".equals(String.valueOf(count))){
							invi.setLjmoney(invi.getLjmoney()+10.0);
						}else{
							invi.setLjmoney(invi.getLjmoney()+5.0);
						}
						inMapper.updateByPrimaryKeySelective(invi);
					}
				}
			}
		}
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

	@Override
	public void updateTodelete(receiptBean receipt, HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		receipt.setMtime(Time.getTime());
		receipt.setStatus(5);
		userRedBean cas = urbMapper.queryUserRedByRid(receipt.getRid());
		if(cas==null || "".equals(cas)){
		}else{
			cas.setType("0");
			urbMapper.updateByPrimaryKeySelective(cas);
		}
		receiptMapper.updateByPrimaryKeySelective(receipt);
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

	@Override
	public PageInfo<receiptBean> queryAnyDayOfReceipt(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<receiptBean> list=receiptMapper.queryAnyDayOfReceipt(vo);
		PageInfo<receiptBean> pageinfo=new PageInfo<receiptBean>(list);
		return pageinfo;
	}

	@Override
	public PageInfo<receiptBean> queryToDayMoneyPerson(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<receiptBean> list=receiptMapper.queryToDayMoneyPerson(vo);
		PageInfo<receiptBean> pageinfo=new PageInfo<receiptBean>(list);
		return pageinfo;
	}

	@Override
	public Double queryToDayMoney() {
		// TODO Auto-generated method stub
		return receiptMapper.queryToDayMoney();
	}

	@Override
	public void excelDowloadReceipt(int status,String start,String end,BaseConditionVO vo,HttpServletResponse response) throws Exception {
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
		sheet.setColumnWidth(2, 4888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(3, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(4, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(5, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(6, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(7, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(8, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(9, 5888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(10, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(11, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(12, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(13, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(14, 5888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(15, 5888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(16, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(17, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(18, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(19, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(20, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(21, 3888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(22, 5888); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("回单编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("用户编号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("支付宝姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("投资产品");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("活动平台用户名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("活动平台手机号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("投资期限");
		cell.setCellStyle(style);
		cell = row.createCell((short) 7);
		cell.setCellValue("投资金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 8);
		cell.setCellValue("总返利金");
		cell.setCellStyle(style);
		cell = row.createCell((short) 9);
		cell.setCellValue("方案返利");
		cell.setCellStyle(style);
		cell = row.createCell((short) 10);
		cell.setCellValue("红包金额");
		cell.setCellStyle(style);
		cell = row.createCell((short) 11);
		cell.setCellValue("拿货价格");
		cell.setCellStyle(style);
		cell = row.createCell((short) 12);
		cell.setCellValue("渠道来源");
		cell.setCellStyle(style);
		cell = row.createCell((short) 13);
		cell.setCellValue("投资时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 14);
		cell.setCellValue("提交时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 15);
		cell.setCellValue("状态");
		cell.setCellStyle(style);
		cell = row.createCell((short) 16);
		cell.setCellValue("审核时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 17);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		cell = row.createCell((short) 18);
		cell.setCellValue("审核人");
		cell.setCellStyle(style);
//        cell = row.createCell((short) 18);
//        cell.setCellValue("拿货价格");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 19);
//        cell.setCellValue("备注");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 20);
//        cell.setCellValue("审核人");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 21);
//        cell.setCellValue("投资时间");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 22);
//        cell.setCellValue("提交时间");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 23);
//        cell.setCellValue("最终改动时间");
//        cell.setCellStyle(style);
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		vo.setKeywordsstatus(status);
		vo.setKeywordsnumber(end);
		vo.setKeywordsname(start);
		List<receiptBean> list = receiptMapper.queryAnyDayOfReceipt(vo);
		for (int j = 0; j <list.size() ; j++) {
			UserReceiptBean ur = urMapper.selectByRid(list.get(j).getRid());
			vo.setKeywordsauid(ur.getVid());
			userBean user = userMapper.findUserByVid(ur.getVid());
			List<bankBean> ll = userMapper.findBankByVid(vo);
			caseBean ca = caseMapper.selectByPrimaryKey(list.get(j).getCaseid());
			productBean pro = proMapper.selectByPrimaryKey(ca.getProductid());
			row=sheet.createRow(j+1);
			row.createCell((short) 0).setCellValue(" "+list.get(j).getRid());
			row.createCell((short) 1).setCellValue(" "+user.getVid());
			row.createCell((short) 2).setCellValue(user.getRealname());
			row.createCell((short) 3).setCellValue(pro.getPname());
			row.createCell((short) 4).setCellValue(list.get(j).getRealname());
			row.createCell((short) 5).setCellValue(list.get(j).getPhone());
			row.createCell((short) 6).setCellValue(ca.getDtime());
			row.createCell((short) 7).setCellValue(" "+list.get(j).getTmoney());
			row.createCell((short) 8).setCellValue(" "+(list.get(j).getJmoney()+list.get(j).getRedmoney()));
			row.createCell((short) 9).setCellValue(" "+list.get(j).getJmoney());
			row.createCell((short) 10).setCellValue(" "+list.get(j).getRedmoney());
			if(ca.getTprice()=="1" || "1".equals(ca.getTprice())){
				row.createCell((short) 11).setCellValue(" "+ca.getTexttime());
			}else{
				row.createCell((short) 11).setCellValue(" "+(Double.valueOf(ca.getTexttime())*list.get(j).getTmoney()/100));
			}
			row.createCell((short) 12).setCellValue(list.get(j).getChannel());
			row.createCell((short) 13).setCellValue(list.get(j).getTtime().substring(0,10));
			row.createCell((short) 14).setCellValue(list.get(j).getCtime());
			switch (status) {
				case 1:
					row.createCell((short) 15).setCellValue("已通过");
					break;
				case 2:
					row.createCell((short) 15).setCellValue("已驳回");
					break;
				case 3:
					row.createCell((short) 15).setCellValue("未审核");
					break;
				case 4:
					row.createCell((short) 15).setCellValue("已打款");
					break;
				case 5:
					row.createCell((short) 15).setCellValue("已删除");
					break;
				default:
					break;
			}
			row.createCell((short) 16).setCellValue(list.get(j).getMtime());
			row.createCell((short) 17).setCellValue(list.get(j).getContext());
			row.createCell((short) 18).setCellValue(list.get(j).getAuditor());
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
	public void updateToReceipt(receiptBean receipt,HttpServletResponse response) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		receipt.setMtime(Time.getTime());
		receipt.setStatus(3);
		userRedBean cas = urbMapper.queryUserRedByRid(receipt.getRid());
		if(cas==null || "".equals(cas)){
		}else{
			if(cas.getType()=="0" || "0".equals(cas.getType())){
				cas.setType("1");
				urbMapper.updateByPrimaryKeySelective(cas);
			}else{

				receipt.setRedid(Long.valueOf(0));
				receipt.setRedmoney(cas.getRedmoney());
			}
		}
		receiptMapper.updateByPrimaryKeySelective(receipt);
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

	@Override
	public void listUpdateToReceipt(Object[] rid, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter pw = null;
		String json="";
		for (int i = 0; i < rid.length-1; i++) {
			receiptBean receipt=new receiptBean();
			receipt.setRid(Long.valueOf(String.valueOf(rid[i])));
			receipt.setMtime(Time.getTime());
			receipt.setStatus(1);
			receipt.setAuditor(String.valueOf(rid[rid.length-1]));
			receiptMapper.updateByPrimaryKeySelective(receipt);
		}
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
