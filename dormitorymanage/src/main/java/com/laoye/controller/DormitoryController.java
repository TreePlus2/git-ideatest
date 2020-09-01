package com.laoye.controller;

import com.laoye.pojo.Dormitory;
import com.laoye.pojo.Status;
import com.laoye.pojo.Student;
import com.laoye.service.IDormitoryService;
import com.laoye.service.IStudentService;
import com.laoye.service.impl.DormitoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DormitoryController {
    @Autowired
    private IDormitoryService dormitoryService;

    //IDormitoryService dormitoryService = new DormitoryServiceImpl();
    @Autowired
    private IStudentService studentService;

    @GetMapping("/dormitory")
    String getDormitories(Model model) {
        List<Status> statuses = new ArrayList<>();
        List<Dormitory> dormitories = dormitoryService.findAllDormitories();
        for (Dormitory dormitory : dormitories) {
            Status status = new Status();
            Integer countBeds = studentService.countBeds(dormitory.getDid());
            status.setDid(dormitory.getDid());

            status.setBeds(dormitory.getBeds());

            status.setCurrentBeds(countBeds);

            status.setFreeBeds(dormitory.getBeds() - countBeds);

            statuses.add(status);
            //System.out.println(dormitory);
        }
        for (Status status1 : statuses) {
            System.out.println(status1);
        }
        model.addAttribute("statuses", statuses);
        return "dormitory/dormitoryList.html";
    }

    @GetMapping("/stuDormitory")
    String getStuDormitory(Model model) {
        Integer sid = LoginController.sid;
        Integer did = studentService.findDidBySid(sid);
        List<Dormitory> dormitories = dormitoryService.findAllStudentsByDormitory(did);
       /* for (Dormitory dormitory : dormitories) {
            for (Student student : dormitory.getStudents()) {
                System.out.println(student);
            }
        }*/
        model.addAttribute("dormitories", dormitories);
        return "dormitory/stuDormitoryList.html";
    }

    String getAdminDormitory(Model model){
        List<Dormitory> dormitories = dormitoryService.findAllDormitories();
        for (Dormitory dormitory : dormitories) {
            System.out.println(dormitories);
            for (Student student : dormitory.getStudents()) {
                System.out.println(student);
            }
        }
        return "doemitory";
    }
}
