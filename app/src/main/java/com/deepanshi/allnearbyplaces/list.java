package com.deepanshi.allnearbyplaces;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Deepanshi Bansal on 06-08-2017.
 */
public class list extends RecyclerView.Adapter<list.CardViewHolder>  {
    ArrayList<Place> places = new ArrayList<>();
    double clong,clat;

    public list(ArrayList<Place> places,double clong,double clat) {
        this.places = places;
        this.clat=clat;
        this.clong=clong;
    }

    @Override
    public list.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View linearLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        CardViewHolder cv = new CardViewHolder(linearLayout);
        return cv;
    }

    @Override
    public void onBindViewHolder(list.CardViewHolder holder, int position) {
        holder.setText(position);
//      holder.telephone.setText(places.get(position).getPhoneNumber().toString());
//        holder.website.setText((CharSequence) places.get(position).getWebsiteUri().toString());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView name, address, distance, type;

        public CardViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            distance = (TextView) itemView.findViewById(R.id.distance);
            type = (TextView) itemView.findViewById(R.id.type);

        }

        public void setText(int position) {
            name.setText(places.get(position).getName().toString());
            address.setText(places.get(position).getAddress().toString());
            type.setText(type(places.get(position).getPlaceTypes().get(0)));
            if (places.get(position).getPlaceTypes().size() == 2) {
                type.append(",\n" + type(places.get(position).getPlaceTypes().get(1)));
            }
            if (places.get(position).getPlaceTypes().size() == 3) {
                type.append(",\n" + type(places.get(position).getPlaceTypes().get(1)));
                type.append(",\n" + type(places.get(position).getPlaceTypes().get(2)));
            }
            LatLng latlng = places.get(position).getLatLng();
            float[] results = new float[1];
            Location.distanceBetween(clat, clong,
                    latlng.latitude,latlng.longitude, results);
            float dist = results[0];
            distance.setText(dist/1000000+" km");
        }
        public String type(int list){
            if(list<100) {
                HashMap<Integer, String> hashmap = new HashMap<>();
                String[] str = {"accounting",
                        "Airport",
                        "Amusement_park",
                        "Aquarium",
                        "Art_gallery",
                        "Atm",
                        "Bakery",
                        "Bank",
                        "Bar",
                        "Beauty_salon",
                        "Bicycle_store",
                        "book_store",
                        "bowling_alley",
                        "bus_station",
                        "cafe",
                        "campground",
                        "car_dealer",
                        "car_rental",
                        "car_repair",
                        "car_wash",
                        "casino",
                        "cemetery",
                        "church",
                        "city_hall",
                        "clothing_store",
                        "convenience_store",
                        "courthouse",
                        "dentist",
                        "department_store",
                        "doctor",
                        "electrician",
                        "electronics_store",
                        "embassy",
                        "establishment",
                        "finance",
                        "fire_station",
                        "florist",
                        "food/restaurant",
                        "funeral_home",
                        "furniture_store",
                        "gas_station",
                        "general_contractor",
                        "grocery_or_supermarket",
                        "gym",
                        "hair_care",
                        "hardware_store",
                        "health",
                        "hindu_temple",
                        "home_goods_store",
                        "hospital",
                        "insurance_agency",
                        "jewelry_store",
                        "laundry",
                        "lawyer",
                        "library",
                        "liquor_store",
                        "local_government_office",
                        "locksmith",
                        "lodging",
                        "meal_delivery",
                        "meal_takeaway",
                        "mosque",
                        "movie_rental",
                        "movie_theater",
                        "moving_company",
                        "museum",
                        "night_club",
                        "painter",
                        "Park",
                        "Parking",
                        "Pet_store",
                        "Pharmacy",
                        "physiotherapist",
                        "place_of_worship",
                        "plumber",
                        "Police",
                        "Post_office",
                        "real_estate_agency",
                        "Restaurant",
                        "Roofing_contractor",
                        "rv_park",
                        "School",
                        "Shoe_store",
                        "Shopping_mall",
                        "spa",
                        "stadium",
                        "storage",
                        "Store",
                        "subway_station",
                        "synagogue",
                        "taxi_stand",
                        "Train_station",
                        "Travel_agency",
                        "University",
                        "veterinary_care",
                        "zoo"};
                for (int i = 1; i <= 96; i++) {
                    hashmap.put(i, str[i - 1]);
                }
                return hashmap.get(list);
            }
            else {
                HashMap<Integer, String> map = new HashMap<>();
                String[] str2 = {"administrative_area1",
                        "administrative_area2",
                        "administrative_area3",
                        "administrative_area4",
                        "administrative_area5",
                        "colloquial_area",
                        "Country",
                        "establishment",
                        "finance",
                        "Floor",
                        "Food",
                        "general_contractor",
                        "Society",
                        "Health",
                        "intersection",
                        "Locality",
                        "Natural_feature",
                        "Neighborhood",
                        "Place_of_worship",
                        "Political",
                        "Point_of_interest",
                        "Post_box",
                        "Postal_code",
                        "postal_code_prefix",
                        "postal_code_suffix",
                        "postal_town",
                        "premise",
                        "Room",
                        "Route",
                        "Street_address",
                        "Street_number",
                        "sublocality",
                        "sublocality 4",
                        "sublocality_5",
                        "sublocality_3",
                        "sublocality_2",
                        "sublocality_1",
                        "subpremise"};
                for (int i = 1001; i <= 1030; i++) {
                    map.put(i, str2[i - 1001]);

                }
                return map.get(list);
            }
        }
    }
}
