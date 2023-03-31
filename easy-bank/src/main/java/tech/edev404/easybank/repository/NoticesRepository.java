package tech.edev404.easybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.edev404.easybank.model.entity.Notice;

public interface NoticesRepository extends JpaRepository<Notice, Integer> {

    @Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notice> findAllActiveNotices();
    
}
