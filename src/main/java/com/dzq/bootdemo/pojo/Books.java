package com.dzq.bootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("书籍对象")
@Table(name = "books")
public class Books implements Serializable {

    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @ApiModelProperty("书籍ID")
    private Integer id;
    @ApiModelProperty("书籍名称")
    private String name;
    @ApiModelProperty("书籍数量")
    private Integer num;
    @ApiModelProperty("书籍详细信息")
    private String detail;

}
