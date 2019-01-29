package id.indrasudirman.belajarbahasainggris;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class EnglishChapterAdapter extends RecyclerView.Adapter <EnglishChapterAdapter.MyViewHolder> {

    private Context mcontext;
    private List<EnglishChapter> englishChapterList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder (View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);
            overflow = view.findViewById(R.id.overflow);
        }

    }

    public EnglishChapterAdapter(Context mcontext, List <EnglishChapter> englishChapterList){
        this.mcontext = mcontext;
        this.englishChapterList = englishChapterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.album_card, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        EnglishChapter englishChapter = englishChapterList.get(i);
        myViewHolder.title.setText(englishChapter.getName());
        myViewHolder.count.setText(englishChapter.getNumOfPages() +  " pages");

        //Loading englishChapter cover using Glide library
        Glide.with(mcontext).load(englishChapter.getThumbnail()).into(myViewHolder.thumbnail);

        myViewHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu (myViewHolder.overflow);

            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    private void showPopupMenu (View view) {
        //Inflate menu
        PopupMenu popupMenu = new PopupMenu(mcontext, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popupMenu.show();
    }

    /**
     * Click listener for popup menu items
     */

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mcontext, "Add to Favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mcontext, "Play Next", Toast.LENGTH_SHORT).show();
                    return true;
                    default:
            }

            return false;
        }
    }

    @Override
    public int getItemCount() {
        return englishChapterList.size();
    }
}
