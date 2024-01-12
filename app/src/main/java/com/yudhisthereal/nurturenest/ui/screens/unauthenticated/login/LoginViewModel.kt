package com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.yudhisthereal.nurturenest.ui.common.state.ErrorState
import com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state.LoginErrorState
import com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state.LoginState
import com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state.LoginUiEvent
import com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state.emailOrPhoneEmptyErrorState
import com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state.passwordEmptyErrorState

class LoginViewModel : ViewModel() {

    var loginState = mutableStateOf(LoginState())
        private set

    /**
     * Function called on any login event [LoginUiEvent]
     */
    fun onUiEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {

            // Email/Phone changed
            is LoginUiEvent.EmailOrPhoneChanged -> {
                loginState.value = loginState.value.copy(
                    emailOrPhone = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        emailOrPhoneErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            emailOrPhoneEmptyErrorState
                    )
                )
            }

            // Password changed
            is LoginUiEvent.PasswordChanged -> {
                loginState.value = loginState.value.copy(
                    password = loginUiEvent.inputValue,
                    errorState = loginState.value.errorState.copy(
                        passwordErrorState = if (loginUiEvent.inputValue.trim().isNotEmpty())
                            ErrorState()
                        else
                            passwordEmptyErrorState
                    )
                )
            }

            // Submit Login
            is LoginUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if (inputsValidated) {
                    // TODO Trigger login in authentication flow
                    loginState.value = loginState.value.copy(isLoginSuccessful = true)
                }
            }
        }
    }

    /**
     * Function to validate inputs
     * Ideally it should be on domain layer (usecase)
     * @return true -> inputs are valid
     * @return false -> inputs are invalid
     */
    private fun validateInputs(): Boolean {
        val emailOrPhoneString = loginState.value.emailOrPhone.trim()
        val passwordString = loginState.value.password
        return when {

            // Email/Phone empty
            emailOrPhoneString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        emailOrPhoneErrorState = emailOrPhoneEmptyErrorState
                    )
                )
                false
            }

            //Password Empty
            passwordString.isEmpty() -> {
                loginState.value = loginState.value.copy(
                    errorState = LoginErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                loginState.value = loginState.value.copy(errorState = LoginErrorState())
                true
            }
        }
    }

}


