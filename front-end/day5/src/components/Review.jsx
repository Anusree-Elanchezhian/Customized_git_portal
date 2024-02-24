import { useState } from 'react';
import '../assets/css/review.css';
import Navbar from "./Navbar";
import Sidebar from "./Sidebar";
function Review() {
  // Sample previous reviews data
  const [reviews, setReviews] = useState([
    { id: 1, user: 'User1', rating: 4, comment: 'Great product!' },
    { id: 2, user: 'User2', rating: 5, comment: 'Excellent service!' },
    // Add more previous reviews as needed
  ]);

  const [userReview, setUserReview] = useState({
    user: '',
    rating: '',
    comment: ''
  });

  const handleInputChange = (e) => {
    setUserReview({ ...userReview, [e.target.name]: e.target.value });
  };

  const handleSubmitReview = (e) => {
    e.preventDefault();
    // Add the new review to the reviews state
    setReviews([...reviews, { ...userReview, id: reviews.length + 1 }]);
    // Clear the form fields after submitting
    setUserReview({ user: '', rating: '', comment: '' });
  };

  return (
    <div className="home1">
      <Navbar />
      <div className="sidebar-contentre">
        <Sidebar />
    <div className="review-container" style={{marginTop:'5%', paddingLeft:'20%'}}>
      <h2>Customer Reviews</h2>
      <div className="previous-reviews">
        <h3>Previous Reviews:</h3>
        <ul>
          {reviews.map((review) => (
            <li key={review.id}>
              <p><strong>{review.user}</strong></p>
              <p>Rating: {review.rating}</p>
              <p>{review.comment}</p>
            </li>
          ))}
        </ul>
      </div>
      <div className="submit-review">
        <h3>Submit Your Review:</h3>
        <form onSubmit={handleSubmitReview}>
          <input type="text" name="user" placeholder="Your Name" value={userReview.user} onChange={handleInputChange} required />
          <input type="number" name="rating" placeholder="Rating (1-5)" min="1" max="5" value={userReview.rating} onChange={handleInputChange} required />
          <textarea name="comment" placeholder="Your Review" value={userReview.comment} onChange={handleInputChange} required />
          <button type="submit">Submit Review</button>
        </form>
      </div>
      </div>
      </div>
    </div>
  );
}

export default Review;
