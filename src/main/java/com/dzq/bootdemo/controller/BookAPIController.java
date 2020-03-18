package com.dzq.bootdemo.controller;

import com.dzq.bootdemo.pojo.Books;
import com.dzq.bootdemo.service.BookService;
import com.dzq.bootdemo.vo.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "书籍管理")
@RestController
/**
 * 书籍API
 */
public class BookAPIController {

    @Autowired
    private  BookService bookService;



    /**
     * 书籍列表
     * @return
     */
    @GetMapping(value = "/book/list")
    @ApiOperation(value = "查询所有书籍", notes = "查询所有书籍", code = 200, produces = "application/json")
    public ResponseBody<List<Books>> list() {
        List<Books> list =  bookService.queryAllBook();
        return new ResponseBody<>(list);
    }

    /**
     * 书籍列表
     * @return
     */
    @GetMapping(value = "/book/search/{name}")
    @ApiOperation(value = "查询包含指定名称书籍", notes = "查询包含指定名称书籍", code = 200, produces = "application/json")
    public ResponseBody<List<Books>> listByName(@PathVariable("name") String name) {
        List<Books> list = bookService.queryBookByName(name);
        return new ResponseBody<>(list);
    }

    /**
     * 查询指定id的数据
     * @param id
     * @return
     */
    @GetMapping(value = "/book/{id}")
    @ApiOperation(value = "查询指定ID的书籍", notes = "书籍ID", code = 200, produces = "application/json")
    public ResponseBody<Books> queryBookById(@PathVariable("id") int id) {
        Books book =  bookService.queryBookById(id);
        return new ResponseBody<>(book);
    }

    /**
     * 添加书籍
     * @param books 书籍数据
     * @return
     */
    @PostMapping(value = "/book")
    @ApiOperation(value = "添加书籍", notes = "添加书籍", code = 200, produces = "application/json")
    public ResponseBody addBook(Books books) {
        int id = bookService.addBook(books);
        return new ResponseBody<>(id);
    }
    /**
     * 删除书籍
     * @param id 书籍id
     * @return
     */
    @DeleteMapping(value = "/book/{id}")
    @ApiOperation(value = "删除书籍", notes = "删除指定ID的书籍", code = 200, produces = "application/json")
    public ResponseBody deleteBook(@PathVariable("id") int id) {
        int deleteId = bookService.deleteBookById(id);
        return new ResponseBody<>(deleteId);
    }
    /**
     * 更新书籍
     * @param books 书籍数据
     * @return
     */
    @PutMapping(value = "/book")
    @ApiOperation(value = "更新书籍", notes = "更新书籍信息", code = 200, produces = "application/json")
    public ResponseBody updateBook(Books books) {
        int id = bookService.updateBook(books);
        return new ResponseBody<>(id);
    }
}
