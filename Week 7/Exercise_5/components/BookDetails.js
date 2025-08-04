const books = [
  { title: "React in Action", author: "Mark Tielens Thomas" },
  { title: "Learning React", author: "Alex Banks" },
  { title: "Fullstack React", author: "Anthony Accomazzo" }
];

const BookDetails = () => (
  <div>
    <h2>Book List</h2>
    <ul>
      {books.map((book, index) => (
        <li key={index}>
          <strong>{book.title}</strong> by {book.author}
        </li>
      ))}
    </ul>
  </div>
);

export default BookDetails;