package com.example.exampletoothpick

import android.app.Application
import com.example.exampletoothpick.engine.Diesel
import com.example.exampletoothpick.engine.Engine
import toothpick.Toothpick
import toothpick.config.Module

class ExampleToothpick: Application() {

    override fun onCreate() {
        super.onCreate()

        val appScope = Toothpick.openScope(this)

        appScope.installModules(object : Module() {
            init {
                bind(Engine::class.java).to(Diesel::class.java)
            }
        })

    }
}
