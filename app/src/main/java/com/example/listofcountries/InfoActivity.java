package com.example.listofcountries;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listofcountries.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_info);

        Intent intent = this.getIntent();
        if (intent != null)
        {
            String countryN = intent.getStringExtra( "countryN");
            String capital = intent.getStringExtra( "capital");
            String region = intent.getStringExtra( "region");
            String abbreviation = intent.getStringExtra( "abbreviation");
            String callingCodes = intent.getStringExtra( "callingCodes");
            String population = intent.getStringExtra( "population");
            String currencies = intent.getStringExtra( "currencies");
            String languages = intent.getStringExtra( "languages");
            String borders = intent.getStringExtra( "borders");
            int imageId = intent.getIntExtra("imageId",R.drawable.afghanistan);

            binding.countryName.setText(countryN);
            binding.capitalName.setText(capital);
            binding.region.setText(region);
            binding.abbv.setText(abbreviation);
            binding.code.setText(callingCodes);
            binding.popul.setText(population);
            binding.currencyS.setText(currencies);
            binding.lang.setText(languages);
            binding.border.setText(borders);
            binding.countryFlag.setImageResource(imageId);
        }
    }
}
