package com.ahmetaktekin.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class veritabani(val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val getData = inputData
        val myNumber = getData.getInt("intKey",555)
        refleshdatabase(myNumber)
        return Result.success()
    }
    private fun  refleshdatabase(myNumber:Int){
        val sp = context.getSharedPreferences("com.ahmetaktekin.workmanager",Context.MODE_PRIVATE)
        var saveNumber = sp.getInt("myNumber",0)
        saveNumber = saveNumber+myNumber
        println(saveNumber)
        sp.edit().putInt("myNumber",saveNumber).apply()
    }
}