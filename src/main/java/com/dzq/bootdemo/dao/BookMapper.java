package com.dzq.bootdemo.dao;

import com.dzq.bootdemo.pojo.Books;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface BookMapper extends Mapper<Books> {

}
