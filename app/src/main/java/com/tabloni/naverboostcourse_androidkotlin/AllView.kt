package com.tabloni.naverboostcourse_androidkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_all_view.*

class AllView : AppCompatActivity() {

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
        setContentView(R.layout.activity_all_view)

        setSupportActionBar(toolbar_allView)
        title = "한줄평 목록"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        bt_allview_review_edit.setOnClickListener {
            val editIntent = Intent(this, EditReview::class.java)
            startActivity(editIntent)

        }

        val CustomListAdapter = CommentItemListAdapter(this, userId, userTime, userContents, userRecommend, userProfile)
        asdfasdf.adapter = CustomListAdapter

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
