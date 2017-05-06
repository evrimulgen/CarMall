package com.loading.carmall;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loading.carmall.bean.TestBean;
import com.loading.carmall.utils.ConvertUtils;
import com.loading.carmall.utils.EncodeUtils;
import com.loading.carmall.utils.EncryptUtils;
import com.loading.carmall.utils.okhttp.OkHttpUtils;
import com.loading.carmall.utils.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import butterknife.ButterKnife;
import okhttp3.Call;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
/*-------------------------------处理data BEGIN-------------------------------------------*/
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        map.put("user_name","12345678912");
//        map.put("password","123456");

//        Gson gson = new Gson();
//        String json = gson.toJson(map).trim();
//        Log.d("MainActivity", json);
//
//        String base64Token = Base64.encodeToString(json.getBytes(), Base64.DEFAULT).trim();//  编码后
//        Log.d("+++++base64Token", String.valueOf(base64Token));
////        byte[] m = Base64.decode(base64Token,Base64.DEFAULT);// 解码后
//
//        try {
//            String urlEncode = URLEncoder.encode(base64Token, "UTF-8").trim();
////            urlEncode="";
//            Log.d("MainActivity", urlEncode);
//            String s = "Cart-getbrand";
//            String request_time = String.valueOf(System.currentTimeMillis());
//            Log.d("MainActivity", request_time);
//            String signKey = "A03137B2DC3DF13063EFB406151E81D3";
//            String sign = "s=" + s + "&request_time=" + request_time + "&data=" + urlEncode + "||" + signKey;
//            Log.d("MainActivity+++++++", sign);
//            String md5 = EncryptUtils.encryptMD5ToString(sign.trim()).toLowerCase();
//            Log.d("MainActivity", md5);
//            Map<String, String> params = new HashMap<String, String>();
//            params.put("request_time", request_time);
//            params.put("data", urlEncode);
//            params.put("sign", md5);

