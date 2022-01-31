import React, { useEffect, useState } from "react";
import axios from 'axios';
import './styles.css';
import { RecordsResponse } from "./types";
import { formatDate } from './helpers';
import Pagination from "./Pagination";
import { Link } from "react-router-dom";
import { BASE_URL } from "../../utils/requests";

function Records() {

    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();

    const [activePage, setActivePage] = useState(0);

    const handlePageChange = (index: number) => {
        setActivePage(index);
    }

    useEffect(() => {
        axios.get(`${BASE_URL}/records?page=${activePage}`)
            .then(response => setRecordsResponse(response.data));
    }, [activePage]);


    return (
        <div className="page-container">
            <div className="filters-container records-actions">
                <Link to="charts">
                    <button className="action-filters"> VER GRÁFICO </button>
                </Link>
            </div>
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
                    {recordsResponse?.content.map(record => (
                        <tr key = {record.id}>
                            <td>{formatDate(record.moment)}</td>
                            <td>{record.name}</td>
                            <td>{record.age}</td>
                            <td className="text-secondary">{record.gamePlatform}</td>
                            <td>{record.genreName}</td>
                            <td className="text-primary">{record.gameTitle}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
                <Pagination 
                activePage={activePage} 
                goToPage={handlePageChange}
                totalPages={recordsResponse?.totalPages}
                />
        </div>

    );
}

export default Records;