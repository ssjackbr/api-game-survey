package me.wup.gamesurvey.services;

import me.wup.gamesurvey.domain.dto.GameDto;
import me.wup.gamesurvey.domain.entities.Game;
import me.wup.gamesurvey.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional
    public List<GameDto> findAllGames(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameDto(x)).collect(Collectors.toList());
    }
}
