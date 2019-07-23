package com.example.demoviewcomponent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.demoviewcomponent.arch.ViewInput
import com.example.demoviewcomponent.arch.ViewOutput
import io.reactivex.android.schedulers.AndroidSchedulers
import com.example.demoviewcomponent.arch.View as ViewComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_component_test.*

class ComponentTestActivity : AppCompatActivity() {

    val renderSubject = PublishSubject.create<ComponentToTest>()
    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_test)

        disposable.add(renderSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            component_root.removeAllViews()
            val view= Class.forName(it.classPath).constructors[0].newInstance(this) as ViewComponent<ViewInput, ViewOutput>
            if (view is View) {
                component_root.addView(view)
            }
            view.render(it.stateToTest)
        })
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    data class ComponentToTest(
        val classPath: String,
        val stateToTest: ViewInput
    )
}
