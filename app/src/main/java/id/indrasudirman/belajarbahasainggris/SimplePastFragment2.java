package id.indrasudirman.belajarbahasainggris;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;


public class SimplePastFragment2 extends Fragment {

    View rootView;
    Button buttonTooltips1, buttonTooltips2, buttonTooltips3;
    final String answerQuestion1 = "ngr";
    final String answerQuestion2 = "ivfvgrq";
    final String answerQuestion3 = "yvirq";

    public SimplePastFragment2() {
        //Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_simple_past_2, container, false);

        buttonTooltips1 = rootView.findViewById(R.id.tooltip_simple_past_test1);
        buttonTooltips2 = rootView.findViewById(R.id.tooltip_simple_past_test2);
        buttonTooltips3 = rootView.findViewById(R.id.tooltip_simple_past_test3);

        buttonTooltips1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleTooltip.Builder(getActivity()).anchorView(v)
                        .text("Bentuk Irregular verbs")
                        .gravity(Gravity.BOTTOM)
                        .animated(true)
                        .build()
                        .show();
            }
        });

        buttonTooltips2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleTooltip.Builder(getActivity()).anchorView(v)
                        .text("Bentuk Regular verbs")
                        .gravity(Gravity.BOTTOM)
                        .animated(true)
                        .build()
                        .show();
            }
        });

        buttonTooltips3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleTooltip.Builder(getActivity()).anchorView(v)
                        .text("Bentuk Regular verbs")
                        .gravity(Gravity.BOTTOM)
                        .animated(true)
                        .build()
                        .show();
            }
        });






        return rootView;
    }
}
