package com.ahmetaktekin.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = Data.Builder().putInt("intKey",1).build()
        val constrait = Constraints.Builder().
                setRequiresCharging(false).build()
        //constrait dediği bu işlem ne olduğu zaman olacak
        //örneğin internet bağlı olduğu zaman batarya dolu olduğu zaman gibi birüsür işlemi belirleyebiliriz
        /*val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<veritabani>()
            .setConstraints(constrait).setInputData(data).setInitialDelay(5,TimeUnit.SECONDS)
            .addTag("Benim Tagım").build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)*/

        val workManager :PeriodicWorkRequest = PeriodicWorkRequestBuilder<veritabani>(15,TimeUnit.MINUTES)
                //en az 15 dakikadan düşük sürede bu işlemi yapamazsın bilgisini verdik
            .setConstraints(constrait).setInputData(data).build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}