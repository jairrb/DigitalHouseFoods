package br.com.digitalhouse.digitalhousefoods.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RestaurantMenu implements Parcelable {
    private String name;
    private String description;
    private int photo;

    public RestaurantMenu() {
    }

    public RestaurantMenu(String name, String description, int photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }


    protected RestaurantMenu(Parcel in) {
        name = in.readString();
        description = in.readString();
        photo = in.readInt();
    }

    public static final Creator<RestaurantMenu> CREATOR = new Creator<RestaurantMenu>() {
        @Override
        public RestaurantMenu createFromParcel(Parcel in) {
            return new RestaurantMenu(in);
        }

        @Override
        public RestaurantMenu[] newArray(int size) {
            return new RestaurantMenu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(photo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
