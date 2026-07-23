import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  const isOngoing = cohort.status && cohort.status.toLowerCase() === 'ongoing';
  const h3Style = {
    color: isOngoing ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{cohort.code} - {cohort.program}</h3>
      <dl>
        <dt>Cohort Code:</dt>
        <dd>{cohort.code}</dd>
        <dt>Program Name:</dt>
        <dd>{cohort.program}</dd>
        <dt>Status:</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date:</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
