package io.github.achapter.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class SpacingItemDecoration(private val spaceHeight: Int, private val orientation: Int) :
    RecyclerView.ItemDecoration() {

    companion object {
        const val VERTICAL = 0
        const val HORIZONTAL = 1
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when (orientation) {
            VERTICAL -> {
                with(outRect) {
                    if (parent.getChildAdapterPosition(view) == 0) {
                        top = spaceHeight
                    }
                    left = spaceHeight
                    right = spaceHeight
                    bottom = spaceHeight
                }
            }
            HORIZONTAL -> {
                with(outRect) {
                    if (parent.getChildAdapterPosition(view) == 0) {
                        left = spaceHeight
                    }
                    top = spaceHeight
                    right = spaceHeight
                    bottom = spaceHeight
                }
            }
            else -> throw IllegalArgumentException("Invalid orientation")
        }
    }

}