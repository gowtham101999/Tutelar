package com.tutelar

import android.app.Activity
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tutelar.core.Logger
import com.tutelar.core.getDetails
import com.tutelar.network.ApiClient
import com.tutelar.service.UpdateWorker
import com.tutelar.utils.Constants
import com.tutelar.utils.Location
import com.tutelar.utils.PermissionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created at: Aug 2022
 * Created by: Gowtham R
 */
object Tutelar {

    private val scope = CoroutineScope(Dispatchers.Main)

    fun init(activity: Activity, key: String) {
        when {
            key.isEmpty() -> {
                Logger.setMessage("Api Key should not be empty!")
            }
            !PermissionManager().checkPermission(activity) -> {
                PermissionManager().askPermission(activity)
            }
            else -> {
                Location(activity).getCurrentLocation()
                scope.launch {
                    val response = ApiClient.getClient.isValidApiKey(key)
                    Constants.isValidClient = response.body()?.status == true
                }
            }
        }
    }

    fun getDeviceDetails(activity: Activity): String {
        return if (Constants.isValidClient) {
            GsonBuilder().setPrettyPrinting().create().toJson(getDetails(activity))
        }else {
            "Invalid Api Key"
        }
    }

    fun logEnabled(value: Boolean) {
        Logger.logEnabled = value
    }
}