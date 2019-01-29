package id.indrasudirman.belajarbahasainggris;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SimplePast extends AppCompatActivity {

    final String answerQuestions1 = "ngr";
    final String answerQuestions2 = "ivfvgrq";
    final String answerQuestions3 = "yvirq";

    public ViewPager viewPager;
    public TabLayout tabLayout;

    int[] colorIntArray = {R.color.colorAccent, R.color.colorAccent, R.color.colorAccent};
    int[] iconIntArray = {R.drawable.ic_tab_next, R.drawable.check, R.drawable.ic_tab_next};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past);

        Toolbar toolbar = findViewById(R.id.action_bar);
        //setSupportActionBar(toolbar);


        tabLayout = findViewById(R.id.tabs);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = tabLayout.getSelectedTabPosition();

                switch (position) {
                    case 0:
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        break;
                    case 1:
                        checkAnswer(v);
                        break;
                    case 2:
                        Snackbar.make(v, "Berta, Susukan, Banjarnegara", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 2 ) {
                    viewPager.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            return false;
                        }
                    });
                }

                animateFab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager (ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SimplePastFragment(), "Hal 1");
        adapter.addFrag(new SimplePastFragment2(), "Hal 2");
        adapter.addFrag(new SimplePastFragment(), "Hal 3");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter (FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }


        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag (Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle (int position) {
            return mFragmentTitleList.get(position);
        }
    }

    protected void animateFab (final int position) {
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.clearAnimation();

        // Scale down animation
        ScaleAnimation shrink = new ScaleAnimation(1f, 0.1f, 1f, 0.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shrink.setDuration(100); //Animation duration in milliseconds
        shrink.setInterpolator(new AccelerateInterpolator());
        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Change FAB color icon
                fab.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), colorIntArray[position]));
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), iconIntArray[position]));

                //Rotate Animation
                Animation rotate = new RotateAnimation(60.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(150);
                rotate.setInterpolator(new DecelerateInterpolator());

                //Scale up Animation
                ScaleAnimation expand = new ScaleAnimation(0.1f, 1f, 0.1f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                expand.setDuration(150); //Animations duration in milliseconds
                expand.setInterpolator(new DecelerateInterpolator());

                //Add both animations to animation state
                AnimationSet s = new AnimationSet(false); //false mean don't share interpolators
                s.addAnimation(rotate);
                s.addAnimation(expand);
                fab.startAnimation(s);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fab.startAnimation(shrink);
    }

    private void checkAnswer (final View view) {
        ArrayList<String> incorrectAnswerList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;

        } else {
            incorrectAnswerList.add("Soal No 1");

        } if (checkQuestion2()) {
            numberOfQuestionsCorrect ++;
        } else {
            incorrectAnswerList.add("Soal No 2");
        } if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionsCorrect == 3) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePast.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionsCorrect + "/3\nIni Sempurna. Anda dapat melanjutkan ke Pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Simple Past Tense 2", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePast.this);
            alertDialogBuilder
                    .setTitle("Gagal")
                    .setMessage("Anda Gagal, Nilai Anda adalah : " + numberOfQuestionsCorrect + "/3\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem());
                        }
                    })

                    .setNegativeButton("Keluar aplikasi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            moveTaskToBack(true);
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private boolean checkQuestion1() {
        EditText editTextQuestion1 = findViewById(R.id.answer_simple_past_test1);

        //Convert to plaintext
        Rot13 mRot13 = new Rot13();
        mRot13.methodRot13(answerQuestions1);

        String rot13 = mRot13.methodRot13(answerQuestions1);

        //check the answer after converted to plaintext
        return editTextQuestion1.getText().toString().equalsIgnoreCase(rot13);
    }

    private boolean checkQuestion2() {
        EditText editTextQuestion2 = findViewById(R.id.answer_simple_past_test2);

        //Convert to plaintext
        Rot13 mRot13 = new Rot13();
        mRot13.methodRot13(answerQuestions2);

        String rot13 = mRot13.methodRot13(answerQuestions2);

        //check the answer after converted to plaintext
        return editTextQuestion2.getText().toString().equalsIgnoreCase(rot13);

    }

    private boolean checkQuestion3() {
        EditText editTextQuestion3 = findViewById(R.id.answer_simple_past_test3);

        //Convert to plaintext
        Rot13 mRot13 = new Rot13();
        mRot13.methodRot13(answerQuestions3);

        String rot13 = mRot13.methodRot13(answerQuestions3);

        //check the answer after converted to plaintext
        return editTextQuestion3.getText().toString().equalsIgnoreCase(rot13);

    }

    private void checktab (int position) {

    }


}
