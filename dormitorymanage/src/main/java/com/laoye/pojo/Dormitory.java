package com.laoye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dormitory implements Serializable {
    private Integer did;
    private String dName;
    private Integer bid;
    private Integer beds;
    private List<Student> students;
    private List<Repair> repairs;
}
