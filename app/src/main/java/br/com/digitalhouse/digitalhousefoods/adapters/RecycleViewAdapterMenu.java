package br.com.digitalhouse.digitalhousefoods.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.interfaces.RecycleViewClickListenerMenu;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantMenu;

public class RecycleViewAdapterMenu extends RecyclerView.Adapter<RecycleViewAdapterMenu.ViewHolder>{
    private List<RestaurantMenu> restaurantList;
    private RecycleViewClickListenerMenu listener;

    public RecycleViewAdapterMenu(List<RestaurantMenu> restaurantList, RecycleViewClickListenerMenu listener) {
        this.restaurantList = restaurantList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecycleViewAdapterMenu.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurantmenu_recycleview_item,viewGroup,false);
        return new RecycleViewAdapterMenu.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterMenu.ViewHolder viewHolder, int i) {
        final RestaurantMenu restaurantmenu = restaurantList.get(i);
        viewHolder.bind(restaurantmenu);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurantmenu);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewPhoto;
        private TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewRestaurant);
            textViewName = itemView.findViewById(R.id.textViewName);
        }

        public void bind(RestaurantMenu restaurantmenu){

            imageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewPhoto.getContext(), restaurantmenu.getPhoto()));
            textViewName.setText(restaurantmenu.getName());

        }
    }
}
