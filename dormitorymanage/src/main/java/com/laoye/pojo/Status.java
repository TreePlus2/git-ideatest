package com.laoye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Integer did;
    private Integer beds;
    private Integer currentBeds;
    private Integer freeBeds;
}
