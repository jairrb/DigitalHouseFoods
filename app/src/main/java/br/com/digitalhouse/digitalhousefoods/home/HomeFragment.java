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

        restaurants.add(new Restaurant("Outback Steakhouse", "Av. Paulista, 1230 - Bela Vista, São Paulo", "00:00", R.drawable.restaurant_outback, getMenuRestaurant(1)));
        restaurants.add(new Restaurant("Sí Señor!", "Alameda Santos, 1203 - Jardim Paulista, São Paulo", "22:00", R.drawable.restaurant_sisenor, getMenuRestaurant(2)));
        restaurants.add(new Restaurant("Coco Bambu", "Av. Antônio Joaquim de Moura Andrade, 737, São Paulo", "01:00", R.drawable.restaurant_coco, getMenuRestaurant(3)));
        restaurants.add(new Restaurant("Chalezinho", "Rua Itapimirum, 11 - Morumbi, São Paulo", "02:00", R.drawable.restaurant_chale, getMenuRestaurant(4)));
        restaurants.add(new Restaurant("Madero Steak House!", "Av. Bandeira Paulista, 823 - Itaim Bibi, São Paulo", "00:00", R.drawable.restaurant_madero, getMenuRestaurant(5)));



        return restaurants;
    }

    private List<RestaurantMenu> getMenuRestaurant(int id) {
        List<RestaurantMenu> restaurantMenu = new ArrayList<>();

        switch (id){
            case 1:
                restaurantMenu.add(new RestaurantMenu("The Outback Special 325g","Um steak especial: nosso clássico miolo de alcatra com sabor acentuado pelos temperos do Outback. Preparado na chapa no ponto que você preferir.",R.drawable.outback_a));
                restaurantMenu.add(new RestaurantMenu("Herb Crusted Filet","São três cortes de filet mignon temperados com ervas finas, servidos com molho Cabernet Merlot. A exclusiva combinação de Arroz Pilaf e cebolas grelhadas é a sugestão da casa para acompanhar.",R.drawable.outback_b));
                restaurantMenu.add(new RestaurantMenu("New York Strip Steak","375g do corte nobre do contra-filet, perfeitamente temperado e preparado na chapa.",R.drawable.outback_c));
                restaurantMenu.add(new RestaurantMenu("Victoria’s Filet","230g do mais suculento filet mignon preparado no estilo Outback. *produto não disponível nos restaurantes de Ribeirão Preto, Sorocaba e S. José do Rio Preto.",R.drawable.outback_d));

            case 2:
                restaurantMenu.add(new RestaurantMenu("Lumberjack","Banquete do mais tenro e suculento corte especial de Angus Black muito bem acompanhado de nossas crocantes batatas rústicas e nossa insuperável cebola roxa marinada. ",R.drawable.sisenor_a));
                restaurantMenu.add(new RestaurantMenu("American Barbecue","Farta porção de hamburguinhos caseiros, galeto marinado e linguiça artesanal grelhados e servidos com a nossa imbatível cebola caramelizada. ",R.drawable.sisenor_b));
                restaurantMenu.add(new RestaurantMenu("Fajitas","As Fajitas são um dos mais tradicionais pratos da culinária TEX-MEX. Acompanhadas de nachos, tortillas, frijoles, guacamole, molho sour mex e pico de gallo. ",R.drawable.sisenor_c));
                restaurantMenu.add(new RestaurantMenu("Wine Shake de Pitaya","Nosso delicioso shake a base de vinho, sorvete de limão e pitaya.",R.drawable.sisenor_d));
            case 3:
                restaurantMenu.add(new RestaurantMenu("Tilápia à Meunière","400g de filet de tilápia grelhado com molho especial de alcaparras, champignon e arroz com brócolis e legumes.",R.drawable.coco_a));
                restaurantMenu.add(new RestaurantMenu("Carne de Sol do Maranhão","Carne de Sol de filé e baião de dois. Acompanha farofa de ovos, banana à milanesa, cebola refogada, purê de macaxeira e vinagrete.",R.drawable.coco_b));
                restaurantMenu.add(new RestaurantMenu("Camarões Grelhados","Camarões preparados com alho e salsinha no azeite de ervas. Acompanha arroz de brócolis e cenoura, batata, brócolis, champignon, ervilha, abobrinha.",R.drawable.coco_c));
                restaurantMenu.add(new RestaurantMenu("Ratatouille","Deliciosa receita com tomate, berinjela, cebola roxa e abobrinha. Preparada ao forno com ervas e alho confitado",R.drawable.coco_d));
            case 4:
                restaurantMenu.add(new RestaurantMenu("Quattro Formaggi","Fondue com queijos ementhal, gruyère, estepe e gorgonzola ",R.drawable.chale_a));
                restaurantMenu.add(new RestaurantMenu("Lindt Classic","Com mais puro chocolate suíço ao leite",R.drawable.chale_b));
            case 5:
                restaurantMenu.add(new RestaurantMenu("Codeiro Super","Hamburger de cordeiro no delicioso pão madero",R.drawable.madero_a));
                restaurantMenu.add(new RestaurantMenu("Junior Bacon","Hamburger e bacon no delicioso pão madero",R.drawable.madero_b));

        }


        return restaurantMenu;
    }

    @Override
    public void onClick(Restaurant restaurant) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("RESTAURANT", restaurant);
        startActivity(intent);
    }
}
