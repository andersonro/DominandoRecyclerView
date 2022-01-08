package br.com.arodevsistemas.dominandorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.arodevsistemas.dominandorecyclerview.model.email
import br.com.arodevsistemas.dominandorecyclerview.model.fakeEmails
import br.com.arodevsistemas.dominandorecyclerview.view.EmailActivityUI
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.setContentView

class EmailActivity : AppCompatActivity() {

    lateinit var adapter: EmailAdapter
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val emails = fakeEmails()
        adapter = EmailAdapter(emails)
        EmailActivityUI(adapter).setContentView(this)

    }

    fun addEmail(){

        adapter.emails.add(0, email {
            stared = false
            unread = true
            user = "E-mail"
            subject = "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
            date = "15 May"
            preview = mutableListOf<String>().apply {
                repeat(10){
                    add("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
                }
            }.joinToString(" ")

        })

        adapter.notifyItemInserted(0)
    }


}