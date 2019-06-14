package br.com.digitalhouse.digitalhousefoods.detailmenu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantMenu;

public class DetailMenuActivity extends AppCompatActivity {
    private ImageView imageViewDish;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageViewDish = findViewById(R.id.imageViewDish);

        RestaurantMenu restaurantMenu = getIntent().getParcelableExtra("RESTAURANTMENU");

        if (restaurantMenu != null) {
            textViewName.setText(restaurantMenu.getName());
            textViewDescription.setText(restaurantMenu.getDescription());
            imageViewDish.setImageDrawable(ContextCompat
                    .getDrawable(imageViewDish.getContext(), restaurantMenu.getPhoto()));
        }
    }
}
