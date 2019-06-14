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
import br.com.digitalhouse.digitalhousefoods.interfaces.RecycleViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private List<Restaurant> restaurantList;
    private RecycleViewClickListener listener;

    public RecycleViewAdapter(List<Restaurant> restaurantList, RecycleViewClickListener listener) {
        this.restaurantList = restaurantList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurant_recycleview_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder viewHolder, int i) {
        final Restaurant restaurant = restaurantList.get(i);
        viewHolder.bind(restaurant);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurant);
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
        private TextView textViewAndress;
        private TextView textViewHour;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewRestaurant);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAndress = itemView.findViewById(R.id.textViewAndress);
            textViewHour = itemView.findViewById(R.id.textViewHour);
        }

        public void bind(Restaurant restaurant){

            imageViewPhoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewPhoto.getContext(), restaurant.getPhoto()));
            textViewName.setText(restaurant.getName());
            textViewAndress.setText(restaurant.getAndress());
            textViewHour.setText(restaurant.getHour());

        }
    }
}
