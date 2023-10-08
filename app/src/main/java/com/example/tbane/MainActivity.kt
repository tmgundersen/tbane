package com.example.tbane

import android.annotation.SuppressLint
import android.content.ContextWrapper
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tbane.ui.theme.TbaneTheme
import java.util.*

class MainActivity : ComponentActivity(), OnClickListener {

    lateinit var etSearch: EditText
    lateinit var tvResultat: TextView
    lateinit var btnClckW: Button

    private var resList = ArrayList<StationData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToList()

        etSearch = findViewById(R.id.etSearch)
        tvResultat = findViewById(R.id.tvResultat)
        btnClckW = findViewById(R.id.btnClckW)


        btnClckW.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        val text = etSearch.text.toString()
        var resIn = ""
        for(i in resList)
            if(i.title.contains(text)) {
                resIn += getString(i.info)
            }
            if(resIn != "") tvResultat.text = resIn else tvResultat.text = getString(R.string.no_such_station)

    }
    private fun addToList(){
        resList.add(StationData("tøyen", R.string.zero))
        resList.add(StationData("carl berner", R.string.one))
        resList.add(StationData("sinsen", R.string.two))
        resList.add(StationData("storo", R.string.three))
        resList.add(StationData("jernbanetorget", R.string.four))
        resList.add(StationData("nationaltheatret", R.string.five))
        resList.add(StationData("stortinget", R.string.six))
        resList.add(StationData("majorstuen", R.string.seven))
        resList.add(StationData("blindern", R.string.eight))
        resList.add(StationData("ullevål", R.string.nine))
        resList.add(StationData("nydalen", R.string.ten))
        resList.add(StationData("grønland", R.string.eleven))
    }

}



