package com.example.demoviewcomponent.arch

import io.reactivex.Observable

interface View<I: ViewInput, O: ViewOutput> {

    fun render(input: I)

    fun outputs(): Observable<O> = Observable.empty()

}
