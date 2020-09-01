package com.laoye.controller;

import com.laoye.mapper.LoginMapper;
import com.laoye.pojo.Student;
import com.laoye.service.ILoginService;
import com.laoye.service.IManagerService;
import com.laoye.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    public static Integer sid;
    @Autowired
    private ILoginService loginService;
    @Autowired
    private IStudentService studentService;
    @RequestMapping("/admin/login")
    public String login(
            @RequestParam("mid") Integer id,
            @RequestParam("password") String password,
            @RequestParam("sign") Integer sign,
            Model model, HttpSession session) {
        sid = id;
        if (sign == 0){//管理员登陆
            String name = loginService.checkAdminLogin(id, password);
            if (name != null) {
                session.setAttribute("userName", name);
                return "redirect:/adminHome";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "index.html";
            }
        }
        else if (sign == 1){//学生登陆
            String name = loginService.checkStuLogin(id, password);
            if (name != null) {
                session.setAttribute("userName", name);
                return "redirect:/toSingleStu";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "index.html";
            }
        }
        else return "index.html";
    }

    @GetMapping("toSingleStu")
    public String toSingleStu(Model model){
        Student student = studentService.findStuById(sid);
        model.addAttribute("stu",student);
        return ("stus/singleStu");
    }

    @RequestMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
