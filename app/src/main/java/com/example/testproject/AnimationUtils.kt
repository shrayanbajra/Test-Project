package com.example.testproject

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

object AnimationUtils {

    fun toggleArrow(view: View, isExpanded: Boolean): Boolean {
        return if (isExpanded) {
            view.animate().setDuration(200).rotation(180F)
            true
        } else {
            view.animate().setDuration(200).rotation(0F)
            false
        }
    }

    fun expand(view: View) {
        val animation: Animation = getExpandAnimation(view)
        view.startAnimation(animation)
    }

    private fun getExpandAnimation(view: View): Animation {
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val actualHeight = view.measuredHeight

        view.layoutParams.height = 0
        view.visibility = View.VISIBLE

        val animation: Animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                view.layoutParams.height =
                    if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (actualHeight * interpolatedTime).toInt()
                view.requestLayout()
            }
        }

        animation.duration =
            (actualHeight / view.context.resources.displayMetrics.density).toLong()

        view.startAnimation(animation)

        return animation

    }

    fun collapse(view: View) {
        val animation: Animation = getCollapseAnimation(view)
        view.startAnimation(animation)
    }

    private fun getCollapseAnimation(view: View): Animation {
        val actualHeight: Int = view.measuredHeight

        val animation: Animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                if (interpolatedTime == 1f) {
                    view.visibility = View.GONE
                } else {
                    view.layoutParams.height =
                        actualHeight - (actualHeight * interpolatedTime).toInt()
                    view.requestLayout()
                }
            }
        }

        animation.duration = (actualHeight / view.context.resources
            .displayMetrics.density).toLong()
        return animation
    }

}

