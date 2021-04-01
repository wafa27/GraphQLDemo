package app.android.wfn.graphqldemo.ui.launchlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.android.wfn.graphqldemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.launch_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    LaunchFragment.newInstance()
                )
                .commitNow()
        }
    }
}