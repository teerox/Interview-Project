package com.example.kliqrdemoapplication.screens

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kliqrdemoapplication.R
import com.example.kliqrdemoapplication.databinding.SingleCardBinding
import com.example.kliqrdemoapplication.model.Account

class AccountDetailsAdapter(private var arrayLists:ArrayList<Account>,private val clickListerner: (id:Int) -> Unit):
    RecyclerView.Adapter<AccountDetailsAdapter.ViewHolder>(){

    class ViewHolder(private val binding:SingleCardBinding):RecyclerView.ViewHolder(binding.root) {
      fun bind(item:Account,clickListerner: (id:Int) -> Unit) {
          binding.bankImage.setImageResource(item.image)
          binding.delete.setOnClickListener {

              item.active = false
              clickListerner(item.id)
          }
          binding.accountDetails = item
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = SingleCardBinding.inflate(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayLists.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(arrayLists[position],clickListerner)

}
