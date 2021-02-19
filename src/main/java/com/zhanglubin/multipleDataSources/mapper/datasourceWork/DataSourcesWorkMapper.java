package com.zhanglubin.multipleDataSources.mapper.datasourceWork;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanglubin
 * @date 2021/2/19
 */
@Mapper
public interface DataSourcesWorkMapper {

    String getClientName();
}
