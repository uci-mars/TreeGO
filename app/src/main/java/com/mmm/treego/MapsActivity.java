package com.mmm.treego;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{
    private static final String TAG = MapsActivity.class.getSimpleName();
    private Button current_location;
    private Button msg;
    private Button quest_button;
    private LatLng botanic_gardens = new LatLng(1.3138, 103.8159);
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        current_location = (Button) findViewById(R.id.button5);
        msg = (Button) findViewById(R.id.button4);
        quest_button = (Button) findViewById(R.id.button1);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        current_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(botanic_gardens, 16));
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapsActivity.this, com.mmm.treego.ViewDatabase.class));
            }
        });

        quest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapsActivity.this, com.mmm.treego.QuestActivity.class));
            }
        });





//        mtextView = (TextView) findViewById(R.id.textView);
//        mRef = new Firebase("..........................LINK..............................");  // DataBase Profile Link
//        mbutton = (Button) findViewById(R.id.button);
//        mbutton.setOnClickListener(new android.view.View.OnClickListener() {
//            @Override
//            public void onClick(android.view.View view) {
//
//                mRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        String v = dataSnapshot.getValue(String.class);
//                        mtextView.setText(v);
//                    }
//                    @Override
//                    public void onCancelled(FirebaseError firebaseError) {
//
//                    }
//                });}});
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setOnMarkerClickListener(this);

//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(1.1138, 103.8159))
//                .title("My Spot")
//                .snippet("This is my spot!")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(botanic_gardens).title("You're at: Singapore Botanic Gardens\n3 quests available here!")).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(botanic_gardens, 16));

        FetchFirebaseData(mMap);
    }

