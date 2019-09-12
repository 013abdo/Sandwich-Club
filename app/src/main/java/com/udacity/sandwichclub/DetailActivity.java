package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

import static com.udacity.sandwichclub.utils.JsonUtils.parseSandwichJson;


public class DetailActivity extends AppCompatActivity {

   Sandwich sandwich;
    TextView Origin,

    ingredient,Kownas,Descript,name;

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        name = findViewById(R.id.Name_tv);
        Origin=findViewById(R.id.origin_tv);
        ingredient= findViewById(R.id.ingredients_tv);
        Kownas = findViewById(R.id.also_known_tv);
        Descript= findViewById(R.id.description_tv);
        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
         sandwich = parseSandwichJson(json);


        //todo
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI( ) {
        name.setText(sandwich.getMainName());
        Origin.setText(sandwich.getPlaceOfOrigin());
        System.out.println(Origin);
            Kownas.setText(sandwich.getAlsoKnownAs().toString());

        System.out.println(Kownas);
        Descript.setText(sandwich.getDescription());
        ingredient.setText(sandwich.getIngredients().toString());
    }


}
