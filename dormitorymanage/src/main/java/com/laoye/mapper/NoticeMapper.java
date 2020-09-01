package com.laoye.mapper;

import com.laoye.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    List<Notice> findAllNotices();
    Notice findNoticeById(Integer tid);
    void delNoticeById(Integer tid);
    void updateNotice(Notice notice);
    void addNotice(Notice notice);
}