//            47.92.30.24:8080/api/user/login
            String url = "http://47.92.30.24:8080/api/cart/" + "getbrand";
            OkHttpUtils//
                    .post()//
                    .url(url)//
                    .params(map,"Cart-getbrand")//
                    .build()//
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String response, int id) {

                        }

                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.d("MainActivity", "失败");
                        }

                        @Override
                        public void onResponse(String response, int id) {
// {"result":true,"msg":"获取成功","data":"eyJBIjpbeyJpZCI6MTMsIm5hbWUiOiLpmL%2FlsJTms5XCt%2Be9l%2BWvhua
// spyIsIkluaXRpYWxzIjoiQSIsImxvZ28iOiIyMDE3MDQxM1xcZDUwMGJlMjBmMWRiMDIzYWQ1M2QxZjk1ZDNlZmVlNzguanBnIiwiaW50cm9kdWNlIjoi6Zi%2F5bCU5rOVwrfnvZflr4bmrKciLCJob3QiOjB9LHsiaWQiOjE0LCJuYW1lIjoi6Zi%2F5pav6aG%2FwrfpqazkuIEiLCJJbml0aWFscyI6IkEiLCJsb2dvIjoiMjAxNzA0MTNcXDhjYzA5ZmYxOGEwNGQ0ZWYwMDE2NDY2M2Y1YzIzMzUyLmpwZyIsImludHJvZHVjZSI6IumYv%2BaWr%2Bmhv8K36ams5LiBIiwiaG90IjowfSx7ImlkIjoxLCJuYW1lIjoi5L%2Bu5pS55aWl6L%2BqIiwiSW5pdGlhbHMiOiJBIiwibG9nbyI6IjIwMTcwNDEzXFwxMzYwMWM5NTdlNDE2NDNjZDg3MjViYTY5MGU1ZjcyZC5qcGciLCJpbnRyb2R1Y2UiOiLljJfkuqzlpaXov6oiLCJob3QiOjF9XSwiQiI6W3siaWQiOjQsIm5hbWUiOiLlrp3pqawiLCJJbml0aWFscyI6IkIiLCJsb2dvIjoiMjAxNzA0MTNcXDI5YmQzZjg4NjYxYjljODJkMDUyODkyYzNlMzViZDNlLmpwZyIsImludHJvZHVjZSI6IuWMl%2BS6rOWunemprCIsImhvdCI6MX0seyJpZCI6NSwibmFtZSI6IuWllOmpsCIsIkluaXRpYWxzIjoiQiIsImxvZ28iOiIyMDE3MDQxM1xcOTdlOWYyMjQ1YzRiZDUwZWU5ZmMxMWU4MDk4ZDQ5MGYuanBnIiwiaW50cm9kdWNlIjoi5YyX5Lqs5aWU6amwIiwiaG90IjoxfSx7ImlkIjoxMSwibmFtZSI6IuacrOeUsCIsIkluaXRpYWxzIjoiQiIsImxvZ28iOiIyMDE3MDQxM1xcYTE4YzdlMTc3Y2NlMmExNzJmNGZjMTJlNzI0Yjk0ZjQuanBnIiwiaW50cm9kdWNlIjoi5pys55SwIiwiaG90IjoxfSx7ImlkIjo4LCJuYW1lIjoi5a6%2B5YipIiwiSW5pdGlhbHMiOiJCIiwibG9nbyI6IjIwMTcwNDEzXFxmODM2MGEzMTY4MzM0Mjg3Njg3MTc3NTRlNmIwZjI4Yy5qcGciLCJpbnRyb2R1Y2UiOiLnl4XkvosiLCJob3QiOjB9XSwiTCI6W3siaWQiOjEwLCJuYW1lIjoi5YWw5Y2a5Z%2B65bC8IiwiSW5pdGlhbHMiOiJMIiwibG9nbyI6IjIwMTcwNDEzXFw3NTQxZGRlZjY4NzVhYjgyMTIzMjhjODk5MWZmZWY3Ni5qcGciLCJpbnRyb2R1Y2UiOiLlhbDljZrln7rlsLwiLCJob3QiOjB9XSwiTSI6W3siaWQiOjksIm5hbWUiOiLnjpvojo7mi4nokoIiLCJJbml0aWFscyI6Ik0iLCJsb2dvIjoiMjAxNzA0MTNcXGExZmUwZjgyNWE3ODdhOGUwNjg5MTU1ODU2NmFmMzExLmpwZyIsImludHJvZHVjZSI6IueOm%2BiOjuaLieiSgiIsImhvdCI6MX1dLCJSIjpbeyJpZCI6NiwibmFtZSI6IuaXpeS6pyIsIkluaXRpYWxzIjoiUiIsImxvZ28iOiIyMDE3MDQxM1xcNzA5Y2ZkZTM2OGI0MzBhMDZkYTUzNDQ0MWRkOTFjMzkuanBnIiwiaW50cm9kdWNlIjoi5pel5LqnIiwiaG90IjoxfV0sIloiOlt7ImlkIjoxNywibmFtZSI6IuWSi%2BWSiyIsIkluaXRpYWxzIjoiWiIsImxvZ28iOiIyMDE3MDQyMVxcYjI2NDE4ZjdmZThjZTM4OWQ3OTUyMjZjZjExMTIyZmYuanBnIiwiaW50cm9kdWNlIjoi5ZKL5ZKL5ZKLIiwiaG90IjowfV19"}
//                            Log.d("MainActivity", "+++++++++++" + response);
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                            //解析data
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean result = jsonObject.getBoolean("result");
                                String data = jsonObject.getString("data");
                                if (result) {
                                    //成功

                                    //url
                                    String urlDecoder = URLDecoder.decode(data, "UTF-8").trim();
                                    Log.d("MainActivity", urlDecoder);
                                    //base64
//                                    EncodeUtils.base64Decode(urlDecoder)
//
                                    byte[] decode = Base64.decode(urlDecoder.getBytes(), Base64.DEFAULT);
                                    String json = new String(decode);
                                    Log.d("MainActivity", "++++++++++++++++++++"+json);

                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (UnsupportedEncodingException e) {
                                //设备不支持解析编码
                                e.printStackTrace();
                            }


                        }
                    });



//        String urlEncode = EncodeUtils.urlEncode(base64Token);
/*-------------------------------处理data END-------------------------------------------*/

/*-------------------------------处理sign BEGIN-------------------------------------------*/
//        String s="User-login";
//        String request_time="1493013463";
//        String data = "eyJVc2VyX25hbWUiOiIxMjE3MDM3NjEwIiwicGFzc3dvcmQiOiJlMTBhZGMzOTQ5YmE1OWFiYmU1NmUwNTdmMjBmODgzZSJ9";
//        String signKey = "A03137B2DC3DF13063EFB406151E81D3";
//        // $asign = md5("s={$s}&request_time={$request_time}&data={$datasign}||{$signKey}");
//        String sign = "s=" + s + "&request_time=" + request_time + "&data=" + data + "||" + signKey;
//        String md5 = EncryptUtils.encryptMD5ToString(sign.trim());
////        String md5 =   EncryptUtils.encryptMD5ToString("s=User-login&request_time=1493013463&data=eyJVc2VyX25hbWUiOiIxMjE3MDM3NjEwIiwicGFzc3dvcmQiOiJlMTBhZGMzOTQ5YmE1OWFiYmU1NmUwNTdmMjBmODgzZSJ9||A03137B2DC3DF13063EFB406151E81D3");
//
//        Log.d("MainActivity", sign);
//        Log.d("MainActivity", md5);






/*-------------------------------处理sign End-------------------------------------------*/
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "destroy");
        ButterKnife.unbind(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("MainActivity", "onSaveInstanceState2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState");
    }

}
