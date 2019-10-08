package com.example.exampletoothpick.car

import com.example.exampletoothpick.engine.Engine
import javax.inject.Inject

class Audi @Inject constructor() : Car {
    @Inject lateinit var engine: Engine

    override fun getEngineType() = engine.getType()
}