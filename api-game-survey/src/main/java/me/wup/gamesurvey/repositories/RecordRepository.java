package me.wup.gamesurvey.repositories;

import me.wup.gamesurvey.domain.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository <Record, Long> {

    @Query("SELECT obj FROM Record obj WHERE "
            + "(:min IS NULL OR obj.moment >= :min) AND "
            + "(:max IS NULL OR obj.moment <= :max)")
    Page<Record> findAll(Pageable pageable, Instant min, Instant max);

    @Query("SELECT obj FROM Record obj")
    Page<Record> findAllPageable(Pageable pageable);
}
