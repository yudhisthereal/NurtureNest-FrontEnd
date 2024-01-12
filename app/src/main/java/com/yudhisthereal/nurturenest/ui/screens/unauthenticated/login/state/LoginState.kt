package com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state

import com.yudhisthereal.nurturenest.ui.common.state.ErrorState

data class LoginState(
    val emailOrPhone: String = "",
    val password: String = "",
    val errorState: LoginErrorState = LoginErrorState(),
    val isLoginSuccessful: Boolean = false
)


data class LoginErrorState(
    val emailOrPhoneErrorState: ErrorState = ErrorState(),
    val passwordErrorState: ErrorState = ErrorState()
)