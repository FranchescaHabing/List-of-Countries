package com.example.listofcountries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.listofcountries.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.afghanistan, R.drawable.australia, R.drawable.china, R.drawable.egypt, R.drawable.germany, R.drawable.japan, R.drawable.netherlands, R.drawable.malaysia, R.drawable.philippines};
        String[] countryN = { "Afghanistan", "Australia", "China", "Egypt", "Germany", "Japan", "Netherlands", "Malaysia", "Philippines"};
        String[] capital = {"Kabul", "Canberra", "Beijing", "Cairo", "Berlin", "Tokyo", "Kuala Lumpur", "Amsterdam", "Manila"};
        String[] region = {"Asia", "Oceania", "Asia", "Middle East", "Asia", "Asia", "Europe", "Asia", "Asia"};
        String[] abbreviation = {"AFGH", "Au", "CN", "EG", "DE", "JP", "NL", "MY", "PH"};
        String[] callingCodes = {"+93", "+61", "+86 (Mainland),+852 (Hong Kong),+853 (Macau)", "+20", "+49", "+81", "+31", "+60", "+63"};
        String[] population = {"33,413,000", " 25,874,400", "1,411,778,724", "102,334,404", "84,117,886", "125,994,267", "17,182,343", "32,898,401", "111,400,560 "};
        String[] currencies = {" Afghani afghani(Af/؋) (AFN)", "Australian dollar($) (AUD)", "Chinese Yuan Renminbi(元/¥) (CNY)", "Egyptian Pound(E£) (EGP)", "Euro(€) (EUR)", " Yen/円 (¥) (JPY)", "Euro(€) (EUR)", "Malaysian ringgit(RM) (MYR)", "Philippine Peso(₱) (PHP)"};
        String[] languages = {"Pashto & Dari", "English", "Standard Chinese/Mandarin Chinese", "Modern Standard Arabic", "German", "Japanese", "Dutch", "Malaysian", "Filipino & English"};
        String[] borders = {"It borders Tajikistan, Turkmenistan, and Uzbekistan to the north, Iran to the west, Pakistan to the east and south.",
                "As Australia is an island, it has no land borders with other nations.",
                "China is bordered by 14 countries: Afghanistan, Bhutan, India, Kazakhstan, North Korea, Kyrgyzstan, Laos, Mongolia, Myanmar (Burma), Nepal, Pakistan, Russia, Tajikistan, and Vietnam.",
                "Egypt borders Libya to the west, the Gaza Strip to the northeast, Israel to the east and Sudan to the south.",
                "It shares borders with nine countries: Denmark in the north, Poland and the Czech Republic in the east, Switzerland (its only non-EU neighbor) and Austria in the south, France in the southwest and Belgium, Luxembourg and the Netherlands in the west.",
                "The island nation stretches from the Sea of Okhotsk in the north to the East China Sea in the south.",
                "The Netherlands is bounded by the North Sea to the north and west, Germany to the east, and Belgium to the south.",
                "The borders of Malaysia include land and maritime borders with Brunei, Indonesia and Thailand and shared maritime boundaries with Philippines, Singapore and Vietnam.",
                "The Philippines is bounded by the South China Sea to the west, the Philippine Sea to the east, and the Celebes Sea to the southwest."};

        //listView = findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryN);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, abbreviation);
        //listView.setAdapter(arrayAdapter);

        ArrayList<Country> countryArrayList = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++) {
            Country country = new Country(countryN[i], capital[i], region[i], abbreviation[i], callingCodes[i], population[i], currencies[i], languages[i], borders[i], imageId[i]);
            countryArrayList.add(country);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this, countryArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("countryN", countryN[position]);
                i.putExtra("capital", capital[position]);
                i.putExtra("region", region[position]);
                i.putExtra("abbreviation", abbreviation[position]);
                i.putExtra("callingCodes", callingCodes[position]);
                i.putExtra("population", population[position]);
                i.putExtra("currencies", currencies[position]);
                i.putExtra("languages", languages[position]);
                i.putExtra("borders", borders[position]);
                i.putExtra("imageId", imageId[position]);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type country name or abbreviation");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}