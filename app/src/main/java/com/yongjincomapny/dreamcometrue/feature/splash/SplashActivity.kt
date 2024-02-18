package com.yongjincomapny.dreamcometrue.feature.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseActivity
import com.yongjincomapny.dreamcometrue.databinding.ActivitySplashBinding
import com.yongjincomapny.dreamcometrue.feature.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MainActivity::class.java)

        lifecycleScope.launch {
            delay(2500L)
            startActivity(intent)
        }
    }
}
