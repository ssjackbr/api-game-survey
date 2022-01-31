package me.wup.gamesurvey.controllers;

import me.wup.gamesurvey.domain.dto.RecordDto;
import me.wup.gamesurvey.domain.dto.RecordInsertSurveyDto;
import me.wup.gamesurvey.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    @Autowired
    private RecordService recordService;


    @PostMapping()
    public ResponseEntity<RecordDto> findAllGames(@RequestBody RecordInsertSurveyDto dto) {
        RecordDto newDto = recordService.saveGameSurvey(dto);
        return ResponseEntity.ok().body(newDto);
    }

    @GetMapping ()
    public ResponseEntity<Page<RecordDto>> findAll(Pageable pageable,
                                                   @RequestParam(value = "min", required = false) String min,
                                                   @RequestParam(value = "max", required = false) String max) {
        Page<RecordDto> list = recordService.findAllRecords(pageable, min, max);
        return ResponseEntity.ok().body(list);
    }
}
