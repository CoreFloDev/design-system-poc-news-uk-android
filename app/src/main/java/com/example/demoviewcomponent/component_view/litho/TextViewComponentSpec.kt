package com.example.demoviewcomponent.component_view.litho

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text

@LayoutSpec
object TextViewComponentSpec {

    @JvmStatic
    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext, @Prop title: String): Component =
        Text.create(c)
            .text(title)
            .textSizeDip(14f)
            .build()
}
