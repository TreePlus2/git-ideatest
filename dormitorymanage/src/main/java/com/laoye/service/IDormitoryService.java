package com.laoye.service;

import com.laoye.pojo.Dormitory;

import java.util.List;

public interface IDormitoryService {
    List<Dormitory> findAllDormitories();
    List<Dormitory> findAllStudentsByDormitory(Integer did);
    List<Dormitory> adminFindAllStudentsByDormitory();
}
