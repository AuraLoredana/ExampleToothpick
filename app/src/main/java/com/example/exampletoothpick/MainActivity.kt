package com.example.exampletoothpick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exampletoothpick.car.Audi
import com.example.exampletoothpick.car.Car
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import toothpick.Toothpick
import toothpick.config.Module

class MainActivity : AppCompatActivity() {

    @Inject lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = Toothpick.openScopes(application, this)

        scope.installModules(object : Module() {
            init {
                bind(Car::class.java).to(Audi::class.java)
            }
        })

        Toothpick.inject(this, scope)

        tv.text = car.getEngineType()
    }

    override fun onDestroy() {
        Toothpick.closeScope(this)

        super.onDestroy()
    }
}


