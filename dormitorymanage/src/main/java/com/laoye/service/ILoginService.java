package com.laoye.service;

import org.apache.ibatis.annotations.Param;

public interface ILoginService {
    String checkStuLogin(@Param("id") Integer sid, @Param("password") String password);
    String checkAdminLogin(@Param("sid") Integer sid,@Param("password") String password);
}
