package com.laoye.service.impl;

import com.laoye.mapper.LoginMapper;
import com.laoye.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ILoginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String checkStuLogin(Integer sid, String password) {
        return loginMapper.checkStuLogin(sid,password);
    }

    @Override
    public String checkAdminLogin(Integer mid, String password) {
        return loginMapper.checkAdminLogin(mid,password);
    }

//    public String checkLogin(Integer sid, String password) {
//        return studentMapper.checkLogin(sid,password);
//    }
}
