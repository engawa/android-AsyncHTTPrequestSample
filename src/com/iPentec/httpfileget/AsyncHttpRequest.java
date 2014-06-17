package com.iPentec.httpfileget;

import android.net.Uri;
import android.os.AsyncTask;
import android.app.Activity;
import android.widget.TextView;
import org.apache.http.*;
import org.apache.http.util.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;


public class AsyncHttpRequest extends AsyncTask<String, Void, String> {
  public Activity owner;
  private String ReceiveStr;

  public AsyncHttpRequest(Activity activity) {
      owner = activity;
  }

  //ここが非同期で処理される部分
  @Override
  protected String doInBackground(String... url) {
    try {
      HttpGet httpGet = new HttpGet(url[0]);

      DefaultHttpClient httpClient = new DefaultHttpClient();
      httpGet.setHeader("Connection", "Keep-Alive");

      HttpResponse response = httpClient.execute(httpGet);
      int status = response.getStatusLine().getStatusCode();
      if (status != HttpStatus.SC_OK) {
        throw new Exception("");
      } else {
        ReceiveStr = EntityUtils.toString(response.getEntity(), "UTF-8");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  //このメソッドは非同期処理の終わった後に呼び出されます
  @Override
  protected void onPostExecute(String result) {
      TextView textView2 = (TextView) owner.findViewById(R.id.textView2);
      textView2.setText(ReceiveStr);
  }

}
