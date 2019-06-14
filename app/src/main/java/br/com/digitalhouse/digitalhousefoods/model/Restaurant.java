package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Restaurant implements Parcelable {
    private String name;
    private String andress;
    private String hour;
    private int photo;
    private List<RestaurantMenu> restaurantMenus;

    public Restaurant() {
    }

    public Restaurant(String name, String andress, String hour, int photo, List<RestaurantMenu> restaurantMenus) {
        this.name = name;
        this.andress = andress;
        this.hour = hour;
        this.photo = photo;
        this.restaurantMenus = restaurantMenus;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
        andress = in.readString();
        hour = in.readString();
        photo = in.readInt();
        restaurantMenus = in.createTypedArrayList(RestaurantMenu.CREATOR);
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(andress);
        dest.writeString(hour);
        dest.writeInt(photo);
        dest.writeTypedList(restaurantMenus);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public List<RestaurantMenu> getRestaurantMenus() {
        return restaurantMenus;
    }

    public void setRestaurantMenus(List<RestaurantMenu> restaurantMenus) {
        this.restaurantMenus = restaurantMenus;
    }
}
