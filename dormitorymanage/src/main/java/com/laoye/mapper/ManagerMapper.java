package com.laoye.mapper;

import com.laoye.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    List<Manager> findAllManager();

}
