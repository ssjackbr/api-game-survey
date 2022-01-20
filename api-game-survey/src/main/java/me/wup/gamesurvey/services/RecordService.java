package me.wup.gamesurvey.services;

import lombok.Builder;
import me.wup.gamesurvey.domain.dto.GameDto;
import me.wup.gamesurvey.domain.dto.RecordDto;
import me.wup.gamesurvey.domain.dto.RecordInsertSurveyDto;
import me.wup.gamesurvey.domain.entities.Game;
import me.wup.gamesurvey.domain.entities.Record;
import me.wup.gamesurvey.repositories.GameRepository;
import me.wup.gamesurvey.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDto saveGameSurvey(RecordInsertSurveyDto dto) {
        Record record = new Record();
        return new RecordDto(recordRepository.save(copyDtoToEntity(dto, record)));
    }

    public Record copyDtoToEntity (RecordInsertSurveyDto dto, Record record) {

        record.setName(dto.getName());
        record.setAge(dto.getAge());
        record.setMoment(Instant.now());

        Game game = gameRepository.getOne(dto.getGameId());
        record.setGame(game);
        return record;
    }
}