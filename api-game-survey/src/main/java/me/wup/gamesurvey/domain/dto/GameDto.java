package me.wup.gamesurvey.domain.dto;

import lombok.*;
import me.wup.gamesurvey.domain.entities.Game;
import me.wup.gamesurvey.domain.entities.Genre;
import me.wup.gamesurvey.domain.enums.PlataformEnum;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder(access = AccessLevel.PUBLIC)
public class GameDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private PlataformEnum platform;

    public  GameDto (Game game) {
        id = game.getId();
        title = game.getTitle();
        platform = game.getPlatform();
    }
}
