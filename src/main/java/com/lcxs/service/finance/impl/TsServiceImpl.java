package com.lcxs.service.finance.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.base.invitationBeanMapper;
import com.lcxs.mapper.base.userBeanMapper;
import com.lcxs.mapper.finance.TsBeanMapper;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.finance.TsBean;
import com.lcxs.model.finance.UserTsBean;

import com.lcxs.service.finance.ITsService;
import com.lcxs.utils.BaseConditionVO;

import org.springframework.stereotype.Service;

@Service
public class TsServiceImpl implements ITsService {
    @Resource
    private TsBeanMapper tsMapper;
    @Resource
    private userBeanMapper userMapper;
    @Resource
    private UserTsServiceImpl utMapper;
    @Resource
    private invitationBeanMapper inMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return tsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TsBean record) {

        return tsMapper.insert(record);
    }

    @Override
    public int insertSelective(TsBean record) {
        // TODO Auto-generated method stub
        return tsMapper.insertSelective(record);
    }

    @Override
    public TsBean selectByPrimaryKey(Long  vid) {
        // TODO Auto-generated method stub
        return tsMapper.selectByPrimaryKey(vid);
    }

    @Override
    public int updateByPrimaryKeySelective(TsBean record) {
        // TODO Auto-generated method stub
        return tsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TsBean record) {
        // TODO Auto-generated method stub
        return tsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<TsBean> queryAll(BaseConditionVO vo) {

        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<userBean> list1 = userMapper.findTsFriendInfo(vo);
        List<TsBean> list = tsMapper.queryAll(vo);
        UserTsBean ut = new UserTsBean();
        TsBean ts = new TsBean();


            for (int i = 0; i < list1.size(); i++) {
//                if (list1.get(i).getVid() == null || "".equals(list1.get(i).getVid()) ) {
                    Long vid = list1.get(i).getVid();
                    String tsid = list1.get(i).getOwninvitation();
                if (ut.getVid() == null || ut.getTsid() == null || "".equals(ut.getTsid())) {
                    ut.setVid(vid);
                    ut.setTsid(tsid);
                      try{
                            utMapper.insert(ut);
                      }catch(Exception e){
                          System.out.println("出现重复，跳过！");
                      }
                    }
                    String own = list1.get(i).getOwninvitation();
                    Integer count = userMapper.findTsFriendAll(vid);
                    ts.setYqren(count);
                    ts.setTsid(list1.get(i).getOwninvitation());
                    ts.setAilpay(list1.get(i).getAlipay());
                    ts.setRealname(list1.get(i).getRealname());
                    ts.setPhone(Long.parseLong(list1.get(i).getPhone()));

                    Object totaltmoney = totaltmoney = userMapper.findTotalMoney(vid);

                    Object totalJMoney = totalJMoney = userMapper.findTotalReturnAmount(vid);

                    if (totalJMoney == null || totalJMoney == "") totalJMoney = 0.0;
                    ts.setLjmoney((Double) totalJMoney);
                    ts.setDkmoney((Double) totaltmoney);
                    ts.setNexttime(list1.get(i).getCtime());
                    System.out.print(ts.toString());
                    list.add(ts);
                    try{
                        tsMapper.insertSelective(ts);
                    }catch(Exception e){
                        System.out.println("出现重复，跳过！");
                    }
                }
//            }

        PageInfo<TsBean> pageinfo = new PageInfo<TsBean>();
        pageinfo.setList(list);
        return pageinfo;
    }

    @Override
    public int updatePassMoney(String tsid) {

        return tsMapper.updatePassMoney(tsid);
    }

    @Override
    public PageInfo<friendMessage> queryTs(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<friendMessage> list=inMapper.queryTs(vo);
        for (int i = 0; i < list.size(); i++) {
            Integer lis = userMapper.findFriendAll(Long.valueOf(list.get(i).getVid()));
            list.get(i).setCount(lis);
        }
        PageInfo<friendMessage> pageinfo=new PageInfo<friendMessage>(list);
        return pageinfo;
    }


}
