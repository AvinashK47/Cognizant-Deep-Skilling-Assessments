import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore Name="John Doe" School="XYZ High School" Total={284} goal={3} />
    </div>
  );
}

export default App;
