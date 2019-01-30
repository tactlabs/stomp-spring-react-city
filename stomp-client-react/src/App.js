import React, { Component } from 'react';
import { Client } from '@stomp/stompjs';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    city: null,
    country: null,
  }

  componentDidMount() {
    console.log('Component did mount');
    // The compat mode syntax is totally different, converting to v5 syntax
    // Client is imported from '@stomp/stompjs'
    this.client = new Client();

    this.client.configure({
      brokerURL: 'ws://localhost:1878/stomp',
      onConnect: () => {
        console.log('onConnect');

        this.client.subscribe('/random/city', message => {
          console.log(message);
          this.setState({city: message.body});
        });

        this.client.subscribe('/random/state', message => {
          console.log(message);
          this.setState({country: message.body});
        });

        
      },
      // Helps during debugging, remove in production
      debug: (str) => {
        console.log(new Date(), str);
      }
    });

    this.client.activate();
  }

  clickHandler = () => {
    this.client.publish({destination: '/app/greetings', body: 'Hello world'});
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          
          <p>
            City: {this.state.city ? this.state.city : 'no data'}
          </p>

          <p>
            Country: {this.state.country ? this.state.country : 'no data'}
          </p>
          
        </header>
      </div>
    );
  }
}

export default App;
