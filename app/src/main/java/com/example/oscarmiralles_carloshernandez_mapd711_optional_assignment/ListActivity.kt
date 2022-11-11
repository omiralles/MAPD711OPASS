package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment
/**
 * MAPD711 Optional Assignment
 * @Authors
 * Student Name: Oscar Miralles Fernandez
 * Student ID: 301250756
 * Student Name: Carlos Hernandez Galvez
 * Student ID: 301290263
 **/

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.databinding.ActivityListBinding
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.vm.FragranceViewModel
import com.squareup.picasso.Picasso

/**
 * Function to collect the data and put them into the components.
 * Show 5 fragrance cards from a service.
 * Listeners are also added for the call to the second activity.
 */
class ListActivity: AppCompatActivity() {
    //Binding activity
    lateinit var binding: ActivityListBinding
    //Create ViewModel
    private lateinit var viewModel: FragranceViewModel

    companion object {
        private const val TAG = "ListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Create ViewModel
        viewModel  = ViewModelProvider(this)[FragranceViewModel::class.java]

        //Observe creation to get the product data and put it on components
        viewModel.firstProductLiveData?.observe(this){
            binding.titleTextCard1.text = it.title
            binding.brandTextCard1.text = it.brand
            binding.ratingTextCard1.text = it.rating.toString()
            binding.descriptionTextCard1.text = it.description
            Picasso.get().load(it.thumbnail).into(binding.imageCard1)
        }
        viewModel.getFirstProduct()

        //Observe creation to get the product data and put it on components
        viewModel.secondProductLiveData?.observe(this){
            binding.titleTextCard2.text = it.title
            binding.brandTextCard2.text = it.brand
            binding.ratingTextCard2.text = it.rating.toString()
            binding.descriptionTextCard2.text = it.description
            Picasso.get().load(it.thumbnail).into(binding.imageCard2)
        }
        viewModel.getSecondProduct()

        //Observe creation to get the product data and put it on components
        viewModel.thirdProductLiveData?.observe(this){
            binding.titleTextCard3.text = it.title
            binding.brandTextCard3.text = it.brand
            binding.ratingTextCard3.text = it.rating.toString()
            binding.descriptionTextCard3.text = it.description
            Picasso.get().load(it.thumbnail).into(binding.imageCard3)
        }
        viewModel.getThirdProduct()

        //Observe creation to get the product data and put it on components
        viewModel.fourthProductLiveData?.observe(this){
            binding.titleTextCard4.text = it.title
            binding.brandTextCard4.text = it.brand
            binding.ratingTextCard4.text = it.rating.toString()
            binding.descriptionTextCard4.text = it.description
            Picasso.get().load(it.thumbnail).into(binding.imageCard4)
        }
        viewModel.getFourthProduct()

        //Observe creation to get the product data and put it on components
        viewModel.fifthProductLiveData?.observe(this){
            binding.titleTextCard5.text = it.title
            binding.brandTextCard5.text = it.brand
            binding.ratingTextCard5.text = it.rating.toString()
            binding.descriptionTextCard5.text = it.description
            Picasso.get().load(it.thumbnail).into(binding.imageCard5)
        }
        viewModel.getFifthProduct()

        //First Attempt
        //for(i in 1..5) {
        //    getData(i)
        //}

        //Listener to send data to the new activity
        binding.cardView1.setOnClickListener {
            //Call next activity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("productNumber", "One")
            startActivity(intent)
        }

        //Listener to send data to the new activity
        binding.cardView2.setOnClickListener {
            //Call next activity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("productNumber", "Two")
            startActivity(intent)
        }

        //Listener to send data to the new activity
        binding.cardView3.setOnClickListener {
            //Call next activity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("productNumber", "Three")
            startActivity(intent)
        }

        //Listener to send data to the new activity
        binding.cardView4.setOnClickListener {
            //Call next activity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("productNumber", "Four")
            startActivity(intent)
        }

        //Listener to send data to the new activity
        binding.cardView5.setOnClickListener {
            //Call next activity
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("productNumber", "Five")
            startActivity(intent)
        }
    }

    /**
     * Function to get data from service. Function discarded for the use of ViewModel.
     */
    /*private fun getData(product: Int) {
        var baseURL = "https://dummyjson.com/products/"

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofit = retrofitBuilder.create(FragranceAPI::class.java)

        val call: Call<FragranceResponse>?

        if (product == 1){
            call = retrofit.getProductOne()
        }
        else if (product == 2) {
            call = retrofit.getProductTwo()
        }
        else if (product == 3) {
            call = retrofit.getProductThree()
        }
        else if (product == 4) {
            call = retrofit.getProductFour()
        }
        else {
            call = retrofit.getProductFive()
        }

        call!!.enqueue(object : Callback<FragranceResponse?> {
            override fun onResponse(
                call: Call<FragranceResponse?>?,
                response: Response<FragranceResponse?>?
            ) {
                if (response != null) {
                    if (response.isSuccessful) {
                        val title: String = response.body()!!.title
                        val description: String = response.body()!!.description
                        val brand: String = response.body()!!.brand
                        val rating: Float = response.body()!!.rating
                        val thumbnail: String = response.body()!!.thumbnail

                        if (product == 1){
                            binding.titleTextCard1.text = title
                            binding.brandTextCard1.text = brand
                            binding.ratingTextCard1.text = rating.toString()
                            binding.descriptionTextCard1.text = description
                            Picasso.get().load(thumbnail).into(binding.imageCard1)
                        }
                        else if (product == 2) {
                            binding.titleTextCard2.text = title
                            binding.brandTextCard2.text = brand
                            binding.ratingTextCard2.text = rating.toString()
                            binding.descriptionTextCard2.text = description
                            Picasso.get().load(thumbnail).into(binding.imageCard2)
                        }
                        else if (product == 3) {
                            binding.titleTextCard3.text = title
                            binding.brandTextCard3.text = brand
                            binding.ratingTextCard3.text = rating.toString()
                            binding.descriptionTextCard3.text = description
                            Picasso.get().load(thumbnail).into(binding.imageCard3)
                        }
                        else if (product == 4) {
                            binding.titleTextCard4.text = title
                            binding.brandTextCard4.text = brand
                            binding.ratingTextCard4.text = rating.toString()
                            binding.descriptionTextCard4.text = description
                            Picasso.get().load(thumbnail).into(binding.imageCard4)
                        }
                        else {
                            binding.titleTextCard5.text = title
                            binding.brandTextCard5.text = brand
                            binding.ratingTextCard5.text = rating.toString()
                            binding.descriptionTextCard5.text = description
                            Picasso.get().load(thumbnail).into(binding.imageCard5)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<FragranceResponse?>?, t: Throwable?) {
                Toast.makeText(this@ListActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }*/
}