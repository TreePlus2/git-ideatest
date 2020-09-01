package com.laoye.service.impl;

import com.laoye.mapper.ManagerMapper;
import com.laoye.pojo.Manager;
import com.laoye.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements IManagerService{
    @Autowired
    private ManagerMapper manager;
    @Override
    public List<Manager> findAllManager() {
        return manager.findAllManager();
    }
}
