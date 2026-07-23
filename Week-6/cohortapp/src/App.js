import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    {
      code: 'INTADM21FSE001',
      program: 'Java Full Stack Engineer',
      status: 'Ongoing',
      startDate: '2026-06-01'
    },
    {
      code: 'INTADM21FSE002',
      program: 'Cloud Native Engineer',
      status: 'Completed',
      startDate: '2026-01-15'
    }
  ];

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h2>Cognizant Academy Cohorts Dashboard</h2>
      {cohorts.map(c => (
        <CohortDetails key={c.code} cohort={c} />
      ))}
    </div>
  );
}

export default App;
