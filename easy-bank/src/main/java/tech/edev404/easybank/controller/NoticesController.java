package tech.edev404.easybank.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Notice;
import tech.edev404.easybank.service.NoticesService;

@RestController
@RequestMapping("api/v1/notices")
@RequiredArgsConstructor
public class NoticesController {
    
    private final NoticesService noticesService;

    @GetMapping
    public ResponseEntity<List<Notice>> handleGetNoticesDetails(){
        List<Notice> notices = noticesService.findAllActiveNotices();
        if (notices != null ) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            return null;
        }
    }
}
