package com.lcxs.service.news.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.service.news.INewsService;
import com.lcxs.utils.BaseConditionVO;
import org.springframework.stereotype.Service;
import com.lcxs.mapper.news.newsBeanMapper;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Service
public class newsServiceImpl implements INewsService{
    @Resource
    private newsBeanMapper nwMapper;
    @Override
    public PageInfo<newsBean> queryAll(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<newsBean> list=nwMapper.queryAll(vo);
        for(int i=0;i<list.size();i++){
            list.get(i).setRemark(list.get(i).getRemark().substring(0,15)+"...");
        }
        PageInfo<newsBean> pageinfo=new PageInfo<newsBean>(list);
        return pageinfo;
    }
    @Override
    public Long deleteByNewsid(Long id) {
        return nwMapper.deleteByNewsid(id);
    }

    @Override
    public int insert(newsBean news) {
        SimpleDateFormat myFmt2=new SimpleDateFormat("HH:mm:ss");
        news.setNtime(news.getNtime()+" "+myFmt2.format(new Date()));
        return nwMapper.insert(news);
    }

    @Override
    public newsBean findByid(Long id) {
        return nwMapper.findByid(id);
    }

    @Override
    public int update(newsBean news) {
        SimpleDateFormat myFmt2=new SimpleDateFormat("HH:mm:ss");
        news.setNtime(news.getNtime().substring(0,10)+" "+myFmt2.format(new Date()));
        return nwMapper.update(news);
    }
}
