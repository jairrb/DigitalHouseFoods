package br.com.digitalhouse.digitalhousefoods.detail;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.home.HomeFragment;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantMenu;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewRestaurant;
    private TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewName = findViewById(R.id.textViewName);
        imageViewRestaurant = findViewById(R.id.imageViewRestaurant);

        Restaurant restaurant = getIntent().getParcelableExtra("RESTAURANT");

        if (restaurant != null) {
            textViewName.setText(restaurant.getName());
            imageViewRestaurant.setImageDrawable(ContextCompat
                    .getDrawable(imageViewRestaurant.getContext(), restaurant.getPhoto()));

            Bundle bundle = new Bundle();
            bundle.putParcelable("RESTAURANT",restaurant);
            Fragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);
            replaceFragment(detailFragment);
        }

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerMenu,fragment)
                .commit();
    }
}
