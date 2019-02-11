package info.androidhive.cardview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " events");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {

            String getname = holder.title.getText().toString();

            @Override
            public void onClick(View v) {
                // Do something
                Intent editintent = new Intent(mContext, EventActivity.class);
                editintent.putExtra("deptname", getname);
                mContext.startActivity(editintent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            String getname = holder.title.getText().toString();

            @Override
            public void onClick(View v) {
                // Do something
                Intent editintent = new Intent(mContext, EventActivity.class);
                editintent.putExtra("deptname", getname);
                mContext.startActivity(editintent);
            }
        });

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupMenu(holder.overflow);
                Uri uri = Uri.parse("https://instagram.com/nsite2k19?utm_source=ig_profile_share&igshid=vmqpaurfflt3");

                String getname = holder.title.getText().toString();
                if( getname.equals( "COMPUTER SCIENCE" ) ) {
                    uri = Uri.parse("https://instagram.com/brocode2k19?utm_source=ig_profile_share&igshid=122widnt5ycks");
                }
                else if( getname.equals( "MECHANICAL" ) ) {
                    uri = Uri.parse("https://instagram.com/mechmerize2019?utm_source=ig_profile_share&igshid=16ry9c2bgqx1n");
                }
                else if( getname.equals( "MECHATRONICS" ) ) {
                    uri = Uri.parse("https://instagram.com/yantrikxix?utm_source=ig_profile_share&igshid=5pigno1tfx0k");
                }
                else if( getname.equals( "ELECTRONICS AND COMMUNICATION" ) ) {
                    uri = Uri.parse("https://www.instagram.com/eclectique2k19_/");
                }
                else {
                    uri = Uri.parse("https://instagram.com/nsite2k19?utm_source=ig_profile_share&igshid=vmqpaurfflt3");
                }

                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");

                try {
                    mContext.startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/")));
                }
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    /*
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    */
    /**
     * Click listener for popup menu items
     */
    /*
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
    */

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
