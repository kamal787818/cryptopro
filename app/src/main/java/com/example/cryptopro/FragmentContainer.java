package com.example.cryptopro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class FragmentContainer extends AppCompatActivity {
//Button btn;
  BiometricPrompt biometricPrompt;
  BiometricPrompt.PromptInfo promptInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          //btn=findViewById(R.id.button);
       // startActivity(new Intent(FragmentContainer.this, LoginMain_Activity.class));
        //getSupportFragmentManager().beginTransaction().add(R.id.main,new Login()).commit();
//          btn.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View v) {
//                  Toast.makeText(FragmentContainer.this, "Hello Toast Message!", Toast.LENGTH_LONG).show();
//              }
//          });
        BiometricManager biometricManager=BiometricManager.from(this);
        switch (biometricManager.canAuthenticate())
        {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"This device does not have a fingerprint sensor",Toast.LENGTH_SHORT).show();
                break;

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"The biometric sensor is currently unavailable",Toast.LENGTH_SHORT).show();
              break;

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(),"Your device doesn't have fingerprint saved,please check your security settings",Toast.LENGTH_SHORT).show();
               break;
        }
        Executor executor= ContextCompat.getMainExecutor(this);
        biometricPrompt=new BiometricPrompt(FragmentContainer.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(FragmentContainer.this, "kamal"+result, Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(FragmentContainer.this, LoginMain_Activity.class));
                getSupportFragmentManager().beginTransaction().add(R.id.main,new Login_Fragment()).commit();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        promptInfo=new BiometricPrompt.PromptInfo.Builder().setTitle("EKinvest")
                .setDescription("Use fingerprint to login").setDeviceCredentialAllowed(true).build();
        biometricPrompt.authenticate(promptInfo);
         }
}