package com.laoye.controller;

import com.laoye.pojo.Student;
import com.laoye.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/stus")
    public String getStuList(Model model){
        //List<Student> students = studentService.findAllStu((index - 1)*3);
        List<Student> students = studentService.findAllStu();
        model.addAttribute("stus",students);
        return "stus/list.html";
    }

    @GetMapping("/stu")
    public String toAddPage(){
        return "stus/add.html";
    }

    @PostMapping("/stu")
    public String addStu(Student student){
        System.out.println("新增student信息1"+student);
        studentService.addStu(student);
        return "redirect:/stus";
    }

    @GetMapping("/stu/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
        Student student = studentService.findStuById(id);
        model.addAttribute("stu",student);
        return ("stus/update.html");
    }

    @PostMapping("/updateStu")
    public String updateStu(Student student){
        studentService.updateStu(student);
        return "redirect:/stus";
    }

    @GetMapping("/delStu/{id}")
    public String delStu(@PathVariable("id") Integer id){
        studentService.delStuById(id);
        return ("redirect:/stus");
    }

    @GetMapping("/search")
    public String findLikely(@RequestParam("sid") Integer id,Model model){
        List<Student> students = studentService.findLikely(id);
       /* for (Student student : students) {
            System.out.println(student);
        }*/
        model.addAttribute("stus",students);
        return "stus/list.html";
    }
}
