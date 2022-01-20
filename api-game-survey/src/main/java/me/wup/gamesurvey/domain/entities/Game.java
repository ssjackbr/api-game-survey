package me.wup.gamesurvey.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.wup.gamesurvey.domain.enums.PlataformEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "platform")
    private PlataformEnum platform;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<Record> records = new ArrayList<>();
}
