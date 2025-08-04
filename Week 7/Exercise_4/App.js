import { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      {isLoggedIn ? <LogoutButton onLogout={handleLogout} /> : <LoginButton onLogin={handleLogin} />}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;