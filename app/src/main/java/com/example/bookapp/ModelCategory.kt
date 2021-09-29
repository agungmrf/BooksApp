package com.example.bookapp

import java.sql.Timestamp

/**
 * @Author: Agung Ma'ruf
 * @Date: 27/09/2021
 */
class ModelCategory {

    //variabels. must match as in firebase
    var id: String = ""
    var category: String = ""
    var timestamp: Long = 0
    var uid: String = ""

    //empty constructor, required by firebase
    constructor()

    //parameterized constructor
    constructor(id: String, category: String, timestamp: Long, uid: String){
        this.id = id
        this.category = category
        this.timestamp = timestamp
        this.uid = uid
    }
}