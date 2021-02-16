package com.marciotrindade.mybank.ui.login

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.marciotrindade.mybank.R
import com.marciotrindade.mybank.databinding.FragmentLoginBinding
import com.marciotrindade.mybank.utils.setColorStatusBar


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      activity?.setColorStatusBar()
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvBank.setOnClickListener {
            findNavController ()
                .navigate (R.id.action_loginFragment_to_accountFragment ,
                    null,
                    NavOptions.Builder ()
                        .setPopUpTo (R.id.loginFragment ,
                            true) .build ()
                )


        }
    }

    override fun onResume() {
        super.onResume()
        activity?.setColorStatusBar()
    }



}