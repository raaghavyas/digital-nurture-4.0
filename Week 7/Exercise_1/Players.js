import {players} from './AllPlayers'
import OddPlayers from './OddPlayers';
import EvenPlayers from './EvenPlayers'
import Scorebelow70 from './Scorebelow70';
import ListofPlayers from "./ListofPlayers";
import IndianTeam from './IndianPlayers'
const Players = () => {

  var flag = true;
  if (flag === true) {
    return (
      <div>
        <h1> List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1> List of Players having Scores Less than 70 </h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <h1> Indian Team </h1>
          <h1> Odd Players </h1>
          {OddPlayers(IndianTeam)}
          <hr />
          <h1> Even Players</h1>
          {EvenPlayers(IndianTeam)}
        </div>
        <hr />
        <div>
          <h1> List of Indian Players Merged:</h1>
          <ListofPlayers IndianPlayers={IndianTeam} />
        </div>
      </div>
    );
  }
};

export default Players;
