package com.dzq.bootdemo.service;

import com.dzq.bootdemo.dao.BookMapper;
import com.dzq.bootdemo.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    @Autowired
    private  BookMapper bookMapper;

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public int addBook(Books book) {
        return bookMapper.insert(book);
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    public int deleteBookById(int id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新书籍
     * @param books
     * @return
     */
    public int updateBook(Books books) {
        return bookMapper.updateByPrimaryKey(books);
    }

    /**
     * 通过id获取书籍
     * @param id
     * @return
     */
    public Books queryBookById(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有书籍
     * @return
     */
    public List<Books> queryAllBook() {
        return bookMapper.selectAll();
    }

    /**
     * 通过名称获取书籍
     * @param bookName
     * @return
     */
    @Override
    public List<Books> queryBookByName(String bookName) {
        Example example = new Example(Books.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%"+bookName+"%");
        return bookMapper.selectByExample(example);
    }
}
