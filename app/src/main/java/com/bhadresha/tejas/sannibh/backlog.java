package com.bhadresha.tejas.sannibh;

import android.content.Context;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by G PATEL on 04-01-2018.
 */

public class backlog extends AsyncTask<String, String, String> {
    Context context ;
    backlog(Context context){
        context = context;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String url_login = "http://10.0.2.2/login.php";
        URL url = null;
        try {
            String user_name = params[1];
            String password = params[2];
            url = new URL(url_login);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                    URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            String result = " ";
            String line;
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
            while((line = bufferedReader.readLine()) != null){
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
