package me.wup.gamesurvey.domain.dto;

import lombok.*;
import me.wup.gamesurvey.domain.entities.Record;
import me.wup.gamesurvey.domain.enums.PlataformEnum;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RecordDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private PlataformEnum gamePlatform;
    private String genreName;

    public RecordDto (Record record){
        id = record.getId();
        moment = record.getMoment();
        name = record.getName();
        age = record.getAge();
        gameTitle = record.getGame().getTitle();
        gamePlatform = record.getGame().getPlatform();
        genreName = record.getGame().getGenre().getName();
    }
}
