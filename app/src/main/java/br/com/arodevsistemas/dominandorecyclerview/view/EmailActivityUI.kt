package br.com.arodevsistemas.dominandorecyclerview.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arodevsistemas.dominandorecyclerview.EmailActivity
import br.com.arodevsistemas.dominandorecyclerview.EmailAdapter
import br.com.arodevsistemas.dominandorecyclerview.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class EmailActivityUI(private val emailAdapter: EmailAdapter) : AnkoComponent<EmailActivity> {

    lateinit var rv: RecyclerView

    override fun createView(ui: AnkoContext<EmailActivity>) = ui.apply {
        relativeLayout {
            backgroundColor = Color.BLUE
            lparams(matchParent, matchParent)

            themedAppBarLayout(R.style.ThemeOverlay_AppCompat_ActionBar){
                id = R.id.app_bar
                toolbar {
                    id = R.id.toolbar
                    backgroundColor = Color.WHITE
                    popupTheme = R.style.ThemeOverlay_AppCompat_Light
                    title = ctx.getString(R.string.app_name)
                }.lparams(matchParent, wrapContent)
            }.lparams(matchParent, wrapContent)

            rv = recyclerView {
                backgroundColor = Color.WHITE
                layoutManager = LinearLayoutManager(ctx)
                adapter = emailAdapter
            }.lparams(matchParent, matchParent){
                below(R.id.app_bar)
            }

            floatingActionButton {
                id = R.id.fab
                image = ContextCompat.getDrawable(ctx, R.drawable.ic_baseline_add)
                supportBackgroundTintList = ColorStateList.valueOf(Color.WHITE)
                supportImageTintList = ColorStateList.valueOf(Color.RED)
                rippleColor = Color.LTGRAY
                onClick {
                    ui.owner.addEmail()
                    rv.scrollToPosition(0)
                }
            }.lparams{
                alignParentBottom()
                alignParentEnd()
                setMargins(0, 0, dip(16), dip(16))
            }
        }

        val helper = androidx.recyclerview.widget.ItemTouchHelper(
            /*
            Alteração da lista

            ItemTouchHelper(
                androidx.recyclerview.widget.ItemTouchHelper.UP or androidx.recyclerview.widget.ItemTouchHelper.DOWN,
                androidx.recyclerview.widget.ItemTouchHelper.LEFT
            )
            */
            ItemTouchHelper(
                0,
                androidx.recyclerview.widget.ItemTouchHelper.LEFT
            )
        )

        helper.attachToRecyclerView(rv)

    }.view

    inner class ItemTouchHelper(dragDirs: Int, swipeDirs: Int): androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback(
        dragDirs, swipeDirs
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val from: Int = viewHolder.adapterPosition
            val to: Int = target.adapterPosition

            Collections.swap(emailAdapter.emails, from, to)
            emailAdapter.notifyItemMoved(from, to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            emailAdapter.emails.removeAt(viewHolder.adapterPosition)
            emailAdapter.notifyItemRemoved(viewHolder.adapterPosition)
        }
    }
}