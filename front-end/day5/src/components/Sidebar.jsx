import { Link } from 'react-router-dom';
import '../assets/css/sidebar.css';
import logo from  "../assets/images/logo.png";
const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="let">
        <div>
      <img src={logo} width="70px"/>
      </div>
      <div className='na'>
      <p>ZoneG</p>
      </div>
      </div>
      <ul className="sidebar-links">
        <li>
          <Link to="/birthday">Birthday</Link>
        </li>
        <li>
          <Link to="/anniversary">Anniversary</Link>
        </li>
        <li>
          <Link to="/occastinal">Occasions</Link>
        </li>
        <li>
          <Link to="/customized">Customized</Link>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;