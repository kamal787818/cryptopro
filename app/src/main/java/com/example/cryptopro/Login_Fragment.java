package com.example.cryptopro;

import static android.content.ContentValues.TAG;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Login_Fragment extends Fragment {
    EditText ed1;
    LinearLayout layout;
    Button submit_btn;
    SharedPreferences sharedPreferences;
    RequestQueue queue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_login, container, false);
       queue= Volley.newRequestQueue(getContext());
        ed1 = view.findViewById(R.id.editTextPhone);
        submit_btn=view.findViewById(R.id.submit_btn);
        String url ="http://jobseeker.perfectpesha.com/api/login";
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                RequestQueue queue1 = Volley.newRequestQueue(getContext());
//
//
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(getContext(), "sjfk" + response, Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getContext(), "snjdkc"+error, Toast.LENGTH_LONG).show();
//                        Log.e(TAG, "onErrorResponse: kamal",error);
//                    }
//                }){
//                    protected Map<String, String> getParams(){
//                        Map<String, String> paramV = new HashMap<>();
//
//                        paramV.put("email", "bishtp143@gmail.com");
//
//                        paramV.put("password","123456");
//
//                        return paramV;
//                    }
//                };
//                queue.add(stringRequest);

                Random random = new Random();
                String tp = String.format("%04d", random.nextInt(1000));
                String ph = ed1.getText().toString();



                // FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
               StringRequest ss = new StringRequest(Request.Method.GET, "https://api.authkey.io/request?authkey=17142059a2638152&mobile=" + ph + "&country_code=91&sid=5083&company=investone&otp=" + tp + "&time=5mins",

                        new Response.Listener<String>() {


                            @Override
                            public void onResponse(String response) {

                                if (ed1.getText().toString().trim().isEmpty()) {
                                    ed1.setError("Enter Phone No");
                                } else {
//
//
                                    OtpLoginFragment otpLoginFragment = new OtpLoginFragment();

                                    Bundle OTP = new Bundle();
                                    OTP.putString("otp", tp);
                                    OTP.putString("phn", ph);
                                    otpLoginFragment.setArguments(OTP);
                                    //  finish();
                                    getFragmentManager().beginTransaction().replace(R.id.main, otpLoginFragment).commit();

//
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("", error.getMessage());
                        Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();

                    }


                });
               queue.add(ss);


            }
        });
return view;
    }
}


