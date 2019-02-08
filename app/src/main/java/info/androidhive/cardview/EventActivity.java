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

        a = new Album("MOTOGRAPHY", 11, covers[6]);
        albumList.add(a);

        a = new Album("AUTOLAPSE", 14, covers[7]);
        albumList.add(a);

        a = new Album("STUNT SHOW", 11, covers[8]);
        albumList.add(a);

        a = new Album("PROJECT PRESENTATION", 17, covers[9]);
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
