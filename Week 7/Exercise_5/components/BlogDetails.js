const blogs = [
  { topic: "Conditional Rendering in React", author: "Jayaram" },
  { topic: "Understanding React Hooks", author: "Divya" },
  { topic: "State Management in React", author: "Ravi Kumar" }
];

const BlogDetails = () => (
  <div>
    <h2>Blog List</h2>
    <ul>
      {blogs.map((blog, index) => (
        <li key={index}>
          <strong>{blog.topic}</strong> by {blog.author}
        </li>
      ))}
    </ul>
  </div>
);

export default BlogDetails;