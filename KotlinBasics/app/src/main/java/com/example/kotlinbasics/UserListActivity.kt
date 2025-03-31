package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.UserAdapter
import com.example.kotlinbasics.model.User


class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_users)

        val users: List<User> = listOf(
            User("Kovács János", "kovacs.janos@gmail.com", R.drawable.usericon),
            User("Nagy Éva", "nagy.eva@gmail.com", R.drawable.usericon),
            User("Tóth Ádám", "toth.adam@gmail.com", R.drawable.usericon),
            User("Szabó Anna", "szabo.anna@gmail.com", R.drawable.usericon),
            User("Kiss Péter", "kiss.peter@gmail.com", R.drawable.usericon),
            User("Molnár Zsuzsanna", "molnar.zsuzsanna@gmail.com", R.drawable.usericon),
            User("Varga István", "varga.istvan@gmail.com", R.drawable.usericon),
            User("Balogh Katalin", "balogh.katalin@gmail.com", R.drawable.usericon),
            User("Németh Gábor", "nemeth.gabor@gmail.com", R.drawable.usericon)
        )

        val recyclerView: RecyclerView = findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)

    } //ON CREATE
}
