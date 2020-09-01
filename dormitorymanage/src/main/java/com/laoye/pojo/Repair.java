package com.laoye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repair {
    private Integer did;
    private Integer rid;
    private String info;
    private String state;
    private Date date;
}
