package id.indrasudirman.belajarbahasainggris;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EnglishChapterAdapter adapter;
    private List <EnglishChapter> englishChapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initCollapsingToolbar();

        recyclerView = findViewById(R.id.recycler_view);

        englishChapterList = new ArrayList<>();
        adapter = new EnglishChapterAdapter(this, englishChapterList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration (2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //Row Click Listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                 Intent intent;

                if (position == 0) {
                    intent = new Intent(getApplicationContext(), SimplePast.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(getApplicationContext(), SimplePresent.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onLongClick(View vIew, int position) {

            }
        }));

                prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.top_cover).into((ImageView) findViewById(R.id.backdrop));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        //hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                }
                else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }

            }
        });
    }

    /**
     * Adding few albums for testing
     */

    private void prepareAlbums() {
        int [] covers = new int[]{
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen};

        EnglishChapter a = new EnglishChapter("Simple Past Tense", 13, covers[0]);
        englishChapterList.add(a);

        a = new EnglishChapter("Simple Present Tense", 8, covers[1]);
        englishChapterList.add(a);

        a = new EnglishChapter("Simple Future Tense", 11, covers[2]);
        englishChapterList.add(a);

        a = new EnglishChapter("Past Continuous Tense", 12, covers[3]);
        englishChapterList.add(a);

        a = new EnglishChapter("Present Continuous Tense", 14, covers[4]);
        englishChapterList.add(a);

        a = new EnglishChapter("Future Continuous Tense", 1, covers[5]);
        englishChapterList.add(a);

        a = new EnglishChapter("Past Perfect Tense", 11, covers[6]);
        englishChapterList.add(a);

        a = new EnglishChapter("Present Perfect Tense", 14, covers[7]);
        englishChapterList.add(a);

        a = new EnglishChapter("Future Perfect Tense", 11, covers[8]);
        englishChapterList.add(a);

        a = new EnglishChapter("Past Perfect Continuous Tense", 17, covers[9]);
        englishChapterList.add(a);

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
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; //spacing - (column + 1) * ((1f / spanCount) + spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; //item top
                }
            }
        }
    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx (int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ((Resources) r).getDisplayMetrics()));
    }
}
