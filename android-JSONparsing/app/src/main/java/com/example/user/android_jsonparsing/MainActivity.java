package com.example.user.android_jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String response = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";


        try {
            parseJson(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void parseJson(String response) throws JSONException {


        JSONObject jsonObjectParent = new JSONObject(response);

        JSONObject jsonObjectMenu = jsonObjectParent.getJSONObject("menu");
        JSONObject jsonObjectPopUp = jsonObjectMenu.getJSONObject("popup");
        JSONArray jsonArrayMenuItem = jsonObjectPopUp.getJSONArray("menuitem");

        for (int i = 0; i < jsonArrayMenuItem.length(); i++) {

            JSONObject jsonObject = (JSONObject) jsonArrayMenuItem.get(i);
            System.out.println(jsonObject.getString("onclick"));


        }








    }

}
