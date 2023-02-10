package fr.isen.vasselin.androiderestaurant

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EntreeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_entree_details)

        val headingDetails : TextView = findViewById(R.id.heading)
        val mainDetails : TextView = findViewById(R.id.data)
        val imageDetails : ImageView = findViewById(R.id.imageId)

        val bundle : Bundle?= intent.extras
        val heading =bundle!!.getString("heading")
        val imageId =bundle.getInt("imageId")
        val news =bundle.getString("data")

        headingDetails.text = heading
        mainDetails.text = data
        imageDetails.setImageResource(imageId)
    }
}