package net.aniby.paymaster.client;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.net.Proxy;

public class PayMasterClient {
    private final OkHttpClient client;
    private final String bearerToken;
    private final String idempotencyKey;

    public PayMasterClient(String bearerToken, String idempotencyKey) {
        this.bearerToken = bearerToken;
        this.idempotencyKey = idempotencyKey;
        this.client = new OkHttpClient.Builder().build();
    }

    public PayMasterClient(String bearerToken, String idempotencyKey, Proxy proxy) {
        this.bearerToken = bearerToken;
        this.idempotencyKey = idempotencyKey;
        this.client = new OkHttpClient.Builder().proxy(proxy).build();
    }

    <T> T request(RequestBody formBody, String url, Class<T> _class) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Idempotency-Key", this.idempotencyKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(url)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null)
            throw new IOException("Response body is null");
        String body = responseBody.string();
        if (body.isEmpty())
            throw new IOException("Response body is empty");

        T info = new Gson().fromJson(body, _class);
        response.close();
        return info;
    }

}
