package com.yongjincomapny.dreamcometrue.common.view

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

private const val LISTENER_DELAY = 500L

fun View.setOnDebounceClickListener(block: () -> Unit) {
    var beforeTime = 0L
    this.setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (currentTime - beforeTime > LISTENER_DELAY) {
            block.invoke()
            beforeTime = System.currentTimeMillis()
        }
    }
}


internal class GridSpacingItemDecoration(
    private val spanCount: Int, // Grid의 column 수
    private val spacing: Int // 간격
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)

        if (position >= 0) {
            val column = position % spanCount
            outRect.apply {
                left = spacing - column * spacing / spanCount
                right = (column + 1) * spacing / spanCount
                if (position < spanCount) top = spacing
                bottom = spacing / 2
            }
        } else {
            outRect.apply {
                left = 0
                right = 0
                top = 0
                bottom = 0
            }
        }
    }
}

fun Float.fromDpToPx(): Int =
    (this * Resources.getSystem().displayMetrics.density).toInt()