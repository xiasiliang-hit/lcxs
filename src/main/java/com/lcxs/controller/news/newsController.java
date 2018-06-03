package com.lcxs.controller.news;
import javax.annotation.Resource;

import com.lcxs.service.news.INewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.service.news.INewsService;
import com.lcxs.utils.BaseConditionVO;
@Controller
@RequestMapping("/news")
public class newsController {
    @Resource
    private INewsService nService;

    @RequestMapping("/findAll")
    @RequiresPermissions("NEWS_ALL")
    public String findAll(Model model,BaseConditionVO vo){
        PageInfo<newsBean> list = nService.queryAll(vo);
        model.addAttribute("pageModel",list);
        model.addAttribute("vo",vo);
        return "news/newsList";
    }

}
