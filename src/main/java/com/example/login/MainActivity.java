package com.example.login;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
//import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void doLogin(View v){

        final RelativeLayout l = (RelativeLayout)findViewById(R.id.mainView);

        final TextView t = new TextView(this);
        final TextView n = (TextView)findViewById(R.id.textView);

        final EditText edtUsername = (EditText)findViewById(R.id.edtUsername);
        final EditText edtPassword = (EditText)findViewById(R.id.edtPassword);


        ContentValues params = new ContentValues();
        //params.put("q","Pravesh Ranchod");

        /*

        I create a connection to the php file that accesses our database on lamp using the code from lap 7
        The connection is working and we were able to get a JSONArray (Similar to what he did in class today)

        */

        //So it turns out that JSON is fucking out
        /*final AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://lamp.ms.wits.ac.za/~s1653563/login.php", params) {
            @Override
            protected void onPostExecute (String output) {
                try{

                    String username = edtUsername.getText().toString();
                    String password = edtPassword.getText().toString();

                    JSONArray ja = new JSONArray (output);

                    String[] usernames = processJSON(ja,"Username");
                    String[] passwords = processJSON(ja, "Password");


                    boolean state = validate(usernames, passwords, "H", "l");

                    t.setText(String.valueOf(state));
                    l.addView(t);

                    edtUsername.setText("Testing");
                    edtPassword.setText("Testing");

                    n.setText(username + " : " + password);
                    l.addView(n);


                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };
        asyncHTTPPost.execute();*/

    }
/*
    This function kinda works... it is only displaying one item instead of a list of the items
 */
    public static String[] processJSON(JSONArray ja, String context){
        String[] vals = new String[ja.length()];

        try {
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = (JSONObject) (ja.getJSONObject(i));
                vals[i] = jo.getString(context);
            }
            return vals;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return vals;
    }

    public static boolean validate(String[] usernames, String[] passwords, String username, String password){
        int x = usernames.length;
        int y = passwords.length;

        if(x == y){
            for(int i = 0; i < x; i++){
                if(usernames[i].equals(username) && passwords[i].equals(password)){
                    return true;
                }
            }
        }
        else{
            throw new RuntimeException("Arrays do not match");
        }

        return false;
    }
}