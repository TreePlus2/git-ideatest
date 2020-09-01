package com.laoye.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    String checkStuLogin(Integer sid,String password);
    String checkAdminLogin(Integer sid,String password);
}
