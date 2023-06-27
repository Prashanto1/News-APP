package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8
        )

        val newsHeadingArray = arrayOf(
            "New Parliament House in New Delhi and by PM Narendra modi ",
            "Russian invasion of Ukraine",
            " Karnataka Assembly election, 2023",
            "Wrestlers Protest LIVE:",
            "When UPSC 2023 result will be declared?",
            "The IPL 2023 final between Chennai Super Kings and Gujarat Titans",
        "Prime Minister Narendra Modi departs for India after concluding his first-ever visit to Egypt, in Cairo",
            "Karnataka's Gruha Jyoti scheme: Here is how to avail free 200 units of power"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content),getString( R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content),
            getString( R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content)
        )

        newsArrayList = arrayListOf()

        for (index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(this) //this is to set the items inside recycleView like (vertically or Horizontal scrolling , uniform grid)

        myAdapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
            override fun onItemCLicking(position: Int) {

                // on clicking each item , what action do u want to perform


                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeding)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)
                startActivity(intent)

            }

        })
    }
}