//    @Override
//    public boolean onMarkerClick(final Marker marker) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//// 2. Chain together various setter methods to set the dialog characteristics
//        builder.setMessage("World!")
//                .setTitle("Hello");
//
//// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
//        AlertDialog dialog = builder.create();
//        return true;
//    }

    public void FetchFirebaseData(GoogleMap mMap){
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29643,103.84914)).title("Common name: Indian Rubber Tree. Found in In front of National Museum of Singapore (Park car at FCP and walk down)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.27725,103.84212)).title("Common name: Indian Rubber Tree. Found in Duxton Plain Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24790449,103.82794150000001)).title("Common name: Johore Fig. Found in Sentosa (beside Sentosa Development Corporation Office, 1st Tree)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24752183,103.8280413)).title("Common name: Johore Fig. Found in Sentosa (beside Sentosa Development Corporation Office, 2nd Tree)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38977201,103.9738255)).title("Common name: Johore Fig. Found in Changi, on sandy beach below Fairy Point Chalet 6").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41844998,103.97277530000001)).title("Common name: Johore Fig. Found in Pulau Ubin, within National Police Cadet Corps camp site").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39134505,103.9759915)).title("Common name: Johore Fig. Found in Changi, along Catterick Road near Fairy Point Chalet 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24751648,103.8270109)).title("Common name: Johore Fig. Found in Sentosa, behind bus-stop at Allanbrooke Rd, near Bkt Manis Rd junction").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3904935,103.974355)).title("Common name: Johore Fig. Found in Changi, at Andover Road Fairy Point Chalet 7").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24875,103.82484000000001)).title("Common name: Johore Fig. Found in Sentosa, Capella Hotel, outside Room 11 (Old records - Tanah Merah)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25018982,103.8235537)).title("Common name: Johore Fig. Found in Sentosa - Capella Hotel Gdn Villa Unit 1 (Old records- within the Knolls Hotel development - on golf course)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3128600000000001,103.81586)).title("Common name: Johore Fig. Found in Singapore Botanic Gardens Jungle, tag #8").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2699799999999999,103.81724)).title("Common name: Johore Fig. Found in Keppel Hill, edge of forest").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3324893999999998,103.8310972)).title("Common name: Burmese Banyan. Found in No. 162 Mount Pleasant Road, gateway").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30711,103.81636999999999)).title("Common name: Burmese Banyan. Found in Singapore Botanic Gardens, Lawn A. Next to Swan Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2938100000000001,103.84554)).title("Common name: Burmese Banyan. Found in Fort Canning Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28461907,103.839279)).title("Common name: Bodhi Tree. Found in Pearl's Hill City Park hilltop, near Service Reservoir gate").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2781684,103.8414308)).title("Common name: Bodhi Tree. Found in Duxton Plain Park, near Neil Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22348,103.86113)).title("Common name: Bodhi Tree. Found in Kusu Island (near Water Tower)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2817618,103.7966847)).title("Common name: Bodhi Tree. Found in Canterbury Road, on Stateland near Lamp Post 14").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31429,103.81591)).title("Common name: Meraga. Found in Singapore Botanic Gardens, Rainforest near NParks HQ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40337,103.79399000000001)).title("Common name: Kapok Tree. Found in Singapore Zoological Gardens, behind the Orang Utan Enclosure").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40026931,103.8070427)).title("Common name: Kapok Tree. Found in Upper Seletar Reservoir Park, behind toilet blocks (near Rocket Tower)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40153954,103.8076092)).title("Common name: Kapok Tree. Found in Upper Seletar Reservoir Park, near golf course").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30849751,103.81769399999999)).title("Common name: Kapok Tree. Found in Singapore Botanic Gardens, beside Holttum Hall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29387,103.84583)).title("Common name: Kapok. Found in Fort Canning Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.311132,103.815141)).title("Common name: Giant Cola. Found in Singapore Botanic Gardens, Orchid Plaza").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30881,103.81615)).title("Common name: Copaiba Balsam. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.311083,103.81501300000001)).title("Common name: Cannonball Tree. Found in Singapore Botanic Gardens, Ginger Gardens, behind waterfall").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30377,103.8219)).title("Common name: Cannon-ball Tree. Found in Tanglin Rd; 2nd Tree from gate of Hse. No. 249").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30859028,103.8168295)).title("Common name: Tembusu. Found in Singapore Botanic Gardens, at Lawn E").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.45517429,103.830528)).title("Common name: Tembusu. Found in Lagos circle, off Admiralty Road East").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40537593,103.87028259999998)).title("Common name: Tembusu. Found in Maida Vale, in front of House No. 13 (Seletar Aerospace Park)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.45418852,103.8288257)).title("Common name: Tembusu. Found in Lagos Circle, in front of House No. 208").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25368133,103.8171069)).title("Common name: Tembusu. Found in Sentosa (beside Images Of Singapore)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22067773,103.84549179999999)).title("Common name: Tembusu. Found in Saint John's Island (Block 5 & 8)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.45467837,103.82955009999999)).title("Common name: Tembusu. Found in Lagos Circle, in front of House No. 206").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22225307,103.844486)).title("Common name: Tembusu. Found in Saint John's Island (Block 15 Prison Gate)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3090000000000002,103.81597)).title("Common name: Jamuju. Found in Singapore Botanic Gardens, Lawn H beside HT Alstonia pneumatophora").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29524,103.84756)).title("Common name: Tamalan Tree. Found in Fort Canning Park, Fort Green").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40348379,103.9734684)).title("Common name: -. Found in Pulau Ubin, at granite outcrop near Police Post").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32092,103.81456)).title("Common name: Baobab. Found in Singapore Botanic Gardens, Melati Gate, nr Cluny Pk Rd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30993034,103.8171115)).title("Common name: Red Bead Tree, Saga. Found in Singapore Botanic Gardens, near Lady on a Hammock sculpture").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3093299999999999,103.81525)).title("Common name: Mentulang daun lebar. Found in Singapore Botanic Gardens Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3086200000000001,103.81651)).title("Common name: -. Found in Singapore Botanic Gardens Lawn E").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25052623,103.8226358)).title("Common name: Common Pulai. Found in Sentosa (forested slope opposite Sentosa Development Corporation chalets)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28123806,103.797523)).title("Common name: Common Pulai. Found in Royal Road end, on slope behind House No. 7, (MSS Alexandra Park)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40801003,103.98545490000001)).title("Common name: Common Pulai. Found in Pulau Ubin, Jalan Durian after Pekakak Hut, former Kampong Melayu").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25472743,103.81689279999999)).title("Common name: Common Pulai. Found in Sentosa (Earth Dragon)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22187736,103.8442674)).title("Common name: Common Pulai. Found in Saint John's Island (Block 12 & 13)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24821408,103.833926)).title("Common name: Common Pulai. Found in Sentosa (Mount Serapong, within forested nature area)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24892434,103.8338481)).title("Common name: Common Pulai. Found in Sentosa (Mount Serapong)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.26753119,103.8222655)).title("Common name: Common Pulai. Found in Temenggong Road, on Stateland opposite House No. 22 (gated, Year 2013) - walking access to HT via Marang Road.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3116299999999999,103.81364)).title("Common name: Common Pulai. Found in Singapore Botanic Gardens, Burkill Drive Way").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31314,103.81364)).title("Common name: Common Pulai. Found in Singapore Botanic Gardens, National Orchid Garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.268292,103.821107)).title("Common name: Common Pulai. Found in Mount Faber, along Marang trail").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30903,103.81606)).title("Common name: Pulai Basong. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25415101,103.8156616)).title("Common name: Indian Pulai, Devil Tree, Milky Pine. Found in Sentosa (near junction of Imbiah Hill Road / Imbiah Road, beside Siloso Beach Resort)[Nature Walk]").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30955,103.81560999999999)).title("Common name: Buni. Found in Singapore Botanic Gardens Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29266205,103.8463887)).title("Common name: Terap. Found in Fort Canning Park, along 14th Century Walk of History").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29128224,103.84740090000001)).title("Common name: Flame of the Forest. Found in Fort Canning Park, near Raffles Terrace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29608,103.84817)).title("Common name: Terap. Found in Fort Canning Park, Fort Green, near Canning Rise L/P 11F").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29167,103.84698)).title("Common name: Terap. Found in Fort Canning Park, near Raffles Terrace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29259,103.84586)).title("Common name: Terap. Found in Fort Canning Pk, beh. Blk 2, R Val Rd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25828005,103.8128275)).title("Common name: Chempedak. Found in Sentosa  (Siloso Road, lamp-post PT1-A17 near Imbiah Walk junction)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39002011,103.97916190000001)).title("Common name: Squirrel's Jack, Pudu. Found in Changi, Turnhouse Park, between Turnhouse Road and Netheravon Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38869,103.97965)).title("Common name: Monkey Jack. Found in Changi, within No. 35 Hendon Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31772,103.81703)).title("Common name: Putat Laut. Found in Singapore Botanic Gardens, Healing Garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2475399999999999,103.83514)).title("Common name: Red-flowered Malayan Spindle tree. Found in Sentosa (within Satellite Station grounds)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38939388,103.9741762)).title("Common name: Sparrow's mango. Found in Changi, beside Fairy Point Chalet 6").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30739853,103.8157997)).title("Common name: Purple Milletia. Found in Singapore Botanic Gardens, behind Swan Lake").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30850298,103.8182287)).title("Common name: Penaga Laut. Found in Singapore Botanic Gardens, near Botany Centre Auditorium").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.27967023,103.7938733)).title("Common name: Penaga Laut. Found in 31K Pepys Road, within National Heritage Museum grounds, near Kent Ridge Park [Alexandra Park]").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30718,103.84541)).title("Common name: Penaga Laut. Found in Istana Ground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22177284,103.8443225)).title("Common name: Penaga Laut. Found in Saint John's Island (Block 12 & 13)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28066166,103.7983216)).title("Common name: Penaga Laut. Found in Junction of Canterbury Road and Berkshire Road, Alexandra Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3889623,103.97655300000001)).title("Common name: Buah Ca-na, Chinese White Olive. Found in Changi, Cranwell Road, opposite Cranwell Bungalow 1. Within hotel: Changi Cove.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3088600000000001,103.81638000000001)).title("Common name: Andiroba. Found in Singapore Botanic Gardens, Lawn E").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.34369424,103.8534693)).title("Common name: Kapok Tree. Found in Braddell Road, at Toa Payoh North Flyover Traffic Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31090954,103.81645400000001)).title("Common name: Kapok Tree. Found in Singapore Botanic Gardens, along Lower Ring Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.26865454,103.8173478)).title("Common name: Kapok Tree. Found in Seah Im Road, at far end of public carpark").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38761232,103.98009040000001)).title("Common name: Keruing Kerut. Found in Changi, Cranwell Road near junction with Loyang Avenue").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30797,103.81676999999999)).title("Common name: Kapur. Found in Singapore Botanic Gardens, Lawn E").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31081,103.8164)).title("Common name: Kapur. Found in Singapore Botanic Gardens, Lawn O, near HT Kapok Tree").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30929,103.81606)).title("Common name: Kapur. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.4064729999999999,103.9649802)).title("Common name: Durian. Found in Pulau Ubin, in forested knoll off Jalan Batu Ubin behind cemetery grounds").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39095143,103.9795453)).title("Common name: Jelutong. Found in Changi, Netheravon Road near Bus Stop B06").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31103,103.81582)).title("Common name: Jelutong. Found in Singapore Botanic Gardens, Lawn S").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29519178,103.8450658)).title("Common name: Ear-pod Tree. Found in Fort Canning Park, along path behind the Fort Wall and The Legends").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40541,103.80813)).title("Common name: Ordeal Tree. Found in Upper Seletar Reservoir Park, on slope behind carpark along Mandai Rd.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39081689,103.9774431)).title("Common name: Wild Cocaine (Inai Inai). Found in Changi, Leuchars Road opposite Fairy Point Bungalow 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29707737,103.8869669)).title("Common name: Mindanao Gum. Found in Katong Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28786,103.82437)).title("Common name: Indian Banyan. Found in Within Tiong Bahru Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3886100000000001,103.98005)).title("Common name: Stem-fruited Fig. Found in Changi, along Hendon Road, opposite No 35").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41248,103.94369)).title("Common name: Collared Fig. Found in Pulau Ubin, along Ketam bike trail, near Pipit Hut").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30744,103.7816)).title("Common name: Brown Woolly Fig. Found in Singapore Polytechnic (SP), behind (former) Food Court  1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30764,103.78186)).title("Common name: Brown Woolly Fig. Found in Singapore Polytechnic (SP), behind (former) Food Court  1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30767,103.78159000000001)).title("Common name: Brown Woolly Fig. Found in Singapore Polytechnic (SP), behind (former) Food Court  1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30771,103.78154)).title("Common name: Brown Woolly Fig. Found in Singapore Polytechnic (SP), behind (former) Food Court  1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.33740182,103.801923)).title("Common name: Madras Thorn. Found in Linden Drive, opp. LP13, behind House No. 79.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3056,103.90924)).title("Common name: Madras Thorn. Found in Marine Parade Rd Park / Playground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3076299999999998,103.81675)).title("Common name: Jati Bukit. Found in Singapore Botanic Gardens, Lawn B").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.46329,103.83714)).title("Common name: Sea Teak, Jati Laut. Found in Sembawang Park, next to Beaulieu House").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.33522007,103.8700707)).title("Common name: Angsana. Found in Upper Serangoon Road, near Woodleigh Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28212415,103.83899770000001)).title("Common name: Angsana. Found in Outram Park, behind Outram MRT Station, near zebra crossing").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25046412,103.82466090000001)).title("Common name: Angsana. Found in Sentosa (Capella Hotel, front lawn)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.27910085,103.83659320000001)).title("Common name: Angsana. Found in National Cancer Centre, at Hospital Drive & Second Hospital Ave roundabout").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2965111999999999,103.84309040000001)).title("Common name: Angsana. Found in Jalan Rumbia, near junction with Oxley Rise").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.43073878,103.76189690000001)).title("Common name: Angsana. Found in Woodlands Road, in front of Woodlands Fire Station").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25779305,103.8106468)).title("Common name: Angsana. Found in Sentosa (entrance of Shangri-La Rasa Sentosa Hotel)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.27307063,103.8150974)).title("Common name: Angsana. Found in Pender Road, within grounds of the Danish Seamen's Mission").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28083,103.7979386)).title("Common name: Angsana. Found in Junction of Canterbury Road and Berkshire Road, on sloping ground, Alexandra Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28459889,103.79353640000001)).title("Common name: Angsana. Found in Winchester Road, within premises of House No. 6, Alexandra Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38358,103.81934)).title("Common name: Angsana. Found in Old Upp Thomson Rd nr Lpost DS 13").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3069,103.84611)).title("Common name: Kasah. Found in Istana Ground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29403206,103.84765379999999)).title("Common name: Rain Tree. Found in Fort Canning Park, near Bond Terrace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31517148,103.8165967)).title("Common name: Rain Tree. Found in Singapore Botanic Gardens, outside Visitor Centre pick-up/drop-off point").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32408264,103.8157436)).title("Common name: Rain Tree. Found in College Green, off Dunearn Road within hostel grounds (NUS)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2737459,103.8384494)).title("Common name: Rain Tree. Found in Spottiswoode Park Road, near junction with Everton Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3066799999999998,103.84579000000001)).title("Common name: Rain Tree. Found in Istana Ground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31284349,103.7987287)).title("Common name: Rain Tree. Found in Holland Road, near junction with Belmont Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32416174,103.84614599999999)).title("Common name: Rain Tree. Found in Irrawaddy Road, on slope facing Ministry of Home Affairs Headquarters").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2926605,103.8401681)).title("Common name: Rain Tree. Found in Kim Yam Road Stateland, beside Gambier Court condominium").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29042339,103.7965571)).title("Common name: Rain Tree. Found in Jalan Hang Jebat, in front of Block 109").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.27425184,103.83849709999998)).title("Common name: Rain Tree. Found in Everton Road, on slope opposite Block 10 multi-storey carpark").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.37083814,103.7638882)).title("Common name: Rain Tree. Found in Upper Bukit Timah Road, in open space opposite Gombak Drive. UppBTRd junction with Cashew Rd.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40961967,103.87042240000001)).title("Common name: Rain Tree. Found in Seletar Airbase, open space between Old Birdcage Walk and Oxford Street Seletar Aerospace Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30927733,103.8480164)).title("Common name: Rain Tree. Found in Kampong Java Road, LTA Office (Courtyard garden)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28813677,103.8250297)).title("Common name: Rain Tree. Found in Singapore Examination & Assessment Board; Tiong Bahru. 8 Lower Delta Rd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29197,103.84809)).title("Common name: Rain Tree. Found in Fort Canning Park, Parit Singapura").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39155008,103.98189040000001)).title("Common name: . Found in Changi, Netheravon Road within Chalet ABCD grounds").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39176357,103.98192990000001)).title("Common name: . Found in Changi, Netheravon Road within Chalet ABCD grounds").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41652,103.9669)).title("Common name: -. Found in Pulau Ubin, roadside, right side of Jalan Noordin toward NPCC campsite, along fence").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41536,103.96736999999999)).title("Common name: -. Found in Pulau Ubin, forest, left side of Jalan Noordin toward NPCC campsite, along fence").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.21977679,103.8485904)).title("Common name: Sea Fig. Found in Saint John's Island (near water tank)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.21865167,103.847638)).title("Common name: Sea Fig. Found in Saint John's Island (Camp site 1 & 2)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22108946,103.8452427)).title("Common name: Sea Fig. Found in Saint John's Island (Block 7A, on slope of hill)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22126093,103.8454833)).title("Common name: Sea Fig. Found in Saint John's Island (Former Sepak Takraw Court)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32095099,103.9552205)).title("Common name: Sea Fig. Found in At Bedok Food Centre Car Park, opposite Eastwood Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.34237826,103.683683)).title("Common name: Sea Fig. Found in Nanyang Technological University, at Nanyang Drive, Bus-stop in front of Innovation Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3321165000000001,103.9462806)).title("Common name: Sea Fig. Found in Junction of Bedok Rd and Upper Changi Rd junction Car-park (former Changi Complex)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32574,103.94615999999999)).title("Common name: Sea Fig. Found in Bedok Rise S/L, near fence; footpath").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24833,103.83596999999999)).title("Common name: White Fig Tree. Found in Sentosa (wiithin Satellite Station grounds)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2522799999999998,103.82504)).title("Common name: Seashore Mangosteen. Found in Sentosa former (Maritime Museum) - restricted access").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31913,103.81572)).title("Common name: Belinjau. Found in Singapore Botanic Gardens, LXJ (behind the Garage)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3109899999999999,103.81675)).title("Common name: Mengkulang. Found in Singapore Botanic Gardens, Lawn O, near HT Kapok Tree").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3162200000000002,103.81544)).title("Common name: Chengal Pasir. Found in Singapore Botanic Gardens, Lawn XA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31609,103.81697)).title("Common name: Pianggu. Found in Singapore Botanic Gardens, Lawn XG").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2827768999999998,103.79992259999999)).title("Common name: West Indian Locust Tree. Found in Cornwall Road, near junction with Royal Road, (MSS Alexandra Park)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3030700000000002,103.84203000000001)).title("Common name: West Indian Locust Tree. Found in Istana Ground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.4047,103.79334)).title("Common name: Kapok Tree. Found in Singapore Zoological Gardens, behind the White Tiger Enclosure").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.315232,103.81547900000001)).title("Common name: West India Locust Tree. Found in Singapore Botanic Gardens, Corner House Lawn").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32029339,103.81744520000001)).title("Common name: Tahitian Chestnut. Found in Singapore Botanic Gardens, behind Jacob Ballas Children's Garden Carpark").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31479706,103.8924715)).title("Common name: African Mahogany. Found in Guillemard Road Open Space").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31469468,103.8924045)).title("Common name: African Mahogany. Found in Guillemard Road Open Space").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31469821,103.8925163)).title("Common name: African Mahogany. Found in Guillemard Road Open Space").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31474789,103.8924497)).title("Common name: African Mahogany. Found in Guillemard Road Open Space").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.33395,103.84465)).title("Common name: African Mahogany. Found in In front of Blk 150 Lorong 1 Toa Payoh (Along store front)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3070899999999999,103.81669000000001)).title("Common name: Senegal Mahogany. Found in Singapore Botanic Gardens, Lawn B").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.290113326,103.8533847)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289834863,103.8532509)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289745892,103.85320820000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2896491970000001,103.85316170000002)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289469485,103.85307540000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289359671,103.85302270000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.288655242,103.8528645)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289482367,103.8533254)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.289575235,103.8533696)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.290003053,103.8535734)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.290520156,103.8538197)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291055763,103.8540749)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291213862,103.85415019999999)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291741874,103.85435090000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3101200000000002,103.81506999999999)).title("Common name: Rain Tree. Found in Singapore Botanic Gardens, Lawn G").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39093106,103.9796838)).title("Common name: Damar Hitam Gajah. Found in Changi, Netheravon Road near Bus Stop B06").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31282,103.81584000000001)).title("Common name: Meranti Laut. Found in Singapore Botanic Gardens, Jungle Tag # 9").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.313687,103.816745)).title("Common name: Meranti Melantai. Found in Singapore Botanic Gardens, jungle").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30959,103.81591)).title("Common name: Sausage Tree. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31554,103.81509)).title("Common name: Kempas. Found in Singapore Botanic Gardens, LXA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3105,103.81741)).title("Common name: -. Found in Singapore Botanic Gardens, nr Botany Ctr, Lawn O").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30805,103.81648)).title("Common name: Monkey Pot. Found in Singapore Botanic Gardens, Lawn E.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30998,103.81568)).title("Common name: Monkey Pot. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31019,103.81565)).title("Common name: Monkey Pot. Found in Singapore Botanic Gardens, Lawn H (with signboard)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28979,103.85365999999999)).title("Common name: Brazilian Ironwood, Leopard Tree. Found in Esplanade Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32259595,103.8359932)).title("Common name: Lychee Tree. Found in Mount Rosie Road, opposite House No. 11J").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.24863553,103.831282)).title("Common name: Medang. Found in Sentosa (Serapong Hill)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.33719225,103.787708)).title("Common name: Binjai. Found in Binjai Park, within grounds of House No. 32").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30316,103.84184)).title("Common name: Binjai. Found in Istana Ground").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.36917324,103.8922391)).title("Common name: Binjai. Found in Jalan Naung, behind House No. 70").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2748963,103.8370767)).title("Common name: Binjai. Found in Spottiswoode Park Road, opposite Spottiswoode Apartments").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291720991,103.8541589)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291568206,103.85408100000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291492169,103.8540449)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2913542740000001,103.85397950000001)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291278465,103.8539435)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2911978309999999,103.8539053)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.291096935,103.8538571)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2901712379999999,103.8534125)).title("Common name: Rain Tree. Found in Connaught Drive").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.324223,103.86086800000001)).title("Common name: Bodhi Tree. Found in Bendemeer Secondary School grounds; Entrance round-about porch (1 St Wilfred Road S(327919))").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3111899999999999,103.81688)).title("Common name: Meranti Nemesu. Found in Singapore Botanic Gardens, Rainforest").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30712,103.8176)).title("Common name: Temak. Found in Singapore Botanic Gardens, Lawn B").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38890049,103.9769732)).title("Common name: Sepetir. Found in Changi, Cranwell Road in front of Cranwell Bungalow 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40734015,103.9885257)).title("Common name: Perepat. Found in Pulau Ubin, near Chek Jawa,  from House No. 1 on the right").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40736132,103.9882917)).title("Common name: Perepat. Found in Pulau Ubin, near Chek Jawa, from House No. 1 on the left").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32194,103.81700000000001)).title("Common name: Giant Sterculia. Found in Singapore Botanic Gardens, outside Plant Resource Ctr").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30719,103.81711)).title("Common name: Snake Tree. Found in Singapore Botanic Gardens, Lawn B").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39012649,103.9747168)).title("Common name: Tempinis Tree. Found in Changi, at Andover Road Fairy Point Chalet 7").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.21804526,103.8482521)).title("Common name: Tempinis Tree. Found in Saint John's Island (fencing beside camp site 1 & 2)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.40611781,103.8663965)).title("Common name: Broad-leafed Mahogany. Found in Seletar Airbase, Aerospace Drive near Lamp post 62, Seletar Aerospace Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.406433,103.86670579999999)).title("Common name: Broad-leafed Mahogany. Found in Seletar Airbase, Aerospace Drive near Lamp post 64, Seletar Aerospace Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25448543,103.8176036)).title("Common name: Broad-leafed Mahogany. Found in Sentosa (at entrance to Images Of Singapore)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25491934,103.8177572)).title("Common name: Broad-leafed Mahogany. Found in Sentosa (Images Of Singapore near Sky Tower ~ 1st Heritage Tree)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25485383,103.8177952)).title("Common name: Broad-leafed Mahogany. Found in Sentosa (Images Of Singapore near Sky Tower ~ 2nd Heritage Tree)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41517538,103.8619802)).title("Common name: Broad-leafed Mahogany. Found in Seletar Airbase, West Camp Road near Singapore Youth Flying Club entrance Seletar Aerospace Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.41502022,103.8622262)).title("Common name: Broad-leafed Mahogany. Found in Seletar Airbase, West Camp Road near Singapore Youth Flying Club entrance Seletar Aerospace Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30294,103.82118)).title("Common name: Broad-leafed Mahogany. Found in Tanglin Rd near Hse No 287").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.4064,103.86719000000001)).title("Common name: Broad-leafed Mahogany. Found in Seletar Aerospace Drive, after Bus-stop No. 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31156,103.81479)).title("Common name: West Indies Mahogany. Found in Singapore Botanic Gardens, Lawn R").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25878421,103.8082958)).title("Common name: Jambu Laut. Found in Sentosa (near entrance to Fort Siloso)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39048613,103.97595809999999)).title("Common name: Kelat Hitam. Found in Changi, Catterick Road in front of Fairy Point Chalet 4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.35569514,103.8842458)).title("Common name: Asam Tree. Found in Surin Avenue Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28717113,103.85338229999999)).title("Common name: Asam Tree. Found in Fullerton Road, entrance to The Fullerton Waterboat House garden").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.308225,103.818054)).title("Common name: Teak; Jati; Indian Oak. Found in Singapore Botanic Gardens, along Office Ring Road, Botany Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32013,103.8163)).title("Common name: Ketapang, Sea Almond. Found in Singapore Botanic Gardens, EG8 (future ethno-botany garden)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31111374,103.8162533)).title("Common name: Malayan Terminalia. Found in Singapore Botanic Gardens, at Lower Ring Road and Liane Road junction").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38766905,103.98039909999999)).title("Common name: Malayan Terminalia. Found in Changi, Loyang Avenue near junction with Halton Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.38775686,103.9808572)).title("Common name: Malayan Terminalia. Found in Changi, Loyang Avenue near junction with Halton Road").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25434307,103.81790620000001)).title("Common name: Leban. Found in Sentosa (Images Of Singapore forecourt)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.34133034,103.832921)).title("Common name: Bachang. Found in MacRitchie Reservoir Park, near Public Utilities Board office").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2949700000000002,103.84834000000001)).title("Common name: Bachang. Found in Canning Rise, opposite lamp-post 7").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.28261,103.83128)).title("Common name: Mango. Found in Chay Yan St State Land").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.39236,103.98151)).title("Common name: Mango. Found in Changi, Netheravon Road, Aloha Resorts Chalet D").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.22079379,103.8468333)).title("Common name: Machang Pulasan. Found in Saint John's Island").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3098100000000001,103.81573)).title("Common name: Pauh Damar. Found in Singapore Botanic Gardens, Lawn F").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2951978000000002,103.8484723)).title("Common name: Sea Beam. Found in Canning Rise, near former National Library Carpark").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29471844,103.84833409999999)).title("Common name: Sea Beam. Found in Canning Rise, near pedestrian underpass").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.30701,103.77211899999999)).title("Common name: -. Found in Yale-NUS grounds, College Avenue West").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2543715,103.8179767)).title("Common name: Tanjong Tree. Found in Sentosa (Images Of Singapore forecourt)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32225374,103.8020075)).title("Common name: Nutmeg Tree. Found in Junction of Coronation Road and Victoria Park Road. On Stateland near Lamp Post 33; near Hse No 55 VPkRd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31882,103.81578)).title("Common name: Nutmeg. Found in Singapore Botanic Gardens, LXA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3183200000000002,103.81528)).title("Common name: Nutmeg. Found in Singapore Botanic Gardens, LXA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31999,103.81546999999999)).title("Common name: Yellow Cheesewood. Found in Singapore Botanic Garden, EG14").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25508891,103.8172559)).title("Common name: Nyatoh Puteh. Found in Sentosa (Dragon tail - Earth Dragon)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31659,103.81774)).title("Common name: Nyatoh Puteh. Found in Singapore Botanic Gardens, behind Raffles Building").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31694,103.81621)).title("Common name: Nyatoh Puteh. Found in Singapore Botanic Gardens, along Evolution Garden Walk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.309791,103.815935)).title("Common name: Keluak; Kepayang. Found in Singapore Botanic Gardens, Lawn H").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.34869,103.77748000000001)).title("Common name: Kayu Pontianak. Found in Bt Timah Nature Reserve, along South View Path").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.25218531,103.8224859)).title("Common name: Petai. Found in Sentosa (Gunner Lane, behind Ranger Station)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.26976262,103.82203609999999)).title("Common name: Kedawong. Found in Mount Faber, on slope near Marina Deck").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.2730721,103.81540859999998)).title("Common name: Kedawong. Found in Mount Faber Loop, near road bend opposite side of Danish Seaman's Mission").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32485,103.84782)).title("Common name: Yellow Flame. Found in Jalan Tan Tock Seng, within Renci Hospital car-park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.32118,103.81926999999999)).title("Common name: Yellow flame. Found in Singapore Botanic Gardens, Jacob Ballas C Gdn fence").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.31696298,103.8173462)).title("Common name: Tallow Tree. Found in Singapore Botanic Gardens, behind Block 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29314275,103.8462544)).title("Common name: Madras Thorn. Found in Fort Canning Park, along path beside Service Reservoir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29335223,103.84601049999999)).title("Common name: Madras Thorn. Found in Fort Canning Park, along path beside Service Reservoir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29320635,103.8463656)).title("Common name: Madras Thorn. Found in Fort Canning Park, along path beside Service Reservoir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(1.29373937,103.8458106)).title("Common name: Madras Thorn. Found in Fort Canning Park, along path beside Service Reservoir").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


    }
}
