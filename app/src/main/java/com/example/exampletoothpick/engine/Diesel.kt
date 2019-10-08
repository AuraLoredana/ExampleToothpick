package com.example.exampletoothpick.engine

import javax.inject.Inject

class Diesel @Inject constructor(): Engine {
    override fun getType(): String {
        return "Diesel"
    }
}