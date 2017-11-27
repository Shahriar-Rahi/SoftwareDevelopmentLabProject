package procrastinators.meetie;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

        import com.facebook.CallbackManager;
        import com.facebook.FacebookCallback;
        import com.facebook.FacebookException;
        import com.facebook.FacebookSdk;
        import com.facebook.appevents.AppEventsLogger;
        import com.facebook.login.LoginResult;
        import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(MainActivity.this);
        //AppEventsLogger.activateApp(MainActivity.this);
        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.signUp);
        //textView = (TextView) findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                //textView.setText("Login success \n" + loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {
                // App code
               // textView.setText("Login Canceled \n");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                //System.out.println("Exception \n");
            }
        });
    }
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


/*        @Override
        public View onCreateView(
                LayoutInflater inflater,
                ViewGroup container,
                Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.splash, container, false);

            loginButton = (LoginButton) view.findViewById(R.id.signUp);
            loginButton.setReadPermissions("email");
            // If using in a fragment
            loginButton.setFragment(this);
            // Other app specific specialization

            // Callback registration
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                }
            });
        }


        public class MainActivity extends FragmentActivity {
            CallbackManager callbackManager;
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                callbackManager = CallbackManager.Factory.create();
                LoginButton loginButton = (LoginButton) view.findViewById(R.id.usersettings_fragment_login_button);
                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { ... });
            }
        }



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            // App code
                        }

                        @Override
                        public void onCancel() {
                            // App code
                        }

                        @Override
                        public void onError(FacebookException exception) {
                            // App code
                        }
                    });
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }


        public class MainActivity extends FragmentActivity {
            CallbackManager callbackManager;
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                callbackManager = CallbackManager.Factory.create();
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {...});
            }
        }



        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        @Override
        protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }*/

}
