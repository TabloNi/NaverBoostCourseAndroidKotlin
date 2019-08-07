package com.tabloni.naverboostcourse_androidkotlin

import android.content.Context
import android.content.Intent
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
        "TabloNi6",
        "TabloNi7",
        "TabloNi8",
        "TabloNi9",
        "TabloNi10"

    )

    private val userTime = arrayOf(
        "10분전",
        "20분전",
        "30분전",
        "45분전",
        "55분전",
        "240분전",
        "130분전",
        "455분전",
        "574분전",
        "215분전"
    )

    private val userContents = arrayOf(
        "재미있어욝1",
        "재미있어욝2",
        "재미있어욝3",
        "재미있어욝4",
        "재미있어욝5",
        "재미있어욝6",
        "재미있어욝7",
        "재미있어욝8",
        "재미있어욝9",
        "재미있어욝10"
    )

    private val userRecommend = arrayOf(
        "추천 10",
        "추천 50",
        "추천 24",
        "추천 19",
        "추천 65",
        "추천 87",
        "추천 54",
        "추천 23",
        "추천 64",
        "추천 43"
    )

    private val userProfile = arrayOf(
        R.drawable.ic_12,
        R.drawable.ic_15,
        R.drawable.ic_19,
        R.drawable.ic_facebook,
        R.drawable.ic_kakao,
        R.drawable.user1,
        R.drawable.abc_ic_star_black_48dp,
        R.drawable.abc_text_select_handle_left_mtrl_dark,
        R.drawable.abc_textfield_default_mtrl_alpha,
        R.drawable.abc_btn_switch_to_on_mtrl_00001
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

        tv_view_all_comment.setOnClickListener {
            val allIntent = Intent(this, AllView::class.java)
            startActivity(allIntent)
        }

        tv_main_review_write.setOnClickListener {
            val editIntent = Intent(this, EditReview::class.java)
            startActivity(editIntent)
        }

        val CustomListAdapter = CommentItemListAdapter(this, userId, userTime, userContents, userRecommend, userProfile)
        CommentListView.adapter = CustomListAdapter

    }

}