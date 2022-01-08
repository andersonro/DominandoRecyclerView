package br.com.arodevsistemas.dominandorecyclerview

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.arodevsistemas.dominandorecyclerview.model.Email
import br.com.arodevsistemas.dominandorecyclerview.view.EmailItemUi
import br.com.arodevsistemas.dominandorecyclerview.view.oval
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class EmailAdapter(val emails: MutableList<Email>): RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        return EmailViewHolder(
            EmailItemUi().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount(): Int = emails.size

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtIcon = itemView.find<TextView>(R.id.txt_icon)
        private val txtUser = itemView.find<TextView>(R.id.txt_user)
        private val txtSubject = itemView.find<TextView>(R.id.txt_subject)
        private val txtPreview = itemView.find<TextView>(R.id.txt_preview)
        private val txtDate = itemView.find<TextView>(R.id.txt_date)
        private val imgStar = itemView.find<ImageView>(R.id.img_start)

        fun bind(email: Email) {
            with(email){
                val hash = user.hashCode()
                txtIcon.text = user.first().toString()
                txtIcon.background = txtIcon.oval(Color.rgb(hash, hash/2, 0))
                txtUser.text = user
                txtUser.setTypeface(Typeface.DEFAULT, if(unread) BOLD else NORMAL)
                txtSubject.text = subject
                txtSubject.setTypeface(Typeface.DEFAULT, if(unread) BOLD else NORMAL)
                txtPreview.text = preview
                txtPreview.setTypeface(Typeface.DEFAULT, if(unread) BOLD else NORMAL)
                txtDate.text = date
                txtDate.setTypeface(Typeface.DEFAULT, if(unread) BOLD else NORMAL)
                imgStar.setImageResource(
                    if (stared){
                        R.drawable.ic_baseline_star
                    }else{
                        R.drawable.ic_baseline_star_border
                    }
                )
            }
        }
    }
}