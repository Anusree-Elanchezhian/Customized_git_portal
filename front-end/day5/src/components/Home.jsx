import Navbar from "./Navbar";
import Sidebar from "./Sidebar";
import '../assets/css/home.css';
function Home() {
  return (
    <div className="home">
      <Navbar />
      <div className="sidebar-content">
        <Sidebar />
        <div className="cardSection">
          <div className="card">
            <div className="card-body">
              <h2 className="desc">About Us</h2>
              <p className="desc">ZoneG is your one-stop destination for all kinds of gifts for every occasion. Whether you're celebrating a birthday, anniversary, wedding, or any special moment in life, ZoneG has a wide range of gifts to suit every taste and budget. From luxurious gifts to thoughtful tokens of appreciation, ZoneG ensures that your gifting experience is seamless and memorable.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
