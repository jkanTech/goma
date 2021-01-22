package com.github.jkantech.goma

interface OnResponseListener {
    fun onSuccess(response: String?)
    fun onError(error: String?)
}