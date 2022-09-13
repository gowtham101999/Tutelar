package com.tutelar.service

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.tutelar.network.ApiClient
import com.tutelar.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created at: Aug 2022
 * Created by: Gowtham R
 */
class UpdateWorker(context: Context, params: WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {
        val apiKey = inputData.getString("apiKey")
        return try {
            Result.success()
        }catch (e: Exception) {
            Result.failure()
        }
    }

}