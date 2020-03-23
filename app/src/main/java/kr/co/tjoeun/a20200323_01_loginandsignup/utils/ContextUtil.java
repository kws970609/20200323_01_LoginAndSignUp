package kr.co.tjoeun.a20200323_01_loginandsignup.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextUtil {

//    메모장 파일 처럼 데이터 내용 저장할 공간의 이름으로 쓸 변수.
    private static final String prefName = "myPref";

//    항목 명도 자동완성 지원 할수 있도록 미리 변수화.
    private static final String EMAIL = "EAMIL";


//    static : 누가하던지 중요하지않음. static 안에서쓰는 애들은 무조건 static이여야함
//    프로그램 시작시 제일먼저 별도로 생성
//   static 메쏘드 가 멤버변수 사용시 변수도 static이여야함
//    final = 굳힌다 / 못바꾸게 함


//    해당하목의 값을 저장setter/ 조회하는 메쏘드getter 추가.

//    setter
    public static void setEmail(Context context, String email) {

//        메모장 이용해서 값을 기록 => 메모장 파일 오픈
//          메모장은 context를 이용해서 오픈=> context 변수도 파라미터로 받아야함.

//        메모장을 열때 1) 어떤 메모장을 열지 2) 어떤 모드로 열지 -> Contet.Mode_Private

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

//        열린 메모장에 항목(key)/(value)값 저장
        pref.edit().putString(EMAIL, email ).apply();


    }

}
