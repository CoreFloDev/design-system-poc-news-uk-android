package com.example.demoviewcomponent.component_view.android

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatTextView
import com.example.demoviewcomponent.arch.View
import com.example.demoviewcomponent.component_view.ComponentInput
import com.example.demoviewcomponent.component_view.ComponentOutput

class ComponentNativeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : View<ComponentInput, ComponentOutput>, AppCompatTextView(context, attrs, defStyleAttr) {

    override fun render(input: ComponentInput) {
        when (input) {
            is ComponentInput.Display -> text = input.text
        }
    }

}
