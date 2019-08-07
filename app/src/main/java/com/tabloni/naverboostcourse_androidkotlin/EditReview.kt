package com.tabloni.naverboostcourse_androidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_review.*

class EditReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_review)


        setSupportActionBar(toolbar_editReview)
        title = "한줄평 작성"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        bt_editreview_save.setOnClickListener {
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }
        bt_editreview_cancel.setOnClickListener {
            Toast.makeText(this, "취소하였습니다.", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
