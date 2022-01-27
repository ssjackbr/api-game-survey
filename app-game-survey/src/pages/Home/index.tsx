import React from "react";
import './styles.css';
import { ReactComponent as ArrowIcon } from '../../assets/arrow.svg';
import { ReactComponent as GameImage } from '../../assets/gamer.svg';

function Home() {
    return (
        <div className="home-container">
            <div className="home-text">
            <h1 className="home-text-title">
                Ranking dos jogos mais avaliados
            </h1>
            <h3 className="home-text-subtitle">
                Saiba quais são os títulos mais escolhidos pelos participantes
            </h3>
            <div className="home-actions">
                <button className="home-btn">
                QUERO SABER QUAIS SÃO
                </button>
                <div className="home-btn-icon">
                    <ArrowIcon />
                </div>
            </div>
          </div>
          <GameImage className="home-image"/>
        </div>
    );

}
export default Home;