import { useState } from 'react';
import '../assets/css/signup.css';
import { Link } from 'react-router-dom';
import { FaUser, FaPhone, FaCalendarAlt, FaEnvelope, FaLock } from 'react-icons/fa'; // Importing icons from Font Awesome

function Signup() {
  const [name, setName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [dob, setDOB] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [isValid, setIsValid] = useState(false);

  const handleCreateAccount = () => {
    if (!name || !phoneNumber || !dob || !email || !password) {
      setErrorMessage('Please fill in all fields.');
    } else if (!/^\d+$/.test(phoneNumber)) {
      setErrorMessage('Phone number should contain only numbers.');
    } else if (phoneNumber.length !== 10) {
      setErrorMessage('Phone number must be 10 digits long.');
    } else {
      setErrorMessage('');
      setIsValid(true);
      // Perform the registration logic here
      console.log('Account created successfully!');
    }
  };

  return (
    <div className='register-all'>
      <div className='register-container'>
        <h1>Register</h1>
        <br></br>
        {errorMessage && <p className="error-message">{errorMessage}</p>}
        <div className='register-fields'>
          <div className='input-field'>
            <FaUser className='input-icon' style={{margin:'7px 5px'}}/>
            <input type='text' placeholder='Your name' value={name} onChange={(e) => setName(e.target.value)} />
          </div>
          <div className='input-field'>
            <FaPhone className='input-icon' style={{margin:'7px 5px'}}/>
            <input type='tel' placeholder='Phone Number' value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
          </div>
          <div className='input-field'>
            <FaCalendarAlt className='input-icon' style={{margin:'7px 5px'}}/>
            <input type='date' placeholder='Date Of Birth' value={dob} onChange={(e) => setDOB(e.target.value)} />
          </div>
          <div className='input-field'>
            <FaEnvelope className='input-icon' style={{margin:'7px 5px'}}/>
            <input type='email' placeholder='Email Address' value={email} onChange={(e) => setEmail(e.target.value)} />
          </div>
          <div className='input-field'>
            <FaLock className='input-icon' style={{margin:'7px 5px'}}/>
            <input type='password' placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)} />
          </div>
          {isValid ? (
            <Link to="/home"><button>Create Account</button></Link>
          ) : (
            <button onClick={handleCreateAccount}>Create Account</button>
          )}
          <p>Already have an account? <Link to="/">Login</Link></p>
        </div>
      </div>
    </div>
  );
}
export default Signup;
