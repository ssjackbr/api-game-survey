package me.wup.gamesurvey.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import me.wup.gamesurvey.domain.dto.GameDto;
import me.wup.gamesurvey.domain.dto.RecordDto;
import me.wup.gamesurvey.domain.dto.RecordInsertSurveyDto;
import me.wup.gamesurvey.services.GameService;
import me.wup.gamesurvey.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping()
    public ResponseEntity <RecordDto> findAllGames (@RequestBody RecordInsertSurveyDto dto) {
        RecordDto newDto = recordService.saveGameSurvey(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @GetMapping(value = "/all")
    public ResponseEntity <Page<RecordDto>> findAll (Pageable pageable, @RequestParam String min, @RequestParam String max ){

        Instant minDate =  Instant.parse(min);
        Instant maxDate =  Instant.parse(max);
        System.out.println("Data inicial: "+min+" - "+"Data final: "+max);

        Page<RecordDto> list = recordService.findAllRecords(pageable, minDate, maxDate);
        return ResponseEntity.ok().body(list);
    }
}
