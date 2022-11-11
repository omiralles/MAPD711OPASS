package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.databinding.ActivityDetailsBinding
import com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.vm.FragranceViewModel
import com.squareup.picasso.Picasso

/**
 * Second activity to show fragrance details.
 * Retrieve fragrance information from a service.
 */
class DetailsActivity :  AppCompatActivity() {
    //Binding activity
    lateinit var binding: ActivityDetailsBinding
    //Create ViewModel
    private lateinit var viewModel: FragranceViewModel
    var productNumber: String = ""

    companion object {
        private const val TAG = "DetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get selected card number
        productNumber = intent.getStringExtra("productNumber").toString()

        //Create ViewModel
        viewModel  = ViewModelProvider(this)[FragranceViewModel::class.java]

        //Retrieve the data based on the card selected
        when (productNumber) {
            "One" -> {
                //Observe creation to get the product data and put it on components
                viewModel.firstProductLiveData?.observe(this){
                    binding.titleText.text = it.title
                    binding.toolbar.title = it.title
                    binding.brandText.text = it.brand
                    binding.ratingText.text = it.rating.toString()
                    binding.descriptionText.text = it.description
                    Picasso.get().load(it.thumbnail).into(binding.perfumeImage)
                }
                viewModel.getFirstProduct()
            }
            "Two" -> {
                //Observe creation to get the product data and put it on components
                viewModel.secondProductLiveData?.observe(this){
                    binding.titleText.text = it.title
                    binding.toolbar.title = it.title
                    binding.brandText.text = it.brand
                    binding.ratingText.text = it.rating.toString()
                    binding.descriptionText.text = it.description
                    Picasso.get().load(it.thumbnail).into(binding.perfumeImage)
                }
                viewModel.getSecondProduct()
            }
            "Three" -> {
                //Observe creation to get the product data and put it on components
                viewModel.thirdProductLiveData?.observe(this){
                    binding.titleText.text = it.title
                    binding.toolbar.title = it.title
                    binding.brandText.text = it.brand
                    binding.ratingText.text = it.rating.toString()
                    binding.descriptionText.text = it.description
                    Picasso.get().load(it.thumbnail).into(binding.perfumeImage)
                }
                viewModel.getThirdProduct()
            }
            "Four" -> {
                //Observe creation to get the product data and put it on components
                viewModel.fourthProductLiveData?.observe(this){
                    binding.titleText.text = it.title
                    binding.toolbar.title = it.title
                    binding.brandText.text = it.brand
                    binding.ratingText.text = it.rating.toString()
                    binding.descriptionText.text = it.description
                    Picasso.get().load(it.thumbnail).into(binding.perfumeImage)
                }
                viewModel.getFourthProduct()
            }
            "Five" -> {
                //Observe creation to get the product data and put it on components
                viewModel.fifthProductLiveData?.observe(this){
                    binding.titleText.text = it.title
                    binding.toolbar.title = it.title
                    binding.brandText.text = it.brand
                    binding.ratingText.text = it.rating.toString()
                    binding.descriptionText.text = it.description
                    Picasso.get().load(it.thumbnail).into(binding.perfumeImage)
                }
                viewModel.getFifthProduct()
            }
        }

        //First attempt
        //getData()
    }

    /**
     * Function to get data from service. Function discarded for the use of ViewModel.
     */
    /*private fun getData() {
        var baseURL = "https://dummyjson.com/products/"

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofit = retrofitBuilder.create(FragranceAPI::class.java)

        val call: Call<FragranceResponse>?

        if (productNumber == "One"){
            call = retrofit.getProductOne()
        }
        else if (productNumber == "Two") {
            call = retrofit.getProductTwo()
        }
        else if (productNumber == "Three") {
            call = retrofit.getProductThree()
        }
        else if (productNumber == "Four") {
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

                        binding.titleText.text = title
                        binding.toolbar.title = title
                        binding.brandText.text = brand
                        binding.ratingText.text = rating.toString()
                        binding.descriptionText.text = description
                        Picasso.get().load(thumbnail).into(binding.perfumeImage)
                    }
                }
            }

            override fun onFailure(call: Call<FragranceResponse?>?, t: Throwable?) {
                Toast.makeText(this@DetailsActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }*/
}