package com.esa.harita_son

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esa.harita_son.ui.theme.Harita_sonTheme
import kotlinx.coroutines.internal.ThreadSafeHeap

class MainActivity : ComponentActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<LocationGroups>
    lateinit var imageId: Array<Int>
    lateinit var heading : Array <String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        imageId = arrayOf(
            R.drawable.kizilay,
            R.drawable.yesilay,
            R.drawable.baby
        )
        heading = arrayOf(
            "KIZILAY",
            "YESILAY",
            "SMA"
        )
        newRecyclerView = findViewById(R.id.recyclerV  iew)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<LocationGroups>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in imageId.indices){
            val locationGroups = LocationGroups(imageId[i],heading[i])
            newArrayList.add(locationGroups)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
            }
        })
    }

}