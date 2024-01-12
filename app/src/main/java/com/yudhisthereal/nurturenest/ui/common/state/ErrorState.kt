package com.yudhisthereal.nurturenest.ui.common.state

import androidx.annotation.StringRes
import com.yudhisthereal.nurturenest.R

data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.default_error_msg
)