import React from 'react';
import PropTypes from "prop-types";
import { Button } from 'react-bootstrap';
import './ResultGrid.css';

class ResultGrid extends React.Component {
  toggleSelectAll() {
    let { onSelectAll, onUnSelectAll, grid: { results } } = this.props;
    if (this.props.allSelected) {
      onUnSelectAll(results);
    } else {
      onSelectAll(results);
    }
  }

  render() {
    let { onClickRow, onSelectRow, rowSelects, allSelected, onDeleteRow, surveyId } = this.props;
    let { columns, results } = this.props.grid;
    let anySelected = Object.keys(rowSelects).some(k => rowSelects[k]);
    

    return (
        <div className="ResultGrid">
          <div className="grid-wrapper">
            <table className="table table-condensed table-hover table-bordered">
              <thead>
              <tr>
                <th className="index">#</th>
                {columns.map(col => {
                  return <th key={col.id}>{col.displayName}</th>
                })}
              </tr>
              </thead>
              <tbody>
              {results.map((result, index) => {
                return (
                    <tr
                        key={result._id}
                        onClick={() => onClickRow(result, index)}
                    >
                      <td className="index">{index + 1}</td>
                      {columns.map((col, index) => {
                        return <td key={index}>{result[col.columnName]}</td>
                      })}
                    </tr>
                )
              })}
              </tbody>
            </table>
          </div>
        </div>
    );
  }
}

ResultGrid.propTypes = {
  columns: PropTypes.array,
  results: PropTypes.array
};

export default ResultGrid;