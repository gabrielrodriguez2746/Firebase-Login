package com.firebase.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firebase.core.extensions.show
import com.firebase.login.data.LoginRepository
import com.firebase.login.databinding.ActivityMainBinding
import com.firebase.login.viewModels.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val signInOptions: GoogleSignInOptions by lazy {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
    }

    private val client: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(this, signInOptions)
    }

    private val repository: LoginRepository by lazy {
        LoginRepository(client)
    }
    private val viewModel: LoginViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.state.observe(this,
            Observer {
                Toast.makeText(this, "State :: $it", Toast.LENGTH_SHORT).show()
                processState(it)
            })
        viewModel.login()
    }

    private fun processState(state: LoginViewModel.LoginViewModelState) {
        when(state) {
            LoginViewModel.LoginViewModelState.NotLoggedUserError -> {
                binding.textView.text = "Un momento"//getString(R.string.login)
                binding.button.show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}
