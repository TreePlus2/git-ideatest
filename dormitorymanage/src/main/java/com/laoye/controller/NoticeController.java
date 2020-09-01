package com.laoye.controller;

import com.laoye.pojo.Notice;
import com.laoye.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private INoticeService noticeService;
    @GetMapping("/adminHome")
    public String AdminNoticeHomePage(Model model){
        List<Notice> notices = noticeService.findAllNotices();
        model.addAttribute("notices",notices);
        return "adminHome.html";
    }
    @GetMapping("/stuHome")
    public String StuHomePage(Model model){
        List<Notice> notices = noticeService.findAllNotices();
        model.addAttribute("notices",notices);
        return "stuHome.html";
    }

    @GetMapping("/findNotice/{id}")
    public String toSingleNoticePage(@PathVariable("id") Integer id,Model model){
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice",notice);
        return ("notice/notice.html");
    }

    @GetMapping("/notice")
    public String toAddPage(){
        return "notice/addNotice.html";
    }

    @PostMapping("/notice")
    public String addNotice(Notice notice){
        System.out.println("新增student信息1"+notice);
        noticeService.addNotice(notice);
        return "redirect:/adminHome";
    }

    @GetMapping("/notice/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model){
        Notice notice = noticeService.findNoticeById(id);
        model.addAttribute("notice",notice);
        return ("notice/updateNotice.html");
    }

    @PostMapping("/updateNotice")
    public String updateNotice(Notice notice){
        noticeService.updateNotice(notice);
        System.out.println(notice);
        return "redirect:/adminHome";
    }

    @GetMapping("/delNotice/{id}")
    public String delNotice(@PathVariable("id") Integer tid){
        noticeService.delNoticeById(tid);
        return ("redirect:/adminHome");
    }

}
