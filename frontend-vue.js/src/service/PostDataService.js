import axios from "axios";

const POST_API_URL = "http://localhost:8080/post";

class PostDataService {
  retrieveAllPosts() {
    return axios.get(`${POST_API_URL}/`);
  }

  retrievePost(id) {
    return axios.get(`${POST_API_URL}/${id}`);
  }

  deletePost(id) {
    return axios.delete(`${POST_API_URL}/${id}`);
  }

  updatePost(id, post) {
    return axios.put(`${POST_API_URL}/${id}`, post);
  }

  createPost(post) {
    return axios.post(`${POST_API_URL}/post`, post);
  }
}

export default new PostDataService();
