package com.laoye.service;

import com.laoye.pojo.Dormitory;
import com.laoye.pojo.Repair;

import java.util.List;

public interface IRepairsService {
    List<Repair> findAllRepairs();
    Repair findRepairById(Integer rid);
    void delRepairById(Integer rid);
    void updateRepair(Repair repair);
    void stuUpdateRepair(Repair repair);
    void addRepair(Repair repair);
    List<Dormitory> findRepairByDid(Integer did);
    List<Dormitory> adminFindRepairByDid();

}
