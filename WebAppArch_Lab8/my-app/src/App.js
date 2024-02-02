import logo from "./logo.svg";

import React from "react";
import { PostProvider } from "./components/PostContext";

import Dashboard from "./components/Dashboard";

import "./App.css";

function App() {
  return (
    <PostProvider>
      <div className="App">
        <div className="container">
          <header className="App-header">
            <h1>Posts Dashboard</h1>
          </header>
          <Dashboard />
        </div>
      </div>
    </PostProvider>
  );

  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       <p>
  //         Edit <code>src/App.js</code> and save to reload.
  //       </p>
  //       <a
  //         className="App-link"
  //         href="https://reactjs.org"
  //         target="_blank"
  //         rel="noopener noreferrer"
  //       >
  //         Learn React
  //       </a>
  //     </header>
  //   </div>
  // );
}

export default App;
