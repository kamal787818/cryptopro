package com.example.cryptopro;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Invest_fragment extends Fragment {
    int num;
    View layout;
    TextView deposit;
  //  TextView year_select;
    SeekBar seekBar;
    String Interest_pay;
    PopupWindow popup;
    ArrayList<String> rate;
    TextView pb,pb2,pb3,pb4,pb5;
    ConstraintLayout popup_view;
    LinearLayout cal_layout,duration_layout;
    EditText year11;
    TextView duration_btn,TimeLineWindow,year_2,year_3,year_4,year_5,year;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invest_fragment, container, false);
        rate = new ArrayList<>();
        deposit = view.findViewById(R.id.deposit);
        duration_btn = view.findViewById(R.id.duration_btn);
        TimeLineWindow = view.findViewById(R.id.tp);
        cal_layout = view.findViewById(R.id.calculation_layout);
        duration_layout = view.findViewById(R.id.duration_layout);
     //   year_select = view.findViewById(R.id.yr);
        layout = getLayoutInflater().inflate(R.layout.popup_menu, null);


        seekBar = layout.findViewById(R.id.seekBar);
        pb = layout.findViewById(R.id.textView);
        pb2 = layout.findViewById(R.id.textView2);
        pb3 = layout.findViewById(R.id.textView3);
        pb4 = layout.findViewById(R.id.textView4);
        pb5 = layout.findViewById(R.id.textView5);

        year = view.findViewById(R.id.y_1r);
        year11=view.findViewById(R.id.yr);
        year_2 = view.findViewById(R.id.yr_2);
        year_3 = view.findViewById(R.id.yr_3);
        year_4 = view.findViewById(R.id.yr_4);
        year_5 = view.findViewById(R.id.yr_5);


        //String m = year11.getText().toString();
        String m="2001";
        int month = Integer.parseInt(m);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                num = i;
                PopupView();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                PopupView();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //popup.dismiss();

            }
        });


        TimeLineWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "i am in", Toast.LENGTH_LONG).show();
                displayPopupWindow(v);
            }
        });

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cal_layout.setVisibility(View.VISIBLE);

                duration_layout.setVisibility(View.VISIBLE);
                //year_select.setActivated(true);


            }
        });

        duration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* cal_layout.setVisibility(View.VISIBLE);*/
                duration_layout.setVisibility(View.GONE);
                deposit.setText(""+month);

            }
        });

        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year.setTextColor(Color.RED);
                year.setBackgroundColor(R.drawable.selected_yr_btn);
                year11.setText("12");

            }
        });

        year_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year_2.setTextColor(Color.RED);
                year_2.setBackgroundColor(R.drawable.selected_yr_btn);
                year11.setText("24");
            }
        });

        year_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year_3.setTextColor(Color.RED);
                year_3.setBackgroundColor(R.drawable.selected_yr_btn);
                year11.setText("36");
            }
        });


        year_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year_4.setTextColor(Color.RED);
                year_4.setBackgroundColor(R.drawable.selected_yr_btn);
                year11.setText("48");
            }
        });


        year_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year_5.setTextColor(Color.RED);
                year_3.setBackgroundColor(R.drawable.selected_yr_btn);
                year11.setText("60");
            }
        });


        return view;
    }

    private void PopupView() {


        seekBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D3CFCF")));
        switch (num){
            case 0:
                Interest_pay= pb.getText().toString();
                TimeLineWindow.setText(Interest_pay);

                pb.setTextColor(Color.WHITE);
                pb2.setTextColor(Color.parseColor("#808181"));
                pb3.setTextColor(Color.parseColor("#808181"));
                pb4.setTextColor(Color.parseColor("#808181"));
                pb5.setTextColor(Color.parseColor("#808181"));

                break;
            case 1:
                Interest_pay= pb2.getText().toString();
                TimeLineWindow.setText(Interest_pay);

                pb2.setTextColor(Color.WHITE);
                pb.setTextColor(Color.parseColor("#808181"));
                pb3.setTextColor(Color.parseColor("#808181"));
                pb4.setTextColor(Color.parseColor("#808181"));
                pb5.setTextColor(Color.parseColor("#808181"));
                break;

            case 2:

                Interest_pay= pb3.getText().toString();
                TimeLineWindow.setText(Interest_pay);

                pb3.setTextColor(Color.WHITE);
                pb.setTextColor(Color.parseColor("#808181"));
                pb2.setTextColor(Color.parseColor("#808181"));
                pb4.setTextColor(Color.parseColor("#808181"));
                pb5.setTextColor(Color.parseColor("#808181"));


                break;

            case 3:

                Interest_pay= pb4.getText().toString();
                TimeLineWindow.setText(Interest_pay);

                pb4.setTextColor(Color.WHITE);
                pb3.setTextColor(Color.parseColor("#808181"));
                pb2.setTextColor(Color.parseColor("#808181"));
                pb5.setTextColor(Color.parseColor("#808181"));
                pb.setTextColor(Color.parseColor("#808181"));
                break;
            case 4:

                Interest_pay= pb5.getText().toString();
                TimeLineWindow.setText(Interest_pay);

                pb5.setTextColor(Color.WHITE);
                pb2.setTextColor(Color.parseColor("#808181"));
                pb3.setTextColor(Color.parseColor("#808181"));
                pb4.setTextColor(Color.parseColor("#808181"));
                pb.setTextColor(Color.parseColor("#808181"));
                break;


        }
    }


    private void displayPopupWindow(View v) {

        // ...onCreate above...
        // Display popup attached to the button as a position anchor
        PopupWindow popup = new PopupWindow(getContext());

        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(v);



    }
}