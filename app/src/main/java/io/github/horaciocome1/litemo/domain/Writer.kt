package io.github.horaciocome1.litemo.domain

class Writer {

    var categories: String
    var name: String
    var town: String
    var profilePic: Int
    var percent: String

    constructor(category: String, name: String, town: String, profilePic: Int, percent: String) {
        this.categories = category
        this.name = name
        this.town = town
        this.profilePic = profilePic
        this.percent = percent
    }
}