package com.gopher.zkd1.tk;


import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@RegisterMapper
public interface CoreMapper<T>  extends Mapper<T>, MySqlMapper<T> {

}
