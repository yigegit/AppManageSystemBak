package com.mercer.mapper;

import com.mercer.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Date:2019/4/15
 * Auther:Mercer
 * Auther:麻前程
 */
public interface AppCategoryMapper {
    List<AppCategory> queryAppCategoriesLevelOne();

    List<AppCategory> queryLevelByParentId(@Param("levelParentId") Long id);


}
