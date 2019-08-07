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

    private val userId = arrayOf(
        "TabloNi1",
        "TabloNi2",
        "TabloNi3",
        "TabloNi4",
        "TabloNi5",
        "TabloNi6"

    )


    private val userTime = arrayOf(
        "10분전",
        "20분전",
        "30분전",
        "45분전",
        "55분전",
        "25분전"
    )

    private val userContents = arrayOf(
        "재미있어욝1",
        "재미있어욝2",
        "재미있어욝3",
        "재미있어욝4",
        "재미있어욝5",
        "재미있어욝6"
    )

    private val userRecommend = arrayOf(
        "추천 10",
        "추천 50",
        "추천 24",
        "추천 19",
        "추천 65",
        "추천 12"
    )

    private val userProfile = arrayOf(
        R.drawable.ic_12,
        R.drawable.ic_15,
        R.drawable.ic_19,
        R.drawable.ic_facebook,
        R.drawable.ic_kakao,
        R.drawable.user1
    )

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

        val CustomListAdapter = CommentItemListAdapter(this, userId, userTime, userContents, userRecommend, userProfile)
        CommentListView.adapter = CustomListAdapter

    }


}