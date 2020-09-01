package com.laoye.service.impl;

import com.laoye.mapper.StudentMapper;
import com.laoye.pojo.Student;
import com.laoye.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStu() {
        return studentMapper.findAllStu();
    }

    @Override
    public Student findStuById(Integer id) {
        return studentMapper.findStuById(id);
    }

    @Override
    public List<Student> findLikely(Integer id) {
        return studentMapper.findLikely(id);
    }

    @Override
    public void addStu(Student student) {
        studentMapper.addStu(student);
    }

    @Override
    public void updateStu(Student student) {
        studentMapper.updateStu(student);
    }

    @Override
    public void delStuById(Integer id) {
        studentMapper.delStuById(id);
    }

    @Override
    public Integer findDidBySid(Integer sid) {
        return studentMapper.findDidBySid(sid);
    }

    @Override
    public Integer countBeds(Integer did) {
        return studentMapper.countBeds(did);
    }
}
