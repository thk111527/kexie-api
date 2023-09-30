package com.mystore.mystoreapidev.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("second")
public class Second {

    private Integer id;
    private String name;
    private String department;
    private String startdate;
    private String start;
    private String end;
    private String location;
    private String tel;

    public Second(Integer id, String name, String department, String startDate,
                  String start, String end, String location,String tel)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.startdate = startDate;
        this.start = start;
        this.end = end;
        this.location = location;
        this.tel = tel;
    }
}
