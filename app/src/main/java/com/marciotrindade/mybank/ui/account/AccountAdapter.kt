package com.marciotrindade.mybank.ui.account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marciotrindade.mybank.api.model.Statement
import com.marciotrindade.mybank.databinding.ItemBalanceBinding
import com.marciotrindade.mybank.utils.formatDataForBrazilian
import com.marciotrindade.mybank.utils.formatForCoinBrazilian

class AccountAdapter(private val list: List<Statement>) :
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
        fun bind(statement: Statement) = with(binding) {
            tvDate.text = statement.date.formatDataForBrazilian()
            tvdescriptionPayment.text = statement.title
            tvAmount.text =statement.value.formatForCoinBrazilian()


        }

    }
}


