import React from 'react';
import '../Stylesheets/mystyle.css';

function percentToDecimal(decimal) {
  return (decimal * 100).toFixed(2) + '%';
}

function calcScore(total, goal) {
  if (!goal) return 0;
  return (total / goal).toFixed(2);
}

export const CalculateScore = ({ Name, School, Total, goal }) => {
  const average = calcScore(Total, goal);
  return (
    <div className="formatstyle">
      <h2>Student Details:</h2>
      <div className="Name">
        <b>Name: </b>
        <span>{Name}</span>
      </div>
      <div className="School">
        <b>School: </b>
        <span>{School}</span>
      </div>
      <div className="Total">
        <b>Total: </b>
        <span>{Total}</span>
      </div>
      <div className="Score">
        <b>Score: </b>
        <span>{calcScore(Total, goal)}</span>
      </div>
    </div>
  );
};

export default CalculateScore;
