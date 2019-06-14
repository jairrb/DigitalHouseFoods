package br.com.digitalhouse.digitalhousefoods.detail;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.adapters.RecycleViewAdapterMenu;
import br.com.digitalhouse.digitalhousefoods.detailmenu.DetailMenuActivity;
import br.com.digitalhouse.digitalhousefoods.interfaces.RecycleViewClickListenerMenu;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantMenu;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements RecycleViewClickListenerMenu {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        // Add findViewById para recycler
        RecyclerView recyclerViewMenu = view.findViewById(R.id.recyclerViewRestaurantMenu);
        Restaurant restaurant = getArguments().getParcelable("RESTAURANT");


        if (restaurant != null) {
            List<RestaurantMenu> restaurantMenus = restaurant.getRestaurantMenus();
            RecycleViewAdapterMenu adapter = new RecycleViewAdapterMenu(restaurantMenus,  this);
            recyclerViewMenu.setLayoutManager(new GridLayoutManager(getContext(),2));
            recyclerViewMenu.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onClick(RestaurantMenu restaurantmenu) {
        Intent intent = new Intent(getContext(), DetailMenuActivity.class);
        intent.putExtra("RESTAURANTMENU", restaurantmenu);
        startActivity(intent);

    }
}
