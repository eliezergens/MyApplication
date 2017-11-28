package com.eliezer.myapplication.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.eliezer.myapplication.R;
import com.eliezer.myapplication.model.backend.DB_Manager;
import com.eliezer.myapplication.model.backend.DB_ManagerFactory;
import com.eliezer.myapplication.model.entities.Property;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static AsyncTask<Void, Void, Void> asyncTask = null;
    DB_Manager manager;
    private ArrayList<Property> rentalProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTask = new PropertyAsyncTask().execute();
    }

    //custom ArrayAdapter
    class propertyArrayAdapter extends ArrayAdapter<Property> {

        private Context context;
        private List<Property> rentalProperties;

        //constructor, call on creation
        public propertyArrayAdapter(Context context, int resource, ArrayList<Property> objects) {
            super(context, resource, objects);

            this.context = context;
            this.rentalProperties = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Property property = rentalProperties.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.property_layout, null);

            TextView description = (TextView) view.findViewById(R.id.description);
            TextView address = (TextView) view.findViewById(R.id.address);
            TextView bedroom = (TextView) view.findViewById(R.id.bedroom);
            TextView bathroom = (TextView) view.findViewById(R.id.bathroom);
            TextView carspot = (TextView) view.findViewById(R.id.carspot);
            TextView price = (TextView) view.findViewById(R.id.price);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            //set address and description
            String completeAddress = property.getStreetNumber() + " " + property.getStreetName() + ", " + property.getSuburb() + ", " + property.getState();
            address.setText(completeAddress);

            //display trimmed excerpt for description
            int descriptionLength = property.getDescription().length();
            if (descriptionLength >= 100) {
                String descriptionTrim = property.getDescription().substring(0, 100) + "...";
                description.setText(descriptionTrim);
            } else {
                description.setText(property.getDescription());
            }

            //set price and rental attributes
            price.setText("$" + String.valueOf(property.getPrice()));
            bedroom.setText("Bed: " + String.valueOf(property.getBedrooms()));
            bathroom.setText("Bath: " + String.valueOf(property.getBathrooms()));
            carspot.setText("Car: " + String.valueOf(property.getCarspots()));

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());
            image.setImageResource(imageID);

            return view;
        }
    }

    private class PropertyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            manager = DB_ManagerFactory.getDB_Manager();
            manager.initRentals();
            rentalProperties = (ArrayList<Property>) manager.getAllProprtiesList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //create our new array adapter
            ArrayAdapter<Property> adapter = new propertyArrayAdapter(MainActivity.this, 0, rentalProperties);
            //Find list view and bind it with the custom adapter
            ListView listView = (ListView) findViewById(R.id.customListView);
            listView.setAdapter(adapter);

            //add event listener so we can handle clicks
            AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {

                //on click
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Property property = rentalProperties.get(position);

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("streetNumber", property.getStreetNumber());
                    intent.putExtra("streetName", property.getStreetName());
                    intent.putExtra("suburb", property.getSuburb());
                    intent.putExtra("state", property.getState());
                    intent.putExtra("image", property.getImage());
                    intent.putExtra("price", property.getPrice());
                    intent.putExtra("bedrooms", property.getBedrooms());
                    intent.putExtra("bathrooms", property.getBathrooms());
                    intent.putExtra("carspots", property.getCarspots());
                    intent.putExtra("description", property.getDescription());

                    startActivity(intent);
                }
            };
            //set the listener to the list view
            listView.setOnItemClickListener(adapterViewListener);

        }
    }
}
