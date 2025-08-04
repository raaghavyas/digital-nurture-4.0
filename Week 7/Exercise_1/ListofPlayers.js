const ListofPlayers = ({ players }) => {
  return (
    <>
      {players.map((items) => (
        <div key={items.name}>
          <li>Mr. {items.name} <span>{items.score}</span></li>
        </div>
      ))}
    </>
  );
};
export default ListofPlayers;