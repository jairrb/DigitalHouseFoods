package br.com.digitalhouse.digitalhousefoods.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.adapters.RecycleViewAdapter;
import br.com.digitalhouse.digitalhousefoods.detail.DetailActivity;
import br.com.digitalhouse.digitalhousefoods.interfaces.RecycleViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantMenu;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements RecycleViewClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Add findViewById para recycler
        RecyclerView recyclerViewRestaurant = view.findViewById(R.id.recyclerViewRestaurant);

        RecycleViewAdapter adapter = new RecycleViewAdapter(getRestaurants(), this);
        recyclerViewRestaurant.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRestaurant.setAdapter(adapter);


        return view;
    }

    private List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));
        restaurants.add(new Restaurant("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.restaurant_a, getMenuRestaurant()));

        return restaurants;
    }

    private List<RestaurantMenu> getMenuRestaurant() {
        List<RestaurantMenu> restaurantMenu = new ArrayList<>();
        restaurantMenu.add(new RestaurantMenu("Salada com molho gengibre","blablablablablablablablablablablablablablabla",R.drawable.menu_a));
        restaurantMenu.add(new RestaurantMenu("Salada com molho gengibre","blablablablablablablablablablablablablablabla",R.drawable.menu_a));
        restaurantMenu.add(new RestaurantMenu("Salada com molho gengibre","blablablablablablablablablablablablablablabla",R.drawable.menu_a));
        restaurantMenu.add(new RestaurantMenu("Salada com molho gengibre","blablablablablablablablablablablablablablabla",R.drawable.menu_a));


        return restaurantMenu;
    }

    @Override
    public void onClick(Restaurant restaurant) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("RESTAURANT", restaurant);
        startActivity(intent);
    }
}
