package com.marciotrindade.mybank.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marciotrindade.mybank.databinding.FragmentAccountBinding
import com.marciotrindade.mybank.utils.changeColorStatusBar


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.changeColorStatusBar()
        binding = FragmentAccountBinding.inflate(layoutInflater)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        activity.let {
            val list = listOf(Payments("luz","12/02/2020","R$1.000,00"),
                Payments("agua","10/02/2020","R$100,00"),
                Payments("telefone","12/02/2021","R$7.000,00"))

            binding.rvBalance.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = AccountAdapter(list)
            }
        }
    }


}