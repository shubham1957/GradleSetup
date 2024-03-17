package org.example;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOError;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient(); // okhttp is external lib that makes hhtp calls easy

        String url ="https://jsonplaceholder.typicode.com/todos/1";

        Request request = new Request.Builder()
                .url(url)
                .build(); // request object

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()){
                System.out.println("Something went wrong !");
            }
            System.out.println(response.body().string());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }



    }
}