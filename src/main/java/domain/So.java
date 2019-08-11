package domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class So implements Serializable {
    private Integer id;

    private String orderNum;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    private Integer count;


}