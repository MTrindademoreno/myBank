package com.marciotrindade.mybank.utils

import android.content.Context
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.marciotrindade.mybank.R


class Validation(val context: Context) {


    fun isEditTextFilled(et: EditText, til: TextInputLayout): Boolean {
        return if (et.text.isNotEmpty()) {
            til.isErrorEnabled = false
            true
        } else {
            til.error = context.getString(R.string.field_required)
            et.requestFocus()
            false
        }
    }

    fun isEmailValid(et: EditText, til: TextInputLayout): Boolean {
        return when {
            android.util.Patterns.EMAIL_ADDRESS.matcher(et.text.toString()).matches() -> {
                til.isErrorEnabled = false
                true
            }
            else -> {
                if (et.text.isEmpty()) {
                    til.error = context.getString(
                        R.string.field_required
                    )
                } else {
                    til.error = context.getString(R.string.msg_invalid_email)
                }
                et.requestFocus()
                false
            }
        }
    }

    fun isPasswordValid(et: EditText): Boolean {
        val senha = et.editableText.toString()
        return PASSWORD_REGEX.matches(senha)

    }


    fun isCpf(cpf: EditText): Boolean {
        val document = cpf.editableText.toString()

        val numbers = arrayListOf<Int>()

        document.filter { it.isDigit() }.forEach {
            numbers.add(it.toString().toInt())
        }

        if (numbers.size != 11) return false

        //repeticao
        (0..9).forEach { n ->
            val digits = arrayListOf<Int>()
            (0..10).forEach { digits.add(n) }
            if (numbers == digits) return false
        }

        //digito 1
        val dv1 = ((0..8).sumBy { (it + 1) * numbers[it] }).rem(11).let {
            if (it >= 10) 0 else it
        }

        val dv2 = ((0..8).sumBy { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
            if (it >= 10) 0 else it
        }

        return numbers[9] == dv1 && numbers[10] == dv2

    }

    fun cpfReturn(et: EditText, til: TextInputLayout): Boolean {
        if (isCpf(et)) {
            til.isErrorEnabled = false
            return true

        } else {
            til.error = context.getString(R.string.cpf_invalid)
            et.requestFocus()
            return false

        }
    }

    fun passwordReturn(et: EditText, til: TextInputLayout): Boolean {
        if (isPasswordValid(et)) {
            til.isErrorEnabled = false
            return true


        } else {
            til.error = context.getString(R.string.password_invalid)
            et.requestFocus()
            return false

        }


    }

    companion object {

        private val PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[!@#\$%&*])(?=.*[a-z0-9]).{6,}\$".toRegex()

    }


}