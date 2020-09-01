package com.laoye.service.impl;

import com.laoye.mapper.DormitoryMapper;
import com.laoye.pojo.Dormitory;
import com.laoye.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IDormitoryService")
public class DormitoryServiceImpl implements IDormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> findAllDormitories() {
        return dormitoryMapper.findAllDormitories();
    }

    @Override
    public List<Dormitory> findAllStudentsByDormitory(Integer did) {
        return dormitoryMapper.findAllStudentsByDormitory(did);
    }

    @Override
    public List<Dormitory> adminFindAllStudentsByDormitory() {
        return dormitoryMapper.adminFindAllStudentsByDormitory();
    }
}
