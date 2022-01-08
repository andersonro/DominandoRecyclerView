package br.com.arodevsistemas.dominandorecyclerview.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import br.com.arodevsistemas.dominandorecyclerview.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class EmailItemUi : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 32f
                setColor(Color.WHITE)
            }

            relativeLayout {
                lparams(matchParent, wrapContent) {
                    horizontalPadding = dip(16)
                    verticalPadding = dip(8)
                }

                textView {
                    id = R.id.txt_icon
                    textSize = 24f
                    background = oval(Color.RED)
                    gravity = Gravity.CENTER
                    textColor = Color.WHITE
                }.lparams(dip(48), dip(48))

                textView {
                    id = R.id.txt_user
                    textColor = Color.DKGRAY
                    textSize = 16f
                }.lparams(wrapContent, wrapContent) {
                    rightOf(R.id.txt_icon)
                    sameTop(R.id.txt_icon)
                    marginStart = dip(16)
                }

                textView {
                    id = R.id.txt_subject
                    lines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    textColor = Color.DKGRAY
                    textSize = 14f
                }.lparams {
                    below(R.id.txt_user)
                    sameStart(R.id.txt_user)
                    marginEnd = dip(24)
                }

                textView {
                    id = R.id.txt_preview
                    lines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    textColor = Color.DKGRAY
                    textSize = 14f
                }.lparams {
                    below(R.id.txt_subject)
                    sameStart(R.id.txt_subject)
                    marginEnd = dip(24)
                }

                textView {
                    id = R.id.txt_date
                    lines = 1
                    textColor = Color.DKGRAY
                    ellipsize = TextUtils.TruncateAt.END
                }.lparams(wrapContent, wrapContent) {
                    alignParentEnd()
                    alignParentTop()
                }

                imageView(R.drawable.ic_baseline_star_border) {
                    id = R.id.img_start
                }.lparams(dip(24), dip(24)){
                    alignParentEnd()
                    alignParentBottom()
                }

            }
        }
    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}