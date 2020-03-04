package com.dzq.bootdemo.service;

import com.dzq.demo.pojo.Books;

import java.util.List;

//BookService:底下需要去实现,调用dao层
public interface BookService {
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
