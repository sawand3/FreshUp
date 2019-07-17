package com.example.freshupnew.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freshupnew.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    EditText email1,pass;
    Button signin,fb,google;
    TextView signup;
    LoginButton fb_login;
    CallbackManager callbackManager;

    //facebook_login
    private static final String EMAIL = "email";

    String fname;
//    private ProfilePictureView fbprofileimg;


    String first_name,last_name,email,id,image_url;

    //googlelogin


    private Button googlelogout;
    private SignInButton googlesignin;
    private  GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    String gname,gmail,gimgurl;

    SignInButton signInButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email1=(EditText)findViewById(R.id.emailet);
        pass=(EditText)findViewById(R.id.passet);
        signin=(Button)findViewById(R.id.btnsignin);
//        fb=(Button)findViewById(R.id.facebook_button);
        fb_login=findViewById(R.id.fb_login_button);
        signup=(TextView)findViewById(R.id.tvsignup);
//        google=(Button)findViewById(R.id.google_plus_button);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);
        googlelogout=findViewById(R.id.googleLogout);
        googlelogout.setOnClickListener(this);

        GoogleSignInOptions signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email1.getText().toString().equals("sawan@gmail.com") && (pass.getText().toString().equals("1234"))){
                    startActivity(new Intent(Login.this, Homepage.class));
                }
                else {
                    Toast.makeText(Login.this, "Email and Password Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // FB LOGIN
        callbackManager=CallbackManager.Factory.create();
        fb_login.setReadPermissions(Arrays.asList("email","public_profile"));
        fb_login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });




        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQ_CODE){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);

        }

    }

    AccessTokenTracker tokenTracker=new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken==null){
                Toast.makeText(Login.this, "LOG OUT", Toast.LENGTH_SHORT).show();

            }

            else{
                loadUserProfile(currentAccessToken);
                Intent intent=new Intent(Login.this,Homepage.class);
                startActivity( intent);

            }

        }
    };
    private void loadUserProfile(AccessToken newAccessToken)
    {

        GraphRequest request=GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                try {
                    first_name=object.getString("first_name");
                    last_name=object.getString("last_name");
                    email=object.getString("email");
                    id=object.getString("id");
                    image_url="https://graph.facebook.com/"+id+"/picture?type=normal";
                    Toast.makeText(Login.this, ""+email, Toast.LENGTH_SHORT).show();





//                    Bundle bundle = new Bundle();
//                    bundle.putString("fields","first_name,last_name,email,id");
//                    Profile_Frag profile_frag=new Profile_Frag();
//                    profile_frag.setArguments(bundle);




//                    String email1=email;
//                    String last_name1=last_name;
//                    String first_name1=first_name;
//                    String id1=id;

//
//                    RequestOptions requestOptions=new RequestOptions();
//                    requestOptions.dontAnimate();
//                Glide.with(MainActivity.this).load(image_url).into(circleImageView);





                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        Bundle  parameters = new Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();



    }



    // Google
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.sign_in_button:
                googleLogin();
                break;
            case R.id.googleLogout:
                googleSignout();
//                signintext.setText("SIGN IN");
                break;
        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void googleLogin()
    {
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);





    }

    private void googleSignout()
    {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                googlelogout.setVisibility(View.GONE);


            }
        });

    }
    private void handleResult(GoogleSignInResult result)
    {
        if(result.isSuccess())
        {
            GoogleSignInAccount account=result.getSignInAccount();
            gname=account.getDisplayName();
            gmail=account.getEmail();
            gimgurl=account.getPhotoUrl().toString();
//            signintext.setText(gname);
            googlelogout.setVisibility(View.VISIBLE);

            Intent i =new Intent(Login.this,Homepage.class);
            startActivity(i);
            Toast.makeText(this, ""+gmail, Toast.LENGTH_SHORT).show();

            updateUi(true);


        }
        else{
            updateUi(false);
        }

    }
    private void updateUi(boolean inlogin)
    {



    }

    public String getMyData(){
        return gname;
    }
}


