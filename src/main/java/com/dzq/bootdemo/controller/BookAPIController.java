package com.dzq.bootdemo.controller;

import com.dzq.api.vo.BookListResponse;
import com.dzq.api.vo.BookResponse;
import com.dzq.demo.pojo.Books;
import com.dzq.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "书籍管理")
@RestController
/**
 * 书籍API
 */
public class BookAPIController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    /**
     * 书籍列表
     * @return
     */
    @GetMapping(value = "/book/list")
    @ApiOperation(value = "查询所有书籍", notes = "查询所有书籍", code = 200, produces = "application/json")
    public BookListResponse list() {
        BookListResponse body = new BookListResponse();
        List<Books> list =  bookService.queryAllBook();
        body.setData(list);
        return body;
    }

    /**
     * 查询指定id的数据
     * @param id
     * @return
     */
    @GetMapping(value = "/book/{id}")
    @ApiOperation(value = "查询指定ID的书籍", notes = "书籍ID", code = 200, produces = "application/json")
    public BookResponse queryBookById(@PathVariable("id") int id) {
        BookResponse body = new BookResponse();
        body.setData(bookService.queryBookById(id));
        return body;
    }

    /**
     * 添加书籍
     * @param books 书籍数据
     * @return
     */
    @PostMapping(value = "/book")
    @ApiOperation(value = "添加书籍", notes = "添加书籍", code = 200, produces = "application/json")
    public BookResponse addBook(Books books) {
        BookResponse body = new BookResponse();
        body.setData(bookService.addBook(books));
        return body;
    }
    /**
     * 删除书籍
     * @param id 书籍id
     * @return
     */
    @DeleteMapping(value = "/book/{id}")
    @ApiOperation(value = "删除书籍", notes = "删除指定ID的书籍", code = 200, produces = "application/json")
    public BookResponse deleteBook(@PathVariable("id") int id) {
        BookResponse body = new BookResponse();
        body.setData(bookService.deleteBookById(id));
        return body;
    }
    /**
     * 更新书籍
     * @param books 书籍数据
     * @return
     */
    @PutMapping(value = "/book")
    @ApiOperation(value = "更新书籍", notes = "更新书籍信息", code = 200, produces = "application/json")
    public BookResponse updateBook(Books books) {
        BookResponse body = new BookResponse();
        body.setData(bookService.updateBook(books));
        return body;
    }
}
