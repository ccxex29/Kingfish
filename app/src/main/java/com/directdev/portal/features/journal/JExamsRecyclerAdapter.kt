package com.directdev.portal.features.journal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.directdev.portal.R
import com.directdev.portal.models.ExamModel
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_jexams.view.*

class JExamsRecyclerAdapter(
        data: OrderedRealmCollection<ExamModel>?,
        autoUpdate: Boolean) :
        RealmRecyclerViewAdapter<ExamModel, JExamsRecyclerAdapter.ViewHolder>(data, autoUpdate) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data?.get(position) as ExamModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_jexams, parent, false))

    class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        fun bindData(item: ExamModel) {
            itemView.journal_exam_chair.text = "Seat " + item.chairNumber
            itemView.journal_exam_room.text = item.room
            itemView.journal_exam_shift.text = item.shift
            itemView.journal_exam_name.text = item.courseName
        }
    }
}
