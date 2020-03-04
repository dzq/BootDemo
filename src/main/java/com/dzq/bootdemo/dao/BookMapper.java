package com.dzq.bootdemo.dao;

import com.dzq.bootdemo.pojo.Books;
import com.dzq.bootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookMapper  {
    //增加一个Book
    Books addBook(Books book);
    //根据id删除一个Book
    int deleteBookById(int id);
    //更新Book
    Books updateBook(Books books);
    //根据id查询,返回一个Book
    Books queryBookById(int id);
    //查询全部Book,返回list集合
    List<Books> queryAllBook();
    //查询包含名称book,返回list集合
    List<Books> queryBookByName(String bookName);

}
