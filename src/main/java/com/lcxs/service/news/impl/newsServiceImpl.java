package com.lcxs.service.news.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.service.news.INewsService;
import com.lcxs.utils.BaseConditionVO;
import org.springframework.stereotype.Service;
import com.lcxs.mapper.news.newsBeanMapper;


import javax.annotation.Resource;
import java.util.List;



@Service
public class newsServiceImpl implements INewsService{
    @Resource
    private newsBeanMapper nwMapper;
    @Override
    public PageInfo<newsBean> queryAll(BaseConditionVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<newsBean> list=nwMapper.queryAll(vo);
        PageInfo<newsBean> pageinfo=new PageInfo<newsBean>(list);
        return pageinfo;
    }
}
