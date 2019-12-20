package com.mercer.mapper;

import com.mercer.pojo.DataDictionary;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
public interface DataDictionaryMapper {
    List<DataDictionary> queryAllStatus();
    List<DataDictionary> queryAllFlatforms();
}
