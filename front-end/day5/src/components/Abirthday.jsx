import { useState } from 'react';
import Navbar from './Navbar';
import Sidebar from './Sidebar';
import '../assets/css/birthday.css';

const backgroundStyle = {
    position: 'absolute',
    top: 0,
    left: 0,
    width: '100%',
    height: '200%',
    opacity: 1,
    zIndex: -1,
};

const Abirthday = () => {
    const [birthdayCardsData, setBirthdayCardsData] = useState([
        {
            imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748635/pic2_f0mepw.jpg',
            title: 'Happiest Birthday Cupcake Mug',
            description: 'Rs.399.00',
        },
        {
            imageUrl: 'https://res.cloudinary.com/ddlw9iej1/image/upload/v1708748636/pic1_p2cf9z.jpg',
            title: 'Personalised Choco Bar for Birthday',
            description: 'Rs.475.00',
        },
        // Existing gift cards
    ]);

    const [newCard, setNewCard] = useState({
        imageUrl: '',
        title: '',
        description: '',
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setNewCard({ ...newCard, [name]: value });
    };

    const handleAddCard = () => {
        setBirthdayCardsData([...birthdayCardsData, newCard]);
        setNewCard({ imageUrl: '', title: '', description: '' });
    };

    return (
        <div className="home">
            <Navbar />
            <div className="sidebar-content1">
                <Sidebar />
                <div className="bday-main">
                    <div style={backgroundStyle}>
                        <div className="birthday-card-row">
                            {birthdayCardsData.map((card, index) => (
                                <div key={index} className="birthday-card">
                                    <img src={card.imageUrl} alt={card.title} className="birthday-card-image" />
                                    <h3 className="birthday-card-title">{card.title}</h3>
                                    <p className="birthday-card-description">{card.description}</p>
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="admin-form">
                        <h2>Add New Gift Card</h2>
                        <input
                            type="text"
                            placeholder="Image URL"
                            name="imageUrl"
                            value={newCard.imageUrl}
                            onChange={handleInputChange}
                        />
                        <input
                            type="text"
                            placeholder="Title"
                            name="title"
                            value={newCard.title}
                            onChange={handleInputChange}
                        />
                        <input
                            type="text"
                            placeholder="Description"
                            name="description"
                            value={newCard.description}
                            onChange={handleInputChange}
                        />
                        <button onClick={handleAddCard}>Add Card</button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Abirthday;
