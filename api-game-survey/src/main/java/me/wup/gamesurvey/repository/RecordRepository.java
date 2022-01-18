package me.wup.gamesurvey.repository;

import me.wup.gamesurvey.domain.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository <Record, Long> {
}
