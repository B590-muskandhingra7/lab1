import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter ,Routes,Route} from 'react-router-dom'
import { Dashboard } from './components/Dashboard'
import { Landing } from './components/Landing'
import { useNavigate } from 'react-router-dom'

function App() {
  return (
    <div>

    <BrowserRouter>
    <Appbar/>


   
    <Routes>
      <Route path="/dashboard" element={<Dashboard/>}/>
      <Route path="/" element={<Landing/>}/>
    </Routes>
    
    
    </BrowserRouter>
    </div>
  )
}
function Appbar(){
  const navigate=useNavigate();

  return  <div>
  <button onClick={()=>{
    navigate("/");
  }}>Landing page </button>
  <button onClick={()=>{
    navigate("/dashboard");
  }}>Dashboard  </button>
  </div>
}
export default App
