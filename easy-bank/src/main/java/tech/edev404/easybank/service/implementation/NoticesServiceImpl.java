package tech.edev404.easybank.service.implementation;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Notice;
import tech.edev404.easybank.repository.NoticesRepository;
import tech.edev404.easybank.service.NoticesService;

@Service
@Primary
@RequiredArgsConstructor
public class NoticesServiceImpl implements NoticesService {

    private final NoticesRepository noticesRepository;
    
    @Override
    public List<Notice> findAllActiveNotices() {
        return noticesRepository.findAllActiveNotices();
    }
    
}
