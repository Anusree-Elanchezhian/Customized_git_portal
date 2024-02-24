import '../assets/css/contact.css';
import Navbar from "./Navbar";
import Sidebar from "./Sidebar";


function Contact() {
  const handleSubmit = (e) => {
    e.preventDefault();
    // Logic to send email
    console.log('Email sent!');
  };

  return (
    <div className="home1">
      <Navbar />
      <div className="sidebar-contentc">
        <Sidebar />
    <div className="contact-container" style={{marginTop:'80px',paddingLeft:'550px'}}>
      <h2>Contact Us</h2>
      <div className="contact-details">
        <p><strong>Email:</strong> admin@gmail.com</p>
        <p><strong>Phone:</strong> +91 9988776655</p>
        <p><strong>Address:</strong> 2/8, Periyar Street, Peelamadu, Coimbatore</p>
      </div>
      <div className="contact-form">
        <h3>Send Us a Message</h3>
        <form onSubmit={handleSubmit}>
          <input type="text" name="name" placeholder="Your Name" required />
          <input type="email" name="email" placeholder="Your Email" required />
          <textarea name="message" placeholder="Your Message" required></textarea>
          <button type="submit">Send</button>
        </form>
      </div>
    </div>
    </div>
    </div>
  );
}

export default Contact;
