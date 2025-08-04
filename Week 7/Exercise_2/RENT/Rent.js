const Rent = ({ list }) => {
  return (
    <>
      <h1>Office Space, At Affordable Range</h1>

      {list.map((item) => (
        <div key={item.id}>
          <img src={item.image} alt={item.name} />

          <h3>Name: {item.name}</h3>

          <h3 style={{ color: item.rent >= 60000 ? 'green' : 'blue' }}>
            Rs. {item.rent}
          </h3>

          <h4>Address: {'Chennai'}</h4>
        </div>
      ))}
    </>
  );
};

export default Rent;