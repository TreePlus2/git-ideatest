package com.laoye.mapper;

import com.laoye.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> findAllStu();

    Student findStuById(Integer id);

    List<Student> findLikely(Integer id);

    void addStu(Student student);

    void updateStu(Student student);

    void delStuById(Integer id);

    Integer findDidBySid(Integer sid);

    Integer countBeds(Integer did);
}
