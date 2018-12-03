import React, { Component } from 'react';
import Form from './Form'

class Index extends Component {
    constructor(props) {
        super(props)
        this.state = {
            showResult: false
        }
        this.data = {
            isValid: false,
            issuer: ""
        }
    }
    render() {

        let resultBox = <></>
        if (this.state.showResult) {

            if (this.data.isValid) {
                resultBox =
                    <div onClick={() => { this.setState({ showResult: false }) }} className="result-box">
                        <div className="icon-status succesStatus"></div>
                        <p className="header">Validation result</p>
                        <p className="property">Is Valid</p>
                        <p className="value value-blue">{this.data.isValid + ""}</p>
                        <p className="property">Issuer provider</p>
                        <p className="value value-blue">{this.data.issuer}</p>
                    </div>
            } else {
                resultBox =
                    <div onClick={() => { this.setState({ showResult: false }) }} className="result-box">
                        <div className="icon-status errorStatus"></div>
                        <p className="header">Validation result</p>
                        <p className="property">Is Valid</p>
                        <p className="value value-red">{this.data.isValid + ""}</p>
                        <p className="property">Issuer provider</p>
                        <p className="value value-red">{this.data.issuer}</p>
                    </div>
            }

        }

        return (


            <div className="wrapper">

                <div className="form-box">
                    <div className="Logo">
                        <span>Card</span> Validator
            </div>
                    <Form callback={(e) => this.onDataReceived(e)} />

                </div>
                {resultBox}

            </div>

        )
    }
    onDataReceived(data) {
        console.log(data)
        if (data.validationPassed == undefined) {
            this.data.isValid = false;
            this.data.issuer = "No result"
        } else {
            this.data.isValid = data.validationPassed;
            this.data.issuer = data.issuer;
        }

        this.setState({ showResult: true })
        console.log(this.data)

    }
}

export default Index;