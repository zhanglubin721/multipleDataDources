package com.zhanglubin.multipleDataSources.mapper.datasourceMyself;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhanglubin
 * @date 2021/2/19
 */
@Mapper
public interface DataSourcesMyselfMapper {

    String getUsername();
}
