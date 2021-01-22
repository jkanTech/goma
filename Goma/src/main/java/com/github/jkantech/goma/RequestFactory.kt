package com.github.jkantech.goma


import com.android.volley.Response
import com.android.volley.toolbox.StringRequest


interface RequestFactory {
    class HttpRequest(
            method: Int, URL: String?, private val params: HashMap<String, String>,
            listener: Response.Listener<String?>?,
            error: Response.ErrorListener?
    ) : StringRequest(method, URL, listener, error) {
        override fun getParams(): HashMap<String, String> {
            return params
        }

    }
}




