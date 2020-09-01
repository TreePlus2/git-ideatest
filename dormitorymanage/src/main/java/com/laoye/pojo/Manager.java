package com.laoye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {
    private Integer mid;
    private Integer bid;
    private String name;
    private Dormitory dormitory;
    private BigInteger tel;
}
