package com.example.demoviewcomponent.component_view.litho

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import com.example.demoviewcomponent.arch.View
import com.example.demoviewcomponent.component_view.ComponentInput
import com.example.demoviewcomponent.component_view.ComponentOutput
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class ComponentLithoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), View<ComponentInput, ComponentOutput> {

    private val lithoView: LithoView
    private val componentContext = ComponentContext(context)

    init {
        lithoView = LithoView.create(
            context,
            TextViewComponent.create(componentContext)
                .title("initial title")
                .build()
        )
        addView(lithoView)
    }

    override fun render(input: ComponentInput) {
        when (input) {
            is ComponentInput.Display -> lithoView.setComponentAsync(
                TextViewComponent.create(componentContext)
                    .title(input.text)
                    .build()
            )
        }
    }

}
