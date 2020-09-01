package com.laoye.service.impl;

import com.laoye.mapper.NoticeMapper;
import com.laoye.pojo.Notice;
import com.laoye.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("INoticeService")
public class NoticeServiceImpl implements INoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> findAllNotices() {
        return noticeMapper.findAllNotices();
    }

    @Override
    public Notice findNoticeById(Integer tid) {
        return noticeMapper.findNoticeById(tid);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    @Override
    public void delNoticeById(Integer tid) {
        noticeMapper.delNoticeById(tid);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }
}
