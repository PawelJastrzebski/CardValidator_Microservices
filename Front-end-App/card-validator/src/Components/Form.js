import React, { Component } from 'react';

class Form extends Component {
    constructor(props) {
        super(props)
        this.data = {
            host: "https://localhost",
        }
        this.state = {
            cardNumber: ""
        }
        console.log(this)
    }
    render() {
        return (
            <>
                <input onChange={(event) => { this.setState({ cardNumber: event.target.value }) }} type="text" maxLength="24" className="card-number-form" placeholder="Credit card number" />
                <button onClick={() => this.getData()} className="validate-button">Validate</button>
            </>
        )
    }
    getData() {
        console.log(this.state.cardNumber)
        fetch(this.data.host + '/card/' + this.state.cardNumber)
            .then(response => response.json())
            .then(json => this.props.callback(json))
    }
}

export default Form;