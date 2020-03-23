package kr.co.tjoeun.a20200323_01_loginandsignup.utils;

import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerUtil {

//    이론
//    서버 통신 주체? ServerUtil
//    응답 처리? 액티비티가 함. => 인터페이스로 연결.

    public interface JsonResposeHandler {
        void onResponse(JSONObject json);
    }
//    서버 호스트 주소를 편하게 가져다 쓰려고 변수로 저장.
    private static final String BASE_URL = "http://192.168.0.236:5000";

//    로그인 요청 기능 메쏘드
//    파라미터의 기본구조 : 어떤 화면에서 어떤 응답처리를할지? 변수로.
//    파라미터 추가: 서버로 전달할때 필요한 데이터들을 변수로.
    public static void postRequestLogin(Context context, String id, String pw, JsonResposeHandler handler) {
//        클라이언트 역할 수행 변수 생성.
        OkHttpClient client = new OkHttpClient();

//        어느 주소로(호스트 주소/기능주소) 갈지? 변수로 저장.
//        192.?.?.?:5000/auth

        String urlStr = String.format("%s/auth",BASE_URL);

//        서버로 들고갈 파라미터 담아주기.
        FormBody fomData = new FormBody.Builder()
                .add("login_id", id)
                .add("password", pw)
                .build();

        Request request = new Request.Builder()
                .url(urlStr)
                .post(fomData)
                .build();
//                필요한 경우 .header도 추가해야함


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                연결에 실패했을 경우
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//               연결에 성공했을때=> 그냥 string변수로 뽑아낸다.
                String body = response.body().string();
                Log.d("로그인 응답",body);
            }
        });
    }


}
