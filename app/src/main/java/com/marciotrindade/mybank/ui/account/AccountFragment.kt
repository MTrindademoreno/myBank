package com.marciotrindade.mybank.ui.account

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.marciotrindade.mybank.databinding.FragmentAccountBinding
import com.marciotrindade.mybank.utils.changeColorStatusBar
import com.marciotrindade.mybank.utils.formatForCoinBrazilian
import com.marciotrindade.mybank.viewmodel.BalanceViewModel


class AccountFragment : Fragment() {
    private lateinit var balanceViewModel: BalanceViewModel
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

        balanceViewModel = ViewModelProvider(requireActivity()).get(BalanceViewModel::class.java)



        setubObservables()
        setupRecyclerview()
    }


    @SuppressLint("SetTextI18n")
    private fun setubObservables() {


        balanceViewModel.userReturnLiveData.observe(viewLifecycleOwner, Observer { user ->
            binding.tvUserName.text = user.name
            binding.account.text = " ${user.bankAccount}/${user.agency}"
            binding.tvBalance.text = user.balance.formatForCoinBrazilian()
            val id = user.userId
            balanceViewModel.loadBalance(id)


        })


    }

    private fun setupRecyclerview() {
        activity.let {
            balanceViewModel.statmentLiveData.observe(viewLifecycleOwner, { list ->
                binding.rvBalance.apply {
                    layoutManager = LinearLayoutManager(it)
                    adapter = AccountAdapter(list.statementList)
                }
            }
            )

        }
    }


}