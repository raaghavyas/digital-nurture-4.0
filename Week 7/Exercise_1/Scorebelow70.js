const Scorebelow70 = ({players}) => {
    const player70 = players.filter(p => p.score <= 70);

    return (
    <>
      {player70.map(player => (
        <li key={player.name}>
          Mr.{player.name}  <span>{player.score}</span>
        </li>
      ))}
    </>
  );
};

export default Scorebelow70
