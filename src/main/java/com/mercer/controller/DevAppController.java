package com.mercer.controller;

import com.github.pagehelper.PageInfo;
import com.mercer.dto.AppInfoDTO;
import com.mercer.pojo.AppCategory;
import com.mercer.pojo.AppInfo;
import com.mercer.pojo.DataDictionary;
import com.mercer.service.AppCategoryService;
import com.mercer.service.AppInfoService;
import com.mercer.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
@Controller
@RequestMapping("/app")
public class DevAppController {

    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private AppCategoryService appCategoryService;

    @RequestMapping("/index/devId/{id}")
    public String index(@PathVariable("id") Long id, Model model, HttpSession session){
        System.out.println(id);
        session.setAttribute("USER_ID",id);
        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        pageInfo = appInfoService.queryByDevUserId(id,pageInfo);

        //查询所有平台
        List<DataDictionary> appFlatforms = dataDictionaryService.queryAllFlatforms();
        //查询所有的APP状态
        List<DataDictionary> appStatus = dataDictionaryService.queryAllStatus();
        //查询所有一级分类
        List<AppCategory> appCategoriesLevelOne = appCategoryService.queryAppCategoriesLevelOne();

        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("appStatus",appStatus);
        model.addAttribute("page",pageInfo);
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);
        return "app/index";
    }
    @RequestMapping("/query")
    public String query(AppInfoDTO appInfoDTO,Model model,HttpSession session){
        System.out.println(appInfoDTO);
        Object obj = session.getAttribute("USER_ID");
        if (obj!=null){
            Long id = (Long) obj;
            appInfoDTO.setDevUserId(id);
            PageInfo<AppInfo> list = appInfoService.query(appInfoDTO);
            //查询所有平台
            List<DataDictionary> appFlatforms = dataDictionaryService.queryAllFlatforms();
            //查询所有的APP状态
            List<DataDictionary> appStatus = dataDictionaryService.queryAllStatus();
            //查询所有一级分类
            List<AppCategory> appCategoriesLevelOne = appCategoryService.queryAppCategoriesLevelOne();

            model.addAttribute("appFlatforms",appFlatforms);
            model.addAttribute("appStatus",appStatus);
            model.addAttribute("page",list);
            model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);
            model.addAttribute("appInfoDTO",appInfoDTO);
            return "app/index";
        }
        else {
            return "redirect:/";
        }

    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        //查询所有平台
        List<DataDictionary> appFlatforms = dataDictionaryService.queryAllFlatforms();
        //查询所有的APP状态
        List<DataDictionary> appStatus = dataDictionaryService.queryAllStatus();
        //查询所有一级分类
        List<AppCategory> appCategoriesLevelOne = appCategoryService.queryAppCategoriesLevelOne();

        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("appStatus",appStatus);
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);

        return "app/add";
    }
    @RequestMapping("/add")
    public String add(AppInfo appInfo,HttpSession session){
        System.out.println(appInfo);
                                                                                                                             Object user_id = session.getAttribute("USER_ID");
        Long userId = (Long) user_id;
        boolean flag = appInfoService.add(appInfo,userId);
        //转发到action
        return "redirect:/app/index/devId/"+user_id;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long appId,HttpSession session){
        Object user_id = session.getAttribute("USER_ID");
        Long userId = (Long) user_id;
        boolean flag= appInfoService.delete(appId);
        return "redirect:/app/index/devId/"+user_id;
    }
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id")Long appId,Model model){
        AppInfo appSingleInfo = appInfoService.queryByAppId(appId);
        //查询所有平台
        List<DataDictionary> appFlatforms = dataDictionaryService.queryAllFlatforms();
        //查询所有的APP状态
        List<DataDictionary> appStatus = dataDictionaryService.queryAllStatus();
        //查询所有一级分类
        List<AppCategory> appCategoriesLevelOne = appCategoryService.queryAppCategoriesLevelOne();

        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("appStatus",appStatus);
        model.addAttribute("appCategoriesLevelOne",appCategoriesLevelOne);
        model.addAttribute("appSingleInfo",appSingleInfo);
        return "app/edit";
    }

    @RequestMapping("/edit")
    public String edit(AppInfo appInfo,HttpSession session){
        Object user_id = session.getAttribute("USER_ID");
        Long userId = (Long) user_id;
        boolean flag =appInfoService.update(appInfo,userId);
        return "redirect:/app/index/devId/"+user_id;
    }

    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable("id")Long appId,Model model){
        AppInfo appInfo = appInfoService.queryDetailByAppId(appId);
        model.addAttribute("appInfoDetailWithVersion",appInfo);

        return "app/appDetail";
    }
}
