package com.yongjincomapny.dreamcometrue.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseActivity
import com.yongjincomapny.dreamcometrue.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    override fun observe() {
        super.observe()

    }

    override fun init() {
        super.init()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_main_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.main_nav_graph)
    }
}