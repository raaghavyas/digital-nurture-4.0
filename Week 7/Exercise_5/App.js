import { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [selected, setSelected] = useState("book");

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <button onClick={() => setSelected("book")}>Book</button>
      <button onClick={() => setSelected("blog")}>Blog</button>
      <button onClick={() => setSelected("course")}>Course</button>

      <hr />

      {/* Method 1: if-else rendering */}
      {(() => {
        if (selected === "book") return <BookDetails />;
        else if (selected === "blog") return <BlogDetails />;
        else if (selected === "course") return <CourseDetails />;
        else return <p>Please select a category</p>;
      })()}

      <hr />

      {/* Method 2: Ternary Operator */}
      {/* <h3>Ternary Check</h3>
      {
        selected === "book"
          ? <BookDetails />
          : selected === "blog"
          ? <BlogDetails />
          : selected === "course"
          ? <CourseDetails />
          : <p>Nothing selected</p>
      }

      <hr /> */}

      {/* Method 3: Switch-case style (Optional) */}
      {/* <h3> Switch-style Mapping</h3>
      {{
        book: <BookDetails />,
        blog: <BlogDetails />,
        course: <CourseDetails />
      }[selected] || <p>Select a view</p>}*/}
    </div> 
  );
}

export default App;