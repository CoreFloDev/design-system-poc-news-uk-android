package com.example.demoviewcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoviewcomponent.component_view.ComponentInput
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        h1_view.render(ComponentInput.Display("hello"))
    }
}
