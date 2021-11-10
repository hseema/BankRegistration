package com.example.bankregistration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegistrationViewModel : ViewModel()  {

    val inputDay = MutableLiveData<String>()
    val inputMonth = MutableLiveData<String>()
    val inputYear = MutableLiveData<String>()
    val inputPAN = MutableLiveData<String>()


    fun validatePAN():Boolean{
        val mPattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")

        val mMatcher: Matcher = mPattern.matcher(inputPAN.value.toString())
        return mMatcher.matches()
    }

    fun validateDOB(): Boolean {
        val intDay = inputDay.value?.toInt() ?: 0
        val intMonth = inputMonth.value?.toInt()
        val intYear = inputYear.value?.toString()?.length ?: 0
        return intDay in 1..31 && intMonth in 1..12 && intYear == 4
    }

}