import React from "react";
import './styles.css';



function Records(){
    return(

        <div className="page-container">
            <table className="records-table" cellPadding={0} cellSpacing={0}>
                <thead>
                    <tr>
                        <th>INSTANTE</th>
                        <th>NOME</th>
                        <th>IDADE</th>
                        <th>PLATAFORMA</th>
                        <th>GÊNERO</th>
                        <th>GAME</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>

    );
}

export default Records;