// src/Posts.js
import React, { Component } from 'react';
import Post from './Post'; // This is your data class, not a component

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const postObjects = data.map(p => new Post(p.id, p.title, p.body));
        this.setState({ posts: postObjects });
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
        this.setState({ hasError: true });
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('An error occurred while rendering Posts.');
    this.setState({ hasError: true });
  }

  render() {
    const { posts, hasError } = this.state;

    if (hasError) {
      return <h2>Error loading posts.</h2>;
    }

    return (
      <div>
        <h2>Blog Posts</h2>
        {posts.map(post => (
          <div key={post.id} className="post">
            <h3>{post.id}. {post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;