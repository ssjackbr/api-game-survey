package me.wup.gamesurvey.domain.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RecordInsertSurveyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Long gameId;
}
