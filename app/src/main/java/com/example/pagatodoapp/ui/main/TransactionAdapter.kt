package com.example.pagatodoapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagatodoapp.R
import com.example.pagatodoapp.model.Transaction
import kotlinx.android.synthetic.main.transaction_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionAdapter : ListAdapter<Transaction, TransactionAdapter.MainViewHolder>(TransactionComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.transaction_item, parent, false)
        return MainViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.apply {
                tvUuid.text = currentItem.uuid
                tvmerchantUuid.text = currentItem.merchantUuid
                tvmerchantName.text = currentItem.merchantName
                tvcurrencyCode.text = currentItem.currencyCode
                tvamount.text = currentItem.amount.toString()
                tvtimestamp.text = convertLongToTime(currentItem.timestamp.toLong())
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }

    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvUuid = v.tvUuid
        var tvmerchantUuid = v.tvmerchantUuid
        var tvmerchantName = v.tvmerchantName
        var tvcurrencyCode = v.tvcurrencyCode
        var tvamount = v.tvamount
        var tvtimestamp = v.tvtimestamp
    }

    class TransactionComparator : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction) =
            oldItem.uuid == newItem.uuid

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction) =
            oldItem == newItem
    }
}