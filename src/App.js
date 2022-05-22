
import './App.css';
import './components/button.css'
import Fetch from './components/Fetch'

import abc from './components/images/ABC.svg'
import logo from './components/images/logo.svg'
import './components/App.css'
function App() {
  return (
    <div className='app'>
       <header style={{backgroundColor:'#2D4250',marginBottom:'7px'}} >
      <img src={abc} alt='ABCproductLogo' style={{height:'47px',marginTop:'6px'}}/><span style={{marginTop:'6px'}}>
        <img src={logo} style={{marginLeft:'430px',height:'47px'} } alt='highradiuslogo'/>
      </span>
      <h2 style={{color:'white',marginLeft:'35px',marginTop:'5px',marginBottom:'0px'}}>INVOICE LIST</h2>
      
      </header>
      
      
      <Fetch />
      
      <footer >
            <br />
            <div className='footer1' >
            <span style={{color:'#2453C1',}}>Privacy Policy </span>
             | ©2022 HighRadius Corporation. All rights reserved.
            </div>
            <br />
        </footer>


    </div>
  );
}

export default App;
