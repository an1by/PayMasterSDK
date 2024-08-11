package net.aniby.paymaster.client;

import net.aniby.paymaster.common.exceptions.ResponseBodyException;
import net.aniby.paymaster.modules.receipts.ReceiptCreateRequest;
import net.aniby.paymaster.modules.receipts.ReceiptDetails;
import net.aniby.paymaster.modules.receipts.ReceiptRequest;
import net.aniby.paymaster.modules.receipts.ReceiptListRequest;
import net.aniby.paymaster.utils.Constants;
import okhttp3.*;

import java.io.IOException;
import java.net.Proxy;

import static net.aniby.paymaster.utils.Constants.GSON;

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


    // Templates
    <T> T postRequest(Object jsonObject, String url, Class<T> _class) throws IOException {
        RequestBody requestBody = RequestBody.create(GSON.toJson(jsonObject), Constants.JSON_TYPE);
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Idempotency-Key", this.idempotencyKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(url)
                .post(requestBody)
                .build();
        return executeAndReturn(request, _class);
    }

    <T> T getRequest(String url, Class<T> _class) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Idempotency-Key", this.idempotencyKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(url)
                .get()
                .build();
        return executeAndReturn(request, _class);
    }

    <T> T executeAndReturn(Request request, Class<T> _class) throws IOException {
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null)
            throw ResponseBodyException.NULL;
        String body = responseBody.string();
        if (body.isEmpty())
            throw ResponseBodyException.EMPTY;

        T info = GSON.fromJson(body, _class);
        response.close();
        return info;
    }

    // Main functions
    public ReceiptDetails createReceipt(ReceiptCreateRequest request) throws IOException {
        return postRequest(request, Constants.Host.RECEIPTS, ReceiptDetails.class);
    }

    public ReceiptDetails getReceiptDetails(ReceiptRequest request) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addPathSegment(request.id())
                .build().toString();
        return getRequest(url, ReceiptDetails.class);
    }

    public ReceiptDetails[] getReceiptList(ReceiptListRequest request) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addQueryParameter("paymentId", request.paymentId())
                .build().toString();
        return getRequest(url, ReceiptDetails[].class);
    }

}
