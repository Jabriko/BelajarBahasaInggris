package id.indrasudirman.belajarbahasainggris;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;



public class SimplePastFragment extends Fragment {
    ClickableSpan clickableSpan;

    public SimplePastFragment() {
        //Required empty public constructor

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_simple_past, container , false);

        final TextView textView = rootView.findViewById(R.id.textView_simple_past_explain);

        final SpannableString spannableString = new SpannableString("Simple Past Tense digunakan untuk menyatakan kejadian yang sudah selesai dan tidak ada hubungan sama sekali dengan saat ini (sekarang), biasanya hanya untuk menceritakan kejadian yang lalu saja. Simple Past Tense juga biasa digunakan untuk menyatakan sesuatu yang sudah terjadi dalam cerita.");

        clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                //Set Title
                alertDialogBuilder.setTitle("Info");
                alertDialogBuilder.setMessage("Simple Past Tense adalah salah satu dari 14 Tense (waktu) yang ada dalam Grammar Bahasa Inggris")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_tab_next)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(getActivity());

                //Set Title
                alertDialogBuider.setTitle("Tips");
                alertDialogBuider.setMessage("lihat Contoh Nomor 3")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_tab_next)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuider.create();
                alertDialog.show();

            }
        };

        spannableString.setSpan(clickableSpan, 0, 17, 0);
        spannableString.setSpan(clickableSpan2, 278, 290, 0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);

        TextView spannableTextView1 = rootView.findViewById(R.id.bullet1_simple_past);
        String originalText1 = getResources().getString(R.string.first_bullet);

        //add clickable in specified text
        SpannableString spannableString1 = new SpannableString(originalText1);
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                AlertDialog.Builder alertDialogbuider = new AlertDialog.Builder(getActivity());

                //set Title
                alertDialogbuider.setTitle("info");
                alertDialogbuider.setMessage("Lived adalah bentuk Verb 2 atau bentuk Simple Past yang artinya hidup/tinggal. Susunan bentuknya adalah Live (Verb 1) - Lived (Verb 2) - Lived (Verb 3). Live termasuk dalam bentuk Regular Verbs")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_tab_next)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogbuider.create();
                alertDialog.show();


            }
        };

        spannableString1.setSpan(clickableSpan3, 12, 17, 0);
        spannableTextView1.setMovementMethod(LinkMovementMethod.getInstance());
        spannableTextView1.setText(spannableString1);

        //get specified text in Textview beccome object
        TextView spannableTextView2 = rootView.findViewById(R.id.bullet2_simple_past);
        String originalText2 = getResources().getString(R.string.second_bullet);

        // Add clickable in specified text.
        SpannableString spannableString2 = new SpannableString(originalText2);
        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(getActivity());
                //set title
                alertDialogBuider
                        .setTitle("Info");
                alertDialogBuider
                        .setMessage("Bought adalah bentuk Verb 2 atau bentuk Simple Past yang artinya membeli/menyuap/menyogok. Susunan bentuknya adalah Buy (Verb 1) - Bought (Verb 2) - Bought (Verb 3). Buy termasuk dalam bentuk Irregular Verbs")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_tab_next)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuider.create();
                alertDialog.show();


            }
        };

        spannableString2.setSpan(clickableSpan4, 4, 10, 0);
        spannableTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        spannableTextView2.setText(spannableString2);


        TextView spannableTextView3 = rootView.findViewById(R.id.bullet3_simple_past);
        String originalText3 = getResources().getString(R.string.third_bullet);

        // Add clickable in specified text.
        SpannableString spannableString3 = new SpannableString(originalText3);
        ClickableSpan clickableSpan5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(getActivity());
                //set title
                alertDialogBuider
                        .setTitle("Info");
                alertDialogBuider
                        .setMessage("Grew adalah bentuk Verb 2 atau bentuk Simple Past yang artinya menanam/memelihara/tumbuh. Susunan bentuknya adalah Grow (Verb 1) - Grew (Verb 2) - Grown (Verb 3). Grow termasuk dalam bentuk Irregular Verbs")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_tab_next)
                        .setPositiveButton("Sudah paham", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getActivity(), "Saya sudah paham", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuider.create();
                alertDialog.show();


            }
        };

        spannableString3.setSpan(clickableSpan5, 19, 23, 0);
        spannableTextView3.setMovementMethod(LinkMovementMethod.getInstance());
        spannableTextView3.setText(spannableString3);

        return rootView;
    }
}
