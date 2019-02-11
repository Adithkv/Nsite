package info.androidhive.cardview;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlbumsAdapter2 adapter;
    private List<Album> albumList;
    public String deptname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            deptname =(String) b.get("deptname");
            //eventname = j;
            Toast.makeText(EventActivity.this, deptname,
                    Toast.LENGTH_LONG).show();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter2(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new EventActivity.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        if( deptname.equals("GENERAL") ) {
            prepareAlbums1();
        }
        else if ( deptname.equals("AUTOMOBILE") ) {
            prepareAlbums2();
        }
        else if ( deptname.equals("COMPUTER SCIENCE") ) {
            prepareAlbums3();
        }
        else if ( deptname.equals("ELECTRONICS AND COMMUNICATION") ) {
            prepareAlbums4();
        }
        else if ( deptname.equals("ELECTRICAL AND ELECTRONICS") ) {
            prepareAlbums5();
        }
        else if ( deptname.equals("MECHANICAL") ) {
            prepareAlbums6();
        }
        else if ( deptname.equals("MECHATRONICS") ) {
            prepareAlbums7();
        }
        else if ( deptname.equals("MASTER OF COMPUTER APPLICATIONS") ) {
            prepareAlbums8();
        }

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareAlbums1() {
        int[] covers = new int[]{
                R.drawable.expo,
                R.drawable.quiz,
                R.drawable.strike,
                R.drawable.p1,
                R.drawable.p2,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("MOTO EXPO", 13, covers[0]);
        albumList.add(a);

        a = new Album("QUIZ", 8, covers[1]);
        albumList.add(a);

        a = new Album("STRIKE A POSE", 8, covers[2]);
        albumList.add(a);

        a = new Album("ENGINEERING PROJECTS", 8, covers[3]);
        albumList.add(a);

        a = new Album("PROJECTS (HIGH SCHOOL LEVEL and HIGHER SECONDARY LEVEL)", 8, covers[4]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums2() {
        int[] covers = new int[]{
                R.drawable.gear,
                R.drawable.deci,
                R.drawable.skill,
                R.drawable.hill,
                R.drawable.offro,
                R.drawable.lady,
                R.drawable.gokart,
                R.drawable.motography,
                R.drawable.auto,
                R.drawable.stuntshow,
                R.drawable.projectpresent};

        Album a = new Album("GEARBOX ASSEMBLING", 13, covers[0]);
        albumList.add(a);

        a = new Album("DECIBEL TEST", 8, covers[1]);
        albumList.add(a);

        a = new Album("SKILLED DRIVER", 11, covers[2]);
        albumList.add(a);

        a = new Album("HILL CLIMBING", 12, covers[3]);
        albumList.add(a);

        a = new Album("OFFROAD CYCLING", 14, covers[4]);
        albumList.add(a);

        a = new Album("LADIES! START", 1, covers[5]);
        albumList.add(a);

        a = new Album("GO-KART RIDE", 1, covers[6]);
        albumList.add(a);

        a = new Album("MOTOGRAPHY", 11, covers[7]);
        albumList.add(a);

        a = new Album("AUTOLAPSE", 14, covers[8]);
        albumList.add(a);

        a = new Album("STUNT SHOW", 11, covers[9]);
        albumList.add(a);

        a = new Album("PROJECT PRESENTATION", 17, covers[10]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums3() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("FOOD MANIA", 13, covers[0]);
        albumList.add(a);

        a = new Album("MACHINE BULL", 8, covers[1]);
        albumList.add(a);

        a = new Album("PHOTOBOOTH", 11, covers[2]);
        albumList.add(a);

        a = new Album("FOG ILLUSION", 12, covers[3]);
        albumList.add(a);

        a = new Album("SCAVENGER HUNT", 14, covers[4]);
        albumList.add(a);

        a = new Album("HARDWARE ASSEMBLING", 1, covers[5]);
        albumList.add(a);

        a = new Album("BLIND CODING", 11, covers[6]);
        albumList.add(a);

        a = new Album("AR HUNT", 14, covers[7]);
        albumList.add(a);

        a = new Album("PAINT BALL", 11, covers[8]);
        albumList.add(a);

        a = new Album("BLIND PENALTY", 17, covers[9]);
        albumList.add(a);

        a = new Album("TENNIS SMASH", 17, covers[10]);
        albumList.add(a);

        a = new Album("FIFA", 17, covers[11]);
        albumList.add(a);

        a = new Album("NFS", 17, covers[12]);
        albumList.add(a);

        a = new Album("PUBG", 17, covers[13]);
        albumList.add(a);

        a = new Album("RUBIX CUBE", 17, covers[14]);
        albumList.add(a);

        a = new Album("DIGIMANIA", 17, covers[15]);
        albumList.add(a);

        a = new Album("MACHINE LEARNING USING PYTHON", 17, covers[16]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums4() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("TRICKY CIRCUITS", 13, covers[0]);
        albumList.add(a);

        a = new Album("CIRCUITRIX", 8, covers[1]);
        albumList.add(a);

        a = new Album("GOOGLE HUNT", 11, covers[2]);
        albumList.add(a);

        a = new Album("DEAM FACTORY", 12, covers[3]);
        albumList.add(a);

        a = new Album("INNOVANCE (Paper Presentation)", 14, covers[4]);
        albumList.add(a);

        a = new Album("V R GAMING", 1, covers[5]);
        albumList.add(a);

        a = new Album("FLUORO SOCCER 2019", 11, covers[6]);
        albumList.add(a);

        a = new Album("RAM & ROM", 14, covers[7]);
        albumList.add(a);

        a = new Album("OPTICAL VILLAGE", 14, covers[8]);
        albumList.add(a);

        a = new Album("DRONE SHOW", 14, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums5() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("CIRCUIT DEBUGGING", 13, covers[0]);
        albumList.add(a);

        a = new Album("BOMB DIFFUSION", 8, covers[1]);
        albumList.add(a);

        a = new Album("ROBOSTRIKE", 11, covers[2]);
        albumList.add(a);

        a = new Album("CONTRAPTION", 12, covers[3]);
        albumList.add(a);

        a = new Album("CORNER OF CHAOS", 14, covers[4]);
        albumList.add(a);

        a = new Album("KSEB EXPO", 1, covers[5]);
        albumList.add(a);

        a = new Album("AUTONOMOUS ROBOTICS", 11, covers[6]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums6() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("PIT STOP", 13, covers[0]);
        albumList.add(a);

        a = new Album("HYDRO LAUNCH", 8, covers[1]);
        albumList.add(a);

        a = new Album("CAD MODELLING", 11, covers[2]);
        albumList.add(a);

        a = new Album("GAME OF THRONES", 12, covers[3]);
        albumList.add(a);

        a = new Album("FOAM FOOTBALL", 14, covers[4]);
        albumList.add(a);

        a = new Album("SUMO WRESTLING", 1, covers[5]);
        albumList.add(a);

        a = new Album("ARCHERY", 11, covers[6]);
        albumList.add(a);

        a = new Album("E- mobility skill development workshop", 14, covers[7]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums7() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("CLASH OF BOTS (ROBOWAR)", 13, covers[0]);
        albumList.add(a);

        a = new Album("DIRT RACE (ROBORACE)", 8, covers[1]);
        albumList.add(a);

        a = new Album("ROBO SOCCER", 11, covers[2]);
        albumList.add(a);

        a = new Album("LINE FOLLOWER", 12, covers[3]);
        albumList.add(a);

        a = new Album("TRANSPORTER", 14, covers[4]);
        albumList.add(a);

        a = new Album("RC RACE", 1, covers[5]);
        albumList.add(a);

        a = new Album("RC SHOW", 11, covers[6]);
        albumList.add(a);

        a = new Album("ROBO EXPO", 14, covers[7]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums8() {
        int[] covers = new int[]{
                R.drawable.food,
                R.drawable.machine,
                R.drawable.photobooth,
                R.drawable.fog,
                R.drawable.scavangr,
                R.drawable.hardwareassembling5,
                R.drawable.blindcodingportrait501,
                R.drawable.arhunt,
                R.drawable.paintball501,
                R.drawable.blindpen,
                R.drawable.projectpresent};

        Album a = new Album("BRAIN OF TEQTIS", 13, covers[0]);
        albumList.add(a);

        a = new Album("MINUTE TO WIN IT", 8, covers[1]);
        albumList.add(a);

        a = new Album("Kalaprabha", 11, covers[2]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
