package com.laoye.service;

import com.laoye.pojo.Notice;

import java.util.List;

public interface INoticeService {
    List<Notice> findAllNotices();
    Notice findNoticeById(Integer tid);
    void delNoticeById(Integer tid);
    void updateNotice(Notice notice);
    void addNotice(Notice notice);
}
