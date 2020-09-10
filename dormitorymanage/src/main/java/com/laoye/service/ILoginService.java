package com.laoye.service;

import org.apache.ibatis.annotations.Param;

public interface ILoginService {
   /* String checkStuLogin(@Param("sid") Integer sid, @Param("password") String password);
    String checkAdminLogin(@Param("mid") Integer mid,@Param("password") String password);*/
    String checkStuLogin( Integer sid, String password);
    String checkAdminLogin( Integer mid, String password);
}
