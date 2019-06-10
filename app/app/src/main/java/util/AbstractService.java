package util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class  AbstractService<T> {
    private OkHttpClient http =  new OkHttpClient();
    private String URL = "";
    private String PATH = "";
    private Object JSONObject;


    public AbstractService(String path) {
        PATH = path;
    }
    public List<T> getAll() {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL.concat(PATH))
                .get()
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            String jsonString = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonString);
            return (List<T>) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T getById(Integer id) {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(URL.concat(PATH).concat(id.toString()))
                .get()
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            String jsonString = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonString);
            return (T) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T save(T objeto) {
        OkHttpClient httpClient = new OkHttpClient();


        String json = "";

        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url(URL.concat(PATH))
                .post(body)
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            String jsonString = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonString);
            return (T) jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}


