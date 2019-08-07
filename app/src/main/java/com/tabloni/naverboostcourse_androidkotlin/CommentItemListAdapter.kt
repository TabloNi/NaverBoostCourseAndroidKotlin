package com.tabloni.naverboostcourse_androidkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CommentItemListAdapter(
    private val context: Activity,
    private val listreview_id: Array<String>,
    private val listreview_time: Array<String>,
    private val listreview_contents: Array<String>,
    private val listreview_recommend: Array<String>,
    private val listreview_profile: Array<Int>
) : ArrayAdapter<String>(context, R.layout.comment_item_view, listreview_id) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.comment_item_view, null, true)

        val reviewId = rowView.findViewById(R.id.tv_listreview_id) as TextView
        val reviewTime = rowView.findViewById(R.id.tv_listreview_time) as TextView
        val reviewContents = rowView.findViewById(R.id.tv_listreview_contents) as TextView
        val reviewRecommend = rowView.findViewById(R.id.tv_listreview_recommend) as TextView
        val reviewProfile = rowView.findViewById(R.id.iv_profile) as ImageView

        reviewId.text = listreview_id[position]
        reviewTime.text = listreview_time[position]
        reviewContents.text = listreview_contents[position]
        reviewRecommend.text = listreview_recommend[position]
        reviewProfile.setImageResource(listreview_profile[position])

        return rowView
    }
}