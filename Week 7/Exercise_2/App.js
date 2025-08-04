import {list} from './RENT/rentlist.js';
import Rent from './RENT/Rent.js';

function App() {
  return (
    <div className="App">
      <Rent list = {list}/>
    </div>
  );
}

export default App;