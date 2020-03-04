package com.dzq.bootdemo.vo;

import com.dzq.bootdemo.pojo.Books;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("书籍列表返回对象")
public class BookListResponse extends  ResponseBody {
    @ApiModelProperty("书籍列表数据")
    private List<Books> data;
}
