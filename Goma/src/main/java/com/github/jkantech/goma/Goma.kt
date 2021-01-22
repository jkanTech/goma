package com.github.jkantech.goma

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

object Goma {
    private lateinit var appContext: Context
    private var URL: String = ""
    private val queue by lazy { Volley.newRequestQueue(appContext) }
    private var params: HashMap<String, String> = HashMap()
    private var TAG="Goma"


    fun init(context: Context,baseURL:String?=null) {
        if(!::appContext.isInitialized) {
            appContext = context.applicationContext
            if (baseURL != null) {
                if (baseURL.isNotEmpty()) {
                    URL = if (baseURL.last().toString() == "/") {
                        baseURL
                    } else {
                        "$baseURL/"
                    }
                }
            }

        }
    }

    fun get(path: String, listener: OnResponseListener?) {

        val req = StringRequest(
                Request.Method.GET,
                "$URL$path",
                { p1 -> listener?.onSuccess(p1) }) { p1 ->
            if (listener != null) {
                listener.onError(p1.message)
                p1.printStackTrace()
            }
        }
        queue.add(req)
    }


    fun post(
            path: String,
            parameters: HashMap<String, String>? = null,
            listener: OnResponseListener?
    ) {
        if (parameters != null) {
            params = parameters
        }
        postRequest("$URL${checkPath(path)}", params, listener)

    }


    fun del(
            path: String,
            parameters: HashMap<String, String>? = HashMap(),
            listener: OnResponseListener?
    ) {
        if (parameters != null) {
            params = parameters
        }
        delRequest("$URL${checkPath(path)}", params, listener)

    }

    fun put(
            path: String,
            parameters: HashMap<String, String>? = HashMap(),
            listener: OnResponseListener?
    ) {
        if (parameters != null) {
            params = parameters
        }
        putRequest("$URL${checkPath(path)}", params, listener)


    }


    /*--------------------------------------------CANCEL----------------------------------------------*/

    fun cancel() {
        queue.cancelAll("Called")
    }

    fun stop() {
        Log.d(TAG,"Stoped")
        queue.stop()
    }


    private fun postRequest(
            path: String,
            parameters: HashMap<String, String>,
            listener: OnResponseListener?
    ) {
        val req =RequestFactory.HttpRequest(
                Request.Method.POST,
                path,
                parameters,
                { p1 -> listener?.onSuccess(p1) }) { p1 ->
            if (listener != null) {
                listener.onError(p1.message)
                p1.printStackTrace()
            }
        }
        queue.add(req)
    }


    private fun delRequest(
            path: String,
            parameters: HashMap<String, String>,
            listener: OnResponseListener?
    ) {
        val req =RequestFactory.HttpRequest(
                Request.Method.DELETE,
                path,
                parameters,
                { p1 -> listener?.onSuccess(p1) }) { p1 ->
            if (listener != null) {
                listener.onError(p1.message)
                p1.printStackTrace()
            }
        }
        queue.add(req)
    }

    private fun putRequest(
            path: String,
            parameters: HashMap<String, String>,
            listener: OnResponseListener?
    ) {
        val req = RequestFactory.HttpRequest(Request.Method.PUT, path, parameters, { p1 -> listener?.onSuccess(p1) }) { p1 ->
                    if (listener != null) {
                        listener.onError(p1.message)
                        p1.printStackTrace()
                    }
                }
        queue.add(req)
    }

    private fun checkPath(path: String?): String {
        if (path!!.first().toString() == "/") {

            return path.removePrefix("/")
        }
        return path

    }



    }



















