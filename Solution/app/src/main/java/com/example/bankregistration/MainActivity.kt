package com.example.bankregistration

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bankregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        binding.registrationViewModel = viewModel
        binding.lifecycleOwner = this

        binding.nextButton.setOnClickListener{
            if(!viewModel.validatePAN()){
                Toast.makeText(this,"Enter valid PAN",Toast.LENGTH_LONG).show()
            }
            else if(!viewModel.validateDOB()){
                Toast.makeText(this,"Enter valid BirthDate",Toast.LENGTH_LONG).show()
            }
            else{
                showDetailsSubmitted()
            }
        }

        binding.noPanButton.setOnClickListener{
            finish()
        }
    }

    private fun showDetailsSubmitted()
    {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Details submitted\n" +
                "successfully")
        builder.setPositiveButton("OK"){_,_ ->
            finish()
        }
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}