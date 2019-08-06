package com.tabloni.naverboostcourse_androidkotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var likeState = false
    private var hateState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val likeCount: TextView = findViewById(R.id.tv_thumb_up_number)
        val likeCountValue = likeCount.text
        var likeCountNum: Int = likeCountValue.toString().toInt()

        val hateCount: TextView = findViewById(R.id.tv_thumb_down_number)
        val hateCountValue = hateCount.text
        var hateCountNum: Int = hateCountValue.toString().toInt()

        fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        fun LikeCountUp() {
            likeCountNum += 1
            tv_thumb_up_number.text = likeCountNum.toString()
            iv_thumb_up.setImageResource(R.drawable.ic_thumb_up_selected)
            likeState = true

        }

        fun LikeCountDown() {
            likeCountNum -= 1
            tv_thumb_up_number.text = likeCountNum.toString()
            iv_thumb_up.setImageResource(R.drawable.ic_thumb_up)
            likeState = false

        }

        fun HateCountUp() {
            hateCountNum += 1
            tv_thumb_down_number.text = hateCountNum.toString()
            iv_thumb_down.setImageResource(R.drawable.ic_thumb_down_selected)
            hateState = true

        }

        fun HateCountDown() {
            hateCountNum -= 1
            tv_thumb_down_number.text = hateCountNum.toString()
            iv_thumb_down.setImageResource(R.drawable.ic_thumb_down)
            hateState = false

        }


        iv_thumb_up.setOnClickListener {
            if (likeState && hateState) {
                toast("err!")
            } else if (!likeState && hateState) {
                HateCountDown()
                LikeCountUp()
                toast("!likeState && hateState")
            } else if (likeState && !hateState) {
                LikeCountDown()
                toast("likeState && !hateState")
            } else if (!likeState && !hateState) {
                LikeCountUp()
                toast("!likeState && !hateState")
            }

        }

        iv_thumb_down.setOnClickListener {

            if (likeState && hateState) {
                toast("err!")
            } else if (!likeState && hateState) {
                HateCountDown()
                toast("!likeState && hateState")
            } else if (likeState && !hateState) {
                LikeCountDown()
                HateCountUp()
                toast("likeState && !hateState")
            } else if (!likeState && !hateState) {
                HateCountUp()
                toast("!likeState && !hateState")
            }

        }

    }

}