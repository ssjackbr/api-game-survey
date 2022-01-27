import React from "react";
import './styles.css';
import { ReactComponent as Logo } from '../../assets/logo.svg';
import { ReactComponent as GithubIcon } from '../../assets/github.svg';

function Header() {

    return (
        <header className="main-header">
            <Logo />

            <div className="logo-text">
                <span className="logo-text-1">Game </span>
                <span className="logo-text-2">Survey™ </span>
            </div>

             <div className="logo-text-3">
                <a className="a" href="https://github.com/ssjackbr/api-game-survey" target="_blank" rel="noreferrer">
                    <GithubIcon />
                    <span className="git-contact"> /ssjackbr </span>
                </a>
            
            </div>
            
            
        </header>
    );
}

export default Header;