package fr.isen.vasselin.androiderestaurant

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView






class EntreesActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Data>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var data: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_entrees)

        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle("Entrées")
        imageId = arrayOf(
            R.drawable.tartinade_avocat,
            R.drawable.soupe_legumes,
            R.drawable.salade_quinoa,
            R.drawable.caviar_aubergines,

        )
        heading = arrayOf(
            "Tartinade d'avocat et de crevettes",
            "Soupe de légumes aux poisson",
            "Salade de quinoa",
            "Caviar d'aubergines",
        )

        data = arrayOf(
            getString(R.string.Tartinade)
        )

        newRecyclerView= findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Data>()
        getUserdata()

        Log.d("EntreesActivity", "onCreate")
    }

    private fun getUserdata() {
        for(i in imageId.indices){
            val news = Data(imageId[i],heading[i])
            newArrayList.add(news)
        }
        var adapter = MyEntreesAdapter(newArrayList)
        newRecyclerView.adapter = MyEntreesAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object:MyEntreesAdapter.onItemClickListener{


            override fun onItemClick(position: Int) {
                //Toast.makeText(this@EntreesActivity, "You clicked on $position", Toast.LENGTH_SHORT).show()
                //val intent = Intent(this, EntreeDetails::class.java)
                //startActivity(intent)
                val intent = Intent(this@EntreesActivity,EntreeDetails::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleimage)
                intent.putExtra("description",data[position])
                startActivity(intent)

            }



        })
    }




    override fun onPause() {
        super.onPause()
        Log.d("EntreesActivity", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("EntreesActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("EntreesActivity", "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d("EntreesActivity", "onStart")
    }
}



