package com.laoye.service;

import com.laoye.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentService {
    //List<Student> findAllStu(Integer page);
    List<Student> findAllStu();

    Student findStuById(Integer sid);

    List<Student> findLikely(Integer sid);

    void addStu(Student student);

    void updateStu(Student student);

    void delStuById(Integer sid);

    Integer findDidBySid(Integer sid);

    Integer countBeds(Integer did);

}
