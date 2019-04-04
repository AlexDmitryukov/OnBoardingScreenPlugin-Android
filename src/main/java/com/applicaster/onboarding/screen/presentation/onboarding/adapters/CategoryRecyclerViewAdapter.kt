package com.applicaster.onboarding.screen.presentation.onboarding.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applicaster.onboarding.screen.presentation.onboarding.OnboardingFragment
import com.applicaster.onboarding.screen.presentation.onboarding.dummy.DummyContent
import com.applicaster.onboardingscreen.R

class CategoryRecyclerViewAdapter(
        private val mValues: List<DummyContent.DummyItem>,
        private val mListener: OnboardingFragment.OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyContent.DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
//        holder.mIdView.text = item.id
//        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val mIdView: TextView = mView.item_number
//        val mContentView: TextView = mView.content

        override fun toString(): String {
            return ""
//            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
