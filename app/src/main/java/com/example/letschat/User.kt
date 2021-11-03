package com.example.letschat

class User {

    var firstName: String? = null
    var secondName: String? = null
    var email: String? = null
    var password: String? = null
    var uid: String? = null

    constructor() {}

    constructor(firstName: String?, secondName: String?, email : String?, password: String) {

        this.firstName = firstName
        this.secondName = secondName
        this.email = email
        this.password = password
        this.uid= uid
    }
}