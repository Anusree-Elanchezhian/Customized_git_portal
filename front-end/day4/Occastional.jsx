import '../assets/css/birthday.css'; 
import Navbar from './Navbar';
import Sidebar from './Sidebar';
const backgroundStyle = {
    position: 'absolute',
    top: 0,
    left: 0,
    width: '100%',
    height: '200%',
    // background: url(${logbgg}) center/cover no-repeat,
    opacity: 1,
    zIndex: -1,
  };
const Occastional = () => {
  const birthdayCardsData = [
    {
      imageUrl:'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
      title: 'Happiest Birthday Cupcake Mug',
      description: 'Rs.399.00',
    },
    {
      imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748636/pic1_p2cf9z.jpg',
      title: 'Personalised Choco Bar for Birthday',
      description: 'Rs.475.00',
    },
    {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic3_hkkdpd.jpg',
        title: 'Personalised Happy Birthday Teddy',
        description: 'Rs.699.00 ' ,
      },
      {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
        title: 'Personalised Glowing Tower Lamp',
        description: 'Rs.1699.00',
      },
      {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
        title: 'Personalised Spotify Poster Frame',
        description: 'Rs.799.00',
      },
      {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
        title: 'Personalised Wishes Birthday Card',
        description: 'Rs.259.00',
      },
      {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
        title: 'Personalised Spotify Keychain Acrylic',
        description: 'Rs.349.00',
      },
      {
        imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic3_hkkdpd.jpg',
        title: 'Digital Art Personalised Painting',
        description: 'Rs.799.00',
      },
  ];
  const addToCart = (title) => {
    // Implement your add to cart logic here
    alert(`Added ${title} to cart`);
  };

  return (
    <div className="home">
    <Navbar />
    <div className="sidebar-contentb">
        <Sidebar />
    <div className='bday-main'>
      <div style={backgroundStyle}>
        <div className='birthday-card-row'>
          {birthdayCardsData.map((card, index) => (
            <div key={index} className='birthday-card'>
            <img src={card.imageUrl} alt={card.title} className='birthday-card-image' />
            <h3 className='birthday-card-title'>{card.title}</h3>
            <p className='birthday-card-description'>{card.description}</p>
            <button onClick={() => addToCart(card.title)} className="add-to-cart-button">Add to Cart</button>
          </div>
          ))}
        </div>
      </div>
    </div>
    </div>
    </div>
  );
};

export default Occastional;