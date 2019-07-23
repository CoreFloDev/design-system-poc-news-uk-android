package com.example.demoviewcomponent

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.applitools.eyes.android.espresso.Eyes
import com.example.demoviewcomponent.component_view.ComponentInput
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApplitoolsTest {

    @get:Rule
    var activityRule: ActivityTestRule<ComponentTestActivity> =
        ActivityTestRule(ComponentTestActivity::class.java, false, false)

    @Test
    fun evaluateApplitools() {

        val eyes = Eyes()
        eyes.apiKey = "rHpHz6cDGtfXK6zsSKGFZJMkLixRpZI06llxB85Bnf0110"

        activityRule.launchActivity(Intent())
        eyes.open("MyTestApp", "evaluation test")

        try {
            for (i in 1..200) {

                activityRule.activity.renderSubject.onNext(
                    ComponentTestActivity.ComponentToTest(
                        classPath = if (i.rem(2) == 0) "com.example.demoviewcomponent.component_view.litho.ComponentLithoView" else "com.example.demoviewcomponent.component_view.android.ComponentNativeView",
                        stateToTest = ComponentInput.Display("my text $i")
                    )
                )

                eyes.checkWindow("screen test $i")

            }
            eyes.close()
        } finally {
            eyes.abortIfNotClosed()
        }

    }
}
