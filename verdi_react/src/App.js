import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './layouts/Layout';
import Main from './pages/Main';
import Login from './pages/member/Login'

function App() {
  return (

    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />}/>
        <Route path="/main" element={ <Layout/> }>
          <Route index element={ <Main/> }/>
        </Route>
        {/* <Route path="/login" element={ <Login/> } />
        <Route path="/register" element={ <Register/> } />
        <Route path="*" element={ <Error/> } /> */}
      </Routes>
    </BrowserRouter>

  );
}

export default App;
