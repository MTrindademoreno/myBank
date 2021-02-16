package com.marciotrindade.mybank.ui.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marciotrindade.mybank.databinding.ItemBalanceBinding

class AccountAdapter(private val list: List<Payments>) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBalanceBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: ItemBalanceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(payments: Payments) = with(binding) {
            tvDate.text = payments.date
            tvdescriptionPayment.text = payments.title
            tvAmount.text = payments.value


        }

    }
}


