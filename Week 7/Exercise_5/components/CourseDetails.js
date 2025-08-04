const courses = [
  { name: "Full Stack Web Development", instructor: "Jayaram" },
  { name: "React for Beginners", instructor: "Nandhini" },
  { name: "Java Spring Boot", instructor: "Sundar Raj" }
];

const CourseDetails = () => (
  <div>
    <h2>Course List</h2>
    <ul>
      {courses.map((course, index) => (
        <li key={index}>
          <strong>{course.name}</strong> — Instructor: {course.instructor}
        </li>
      ))}
    </ul>
  </div>
);

export default CourseDetails;