package com.marciotrindade.mybank.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.marciotrindade.mybank.R
import com.marciotrindade.mybank.databinding.FragmentLoginBinding
import com.marciotrindade.mybank.ui.account.User
import com.marciotrindade.mybank.utils.Validation
import com.marciotrindade.mybank.utils.setColorStatusBar
import com.marciotrindade.mybank.viewmodel.BalanceViewModel


class LoginFragment : Fragment() {
    private lateinit var balanceViewModel: BalanceViewModel
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.setColorStatusBar()
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        balanceViewModel= ViewModelProvider(requireActivity()).get(BalanceViewModel::class.java)

        balanceViewModel.userReturnLiveData.observe(viewLifecycleOwner, Observer {
            startAccount()

        })



        binding.btnLogin.setOnClickListener {
            if (inputValidation()) {
                val user = User(binding.edtUser.editableText.toString(),binding.edtPassword.editableText.toString())
                balanceViewModel.postUser(user.id,user.Password)


                Toast.makeText(requireContext(), "ok", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "não", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
        }

    }

    private fun startAccount() {
        findNavController()
            .navigate(
                R.id.action_loginFragment_to_accountFragment,
                null,
                NavOptions.Builder()
                    .setPopUpTo(
                        R.id.loginFragment,
                        true
                    ).build()
            )


    }



    private fun inputValidation(): Boolean {
        val edtUser = binding.edtUser
        val tilUser = binding.tilUser
        val edtPassword = binding.edtPassword
        val tilPassword = binding.tilPassword

        Validation(requireContext()).apply {
            return cpfReturn(edtUser, tilUser) || isEmailValid(edtUser, tilUser) &&
                    isEditTextFilled(edtUser, tilUser)
                    && passwordReturn(edtPassword, tilPassword)
                    && isEditTextFilled(edtPassword, tilPassword)

        }

    }

    override fun onResume() {
        super.onResume()
        activity?.setColorStatusBar()
    }


}