package com.example.demoviewcomponent.component_view

import com.example.demoviewcomponent.arch.ViewInput

sealed class ComponentInput : ViewInput {

    data class Display(val text: String) : ComponentInput()
}
