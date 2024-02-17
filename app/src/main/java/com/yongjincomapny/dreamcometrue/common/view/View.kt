package com.yongjincomapny.dreamcometrue.common.view

import android.view.View

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
