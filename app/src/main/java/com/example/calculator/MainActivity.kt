package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var resultScreen = "0"
    private var firstNum = "0"
    private lateinit var type: String

    private lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        resultScreen = savedInstanceState?.getString("result","0")?:"0"
        type = savedInstanceState?.getString("type","none")?:"none"
        firstNum = savedInstanceState?.getString("firstNum","0")?:"0"

        resultTextView.text = resultScreen
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("result",resultScreen)
        savedInstanceState.putString("type",type)
        savedInstanceState.putString("firstNum", firstNum)
    }

    fun numOnClick(view:View){
        if(resultScreen != "0"){
            resultScreen += (view as Button).text

        }else{
            resultScreen = (view as Button).text as String
        }
        resultTextView.text = resultScreen
    }

    fun timeOnClick(view:View){
        type = "time"
        firstNum = resultScreen
        resultScreen = "0"
        resultTextView.text = resultScreen
    }

    fun plusOnClick(view:View){
        type = "plus"
        firstNum = resultScreen
        resultScreen = "0"
        resultTextView.text = resultScreen
    }

    fun minusOnClick(view:View) {
        type = "minus"
        firstNum = resultScreen
        resultScreen = "0"
        resultTextView.text = resultScreen
    }

    fun equalOnClick(view: View){
        var resultScreenInt = Integer.parseInt(resultScreen)
        var firstNumInt = Integer.parseInt(firstNum)
        firstNum= "0"
        when(type){
            "time" -> {
                resultScreenInt *= firstNumInt
                resultScreen = resultScreenInt.toString()
            }
            "plus" -> {
                resultScreenInt += firstNumInt
                resultScreen = resultScreenInt.toString()
            }
            "minus"->{
                resultScreenInt = firstNumInt - resultScreenInt
                resultScreen = resultScreenInt.toString()
            }
        }
        resultTextView.text = resultScreen
    }

    fun removeOnClick(view:View){
        resultScreen = "0"
        resultTextView.text = resultScreen
    }

    fun backOnClick(view:View){
        resultScreen = if(resultScreen.length != 1){
            resultScreen.slice(0..resultScreen.length - 2)
        }else{
            "0"
        }

        resultTextView.text = resultScreen
    }
}
