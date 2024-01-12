package com.yudhisthereal.nurturenest.ui.screens.unauthenticated.login.state

import com.yudhisthereal.nurturenest.R
import com.yudhisthereal.nurturenest.ui.common.state.ErrorState

val emailOrPhoneEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_phone
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)