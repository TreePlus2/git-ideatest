package com.laoye.mapper;

import com.laoye.pojo.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormitoryMapper {
    List<Dormitory> findAllDormitories();

    List<Dormitory> findAllStudentsByDormitory(Integer did);

    List<Dormitory> adminFindAllStudentsByDormitory();
}
