import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";


function App() {
  return (
    <div className="App">
      <div className="container" style={{ padding: 15 }}>
        <Navbar />
      </div>
      <Footer />
    </div>
  );
}

export default App;
