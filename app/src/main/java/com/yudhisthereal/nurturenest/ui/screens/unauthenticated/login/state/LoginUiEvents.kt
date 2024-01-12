package com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state

sealed class LoginUiEvent {
    data class EmailOrPhoneChanged(val inputValue: String) : LoginUiEvent()
    data class PasswordChanged(val inputValue: String) : LoginUiEvent()
    data object Submit : LoginUiEvent()
}