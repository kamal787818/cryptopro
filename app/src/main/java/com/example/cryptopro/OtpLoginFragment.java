package com.example.cryptopro;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cryptopro.homeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class OtpLoginFragment extends Fragment {
    Button otp_btn;
   EditText ed2;
    RequestQueue queue;
    SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_otp_login, container, false);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otp_login, container, false);
           otp_btn = view.findViewById(R.id.otp_btn);
           ed2=view.findViewById(R.id.otpNumber);
         queue=Volley.newRequestQueue(getContext());
           Bundle OTP=getArguments();
       String otp=OTP.getString("otp");

        String ph= OTP.getString("phn");



        //String Otp = getArguments().getString("tp");
         otp_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               Toast.makeText(getContext(),"otp edittext"+otp,Toast.LENGTH_LONG).show();

                 if (ed2.getText().toString().equals(otp)) {
                     //startActivity(new Intent(getContext(), homeActivity.class));

                     StringRequest stringRequest2 = new StringRequest(Request.Method.GET, "http://www.anpad.in/EkInvestment_API.asmx/login?ph="+ph+"", new Response.Listener<String>() {
                         @Override
                         public void onResponse(String response) {
                             Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();

                             try {
                                 JSONArray jsonArray=new JSONArray(response);
                                 JSONObject jsonObject=jsonArray.getJSONObject(0);
                                 String aa=jsonObject.getString("Kamal");
                                 if(aa.equals("1")){
                                     startActivity(new Intent(getContext(), homeActivity.class));
                                 }
                                 else{
                                     getFragmentManager().beginTransaction().replace(R.id.main, new Sign_Up_Fragment()).commit();
                                 }
                             } catch (JSONException e) {
                                 e.printStackTrace();
                             }

                         }
                     }, new Response.ErrorListener() {
                         @Override
                         public void onErrorResponse(VolleyError error) {
                             Toast.makeText(getContext(), "" + error, Toast.LENGTH_SHORT).show();

                         }



                     });
                     //VolleySingleton.getInstance().addToRequestQueue(stringRequest2);
                     queue.add(stringRequest2);

                     //getFragmentManager().beginTransaction().replace(R.id.main, new Sign_Up_Fragment()).commit();
                 }
                 else {
                     Toast.makeText(getContext(),"Incorrect OTP",Toast.LENGTH_LONG).show();
                 }
             }
         });

        return view;
    }
}