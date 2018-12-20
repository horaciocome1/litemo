package io.github.horaciocome1.litemo.domain

class Post {

    var id: Int
    var background: Int
    var writerPic: Int
    var title: String
    var category: String
    var readCount: String

    constructor(id: Int, background: Int, writerPic: Int, title: String, category: String, readCount: String) {
        this.id = id
        this.background = background
        this.writerPic = writerPic
        this.title = title
        this.category = category
        this.readCount = readCount
    }
}