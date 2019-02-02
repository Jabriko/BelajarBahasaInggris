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
        public ImageView thumbnail;

        public MyViewHolder (View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);

        }

    }

    public EnglishChapterAdapter(Context mContext, List <EnglishChapter> englishChapterList){
        this.mcontext = mContext;
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
    }




    @Override
    public int getItemCount() {
        return englishChapterList.size();
    }
}
