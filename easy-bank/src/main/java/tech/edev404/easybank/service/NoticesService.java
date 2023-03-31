package tech.edev404.easybank.service;

import java.util.List;

import tech.edev404.easybank.model.entity.Notice;

public interface NoticesService {

    List<Notice> findAllActiveNotices();
    
}
