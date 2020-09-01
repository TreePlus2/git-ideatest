package com.laoye.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer tid;
    private String title;
    private Integer mid;
    private Manager manager;
    private String content;
    private Date date;
}
