package com.example.bajralibrary.utils

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView

object AnimationUtils {

    fun toggleArrow(imageView: ImageView, isExpanded: Boolean) {

        if (isExpanded) {
            imageView.animate().rotation(0f).start()
        } else {
            imageView.animate().rotation(180f).start()
        }

    }

//    fun toggleArrow(view: View, isExpanded: Boolean): Boolean {
//
//        val arrowAnimation = if (isExpanded)
//            RotateAnimation(
//                0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f
//            )
//        else
//            RotateAnimation(
//                180f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f
//            )
//
//        arrowAnimation.fillAfter = true
//        arrowAnimation.duration = 200
//
//        view.startAnimation(arrowAnimation)
//
//        return true
//
//    }

//    fun toggleArrow(view: View, isExpanded: Boolean): Boolean {
//
//        return if (isExpanded) {
//            view.animate().setDuration(200L).rotation(180F)
//            true
//        } else {
//            view.animate().setDuration(200L).rotation(0F)
//            false
//        }
//
//    }

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
                    if (interpolatedTime == 1f)
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    else
                        (actualHeight * interpolatedTime).toInt()

                view.requestLayout()

            }
        }

        animation.duration =
            (actualHeight / view.context.resources.displayMetrics.density).toLong()

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

        animation.duration = (actualHeight / view.context.resources.displayMetrics.density).toLong()

        return animation

    }

}

