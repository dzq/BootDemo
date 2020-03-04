package com.dzq.bootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("书籍对象")
public class Books implements Serializable {

    @ApiModelProperty("书籍ID")
    private int bookID;
    @ApiModelProperty("书籍名称")
    private String bookName;
    @ApiModelProperty("书籍数量")
    private int bookCounts;
    @ApiModelProperty("书籍详细信息")
    private String detail;

}
