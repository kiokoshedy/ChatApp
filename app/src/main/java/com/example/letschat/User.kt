package com.example.letschat

class User {

    var firstName: String? = null
    var secondName: String? = null
    var email: String? = null
    var uid: String? = null

    constructor() {}

    constructor(firstName: String?, secondName: String?, email : String?) {

        this.firstName = firstName
        this.secondName = secondName
        this.email = email
        this.uid= uid
    }
}