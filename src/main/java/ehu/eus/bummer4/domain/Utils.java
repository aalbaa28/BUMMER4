package ehu.eus.bummer4.domain;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    //
    static String request(String endpoint){
        String result = "";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://mastodon.social/api/v1/"+endpoint)
                        .get()
                        .addHeader("Authorization","Bearer" + System.getenv("TOKEN"))
                        .build();
        try{
            Response response = client.newCall(request).execute();
            if (response.code() == 200){
                result = response.body().string();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<Status> Principal(){
        String id="109897306445228536";
        String body = request("accounts/"+id+"/statuses");
        //System.out.println(body);

        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(body, JsonArray.class);

        Type statusList = new TypeToken<ArrayList<Status>>() {}.getType();
        List<Status> list = gson.fromJson(jsonArray.getAsJsonArray(), statusList);
        //System.out.println(list);
        return list;


    }


}
