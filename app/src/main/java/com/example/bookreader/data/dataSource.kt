package com.example.bookreader.data

import com.example.bookreader.model.Book
import com.example.bookreader.R

class dataSource {
    fun loadData(): List<Book>{
        return listOf(
            Book(R.drawable.download, R.string.bookName1, R.string.author1),
            Book(R.drawable.download2, R.string.bookName2, R.string.author2),
            Book(R.drawable.download3, R.string.bookName3, R.string.author3),
            Book(R.drawable.download4, R.string.bookName4, R.string.author4),
            Book(R.drawable.download5, R.string.bookName5, R.string.author5)
        )
    }
}