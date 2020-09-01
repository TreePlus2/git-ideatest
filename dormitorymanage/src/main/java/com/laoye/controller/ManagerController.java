package com.laoye.controller;

import com.laoye.pojo.Manager;
import com.laoye.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private IManagerService managerService;

   @GetMapping("/managers")
    public String getManagerList(Model model){
        List<Manager> managers = managerService.findAllManager();
        model.addAttribute("managers",managers);
        return "manager/adminList.html";
    }

    @GetMapping("/stuManagers")
    public String getStuManagerList(Model model){
        List<Manager> managers = managerService.findAllManager();
        model.addAttribute("managers",managers);
        return "manager/stuAdminList.html";
    }
}
