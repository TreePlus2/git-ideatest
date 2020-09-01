package com.laoye.controller;

import com.laoye.pojo.Dormitory;
import com.laoye.pojo.Notice;
import com.laoye.pojo.Repair;
import com.laoye.pojo.Student;
import com.laoye.service.IRepairsService;
import com.laoye.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RepairsController {
    @Autowired
    private IRepairsService repairsService;
    @Autowired
    private IStudentService studentService;
    @RequestMapping("/adminRepairs")
    public String adminRepair(Model model){

        List<Dormitory> dormitories = repairsService.adminFindRepairByDid();
        model.addAttribute("dormitories",dormitories);
        return "repairs/adminRepairs.html";
    }

    @RequestMapping("/stuRepairs")
    public String StuRepair(Model model){
        Integer sid = LoginController.sid;
        Integer did = studentService.findDidBySid(sid);
        System.out.println("did:"+did);
        List<Dormitory> dormitories = repairsService.findRepairByDid(did);

        model.addAttribute("dormitories",dormitories);
        return "repairs/stuRepairs.html";
    }

    @GetMapping("/adminRepair/{id}")
    public String toUpdatePage(@PathVariable("id") Integer rid, Model model){
        Repair repair = repairsService.findRepairById(rid);
        model.addAttribute("repair",repair);
        return ("repairs/updateRepair.html");
    }

    @PostMapping("/updateRepair")
    public String updateRepair(Repair repair){
        repairsService.updateRepair(repair);
        System.out.println(repair);
        return "redirect:/adminRepairs";
    }

    @GetMapping("/stuRepair/{id}")
    public String toStuUpdatePage(@PathVariable("id") Integer rid, Model model){
        Repair repair = repairsService.findRepairById(rid);
        model.addAttribute("repair",repair);
        return ("repairs/stuUpdateRepair.html");
    }

    @GetMapping("/stuFindRepair/{id}")
    public String stuCheckRepair(@PathVariable("id") Integer rid, Model model){
        Repair repair = repairsService.findRepairById(rid);
        model.addAttribute("repair",repair);
        return ("repairs/checkStuRepair.html");
    }

    @PostMapping("/stuUpdateRepair")
    public String stuUpdateRepair(Repair repair){
        repairsService.stuUpdateRepair(repair);
        System.out.println(repair);
        return "redirect:/stuRepairs";
    }

    @GetMapping("/delRepair/{rid}")
    public String delRepair(@PathVariable("rid") Integer rid){
        repairsService.delRepairById(rid);
        return ("redirect:/adminRepairs");
    }
    @GetMapping("/addRepair")
    public String toAddRepair(){
        return "repairs/addRepair.html";
    }

    @PostMapping("/addRepair")
    public String addStuRepair(Repair repair){
        System.out.println("新增student信息1"+repair);
        repairsService.addRepair(repair);
        return "redirect:/stuRepairs";
    }
}
