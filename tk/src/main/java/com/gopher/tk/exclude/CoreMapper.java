package com.gopher.tk.exclude;


import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 6c6763
 * @date 2020/10/27
 */
@RegisterMapper
public interface CoreMapper<T>  extends Mapper<T>, MySqlMapper<T> {

}
