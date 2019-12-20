package com.mercer.service;

import com.mercer.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
public interface AppCategoryService {
    List<AppCategory> queryAppCategoriesLevelOne();

    List<AppCategory> queryLevelByParentId(Long id);

}
