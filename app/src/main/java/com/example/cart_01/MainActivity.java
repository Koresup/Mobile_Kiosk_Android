package com.example.cart_01;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.cart_01.model.DTO_Cart_Download;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView = null;
    ListView orderListLayout;

    Button mainBtn, sideBtn, etcBtn, cancelBtn;
    FirebaseFirestore fb = FirebaseFirestore.getInstance();
    List<DTO_Cart_Download> list_menu = new ArrayList<DTO_Cart_Download>(); // 선택된 메뉴들이 담길 리스트
    Adapter_Cart mAdapter = null;

    String img_Path;
    long menuNum;
    String menu_CG;
    String menuName;
    long menuPrice;
    String menuDetail;
    String optKind01;
    String optKind02;
    long optPrice01;
    long optPrice02;
    long optPrice03;
    long optPrice04;
    long optPrice05;
    String optSize01;
    String optSize02;
    String optSize03;
    Boolean stockState;

    int sum = 0;
    long total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn = (Button) findViewById(R.id.leftTopMain);
        sideBtn = (Button) findViewById(R.id.leftTopSide);
        etcBtn = (Button) findViewById(R.id.leftTopEtc);
        orderListLayout = (ListView) findViewById(R.id.orderListLayout);
        cancelBtn = (Button) findViewById(R.id.btn_clear);

        mAdapter = new Adapter_Cart(this);
        mListView  = (ListView) findViewById(R.id.orderListLayout);
        mListView.setAdapter(mAdapter);

        mainBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                selectAll("Main");
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    mainBtn.setBackgroundResource(R.drawable.btn_dialog_selected);
                    mainBtn.setTextColor(Color.WHITE);
                    sideBtn.setBackgroundResource(R.drawable.btn_default);
                    sideBtn.setTextColor(Color.BLACK);
                    etcBtn.setBackgroundResource(R.drawable.btn_default);
                    etcBtn.setTextColor(Color.BLACK);
                }
                return false;
            }
        });

        sideBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                selectAll("Side");
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    mainBtn.setBackgroundResource(R.drawable.btn_default);
                    mainBtn.setTextColor(Color.BLACK);
                    sideBtn.setBackgroundResource(R.drawable.btn_dialog_selected);
                    sideBtn.setTextColor(Color.WHITE);
                    etcBtn.setBackgroundResource(R.drawable.btn_default);
                    etcBtn.setTextColor(Color.BLACK);
                }
                return false;
            }
        });

        etcBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                selectAll("Etc");
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    mainBtn.setBackgroundResource(R.drawable.btn_default);
                    mainBtn.setTextColor(Color.BLACK);
                    sideBtn.setBackgroundResource(R.drawable.btn_default);
                    sideBtn.setTextColor(Color.BLACK);
                    etcBtn.setBackgroundResource(R.drawable.btn_dialog_selected);
                    etcBtn.setTextColor(Color.WHITE);
                }
                return false;
            }
        });
    }

    // 전체 삭제
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.btn_clear: {
                Toast.makeText(getApplicationContext(), "전체 삭제 입니당", Toast.LENGTH_SHORT).show();
                mAdapter.clear();
                // 합계 금액 초기화
                sum = 0;
                Dialog_menu.setTotalPrice(sum);
                break;
            }
        }
    }

    public void selectAll(String btnType) {
        fb.collection("Enterprise_Users").document("alstn6887@naver.com").collection("MenuList")
        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) { // task는 경로를 담는다? 쿼리는 담는다?
                if (task.isSuccessful()) {
                    list_menu.clear(); // 초기화 시켜주어 증식 방지
                    for (QueryDocumentSnapshot doc : task.getResult()) { // QueryDocumentSnapshot..?
                        String menuCG = doc.getData().get("MenuCG").toString();
                        if(btnType.equals("Main") && menuCG.equals("Main")) {
                            img_Path = doc.getData().get("Img_Path").toString();
                            menuNum = Long.parseLong(doc.getData().get("Menu_Num").toString());
                            menu_CG = doc.getData().get("MenuCG").toString();
                            menuName = doc.getData().get("MenuName").toString();
                            menuPrice = Long.parseLong(doc.getData().get("MenuPrice").toString());
                            menuDetail = doc.getData().get("MenuDetail").toString();
                            optKind01 = doc.getData().get("OptKind01").toString();
                            optKind02 = doc.getData().get("OptKind02").toString();
                            optPrice01 = Long.parseLong(doc.getData().get("OptPrice01").toString());
                            optPrice02 = Long.parseLong(doc.getData().get("OptPrice02").toString());
                            optPrice03 = Long.parseLong(doc.getData().get("OptPrice03").toString());
                            optPrice04 = Long.parseLong(doc.getData().get("OptPrice04").toString());
                            optPrice05 = Long.parseLong(doc.getData().get("OptPrice05").toString());
                            optSize01 = doc.getData().get("OptSize01").toString();
                            optSize02 = doc.getData().get("OptSize02").toString();
                            optSize03 = doc.getData().get("OptSize03").toString();
                            stockState = (Boolean) doc.getData().get("StockStage");

                            list_menu.add(new DTO_Cart_Download(menuNum, menu_CG, img_Path, menuName, menuPrice, menuDetail, optKind01, optKind02,
                                    optPrice01, optPrice02, optPrice03, optPrice04, optPrice05, optSize01, optSize02, optSize03, stockState));

                        } else if (btnType.equals("Side") && menuCG.equals("Side")) {
                            img_Path = doc.getData().get("Img_Path").toString();
                            menuNum = Long.parseLong(doc.getData().get("Menu_Num").toString());
                            menu_CG = doc.getData().get("MenuCG").toString();
                            menuName = doc.getData().get("MenuName").toString();
                            menuPrice = Long.parseLong(doc.getData().get("MenuPrice").toString());
                            menuDetail = doc.getData().get("MenuDetail").toString();
                            optKind01 = doc.getData().get("OptKind01").toString();
                            optKind02 = doc.getData().get("OptKind02").toString();
                            optPrice01 = Long.parseLong(doc.getData().get("OptPrice01").toString());
                            optPrice02 = Long.parseLong(doc.getData().get("OptPrice02").toString());
                            optPrice03 = Long.parseLong(doc.getData().get("OptPrice03").toString());
                            optPrice04 = Long.parseLong(doc.getData().get("OptPrice04").toString());
                            optPrice05 = Long.parseLong(doc.getData().get("OptPrice05").toString());
                            optSize01 = doc.getData().get("OptSize01").toString();
                            optSize02 = doc.getData().get("OptSize02").toString();
                            optSize03 = doc.getData().get("OptSize03").toString();
                            stockState = (Boolean) doc.getData().get("StockStage");

                            list_menu.add(new DTO_Cart_Download(menuNum, menu_CG, img_Path, menuName, menuPrice, menuDetail, optKind01, optKind02,
                                    optPrice01, optPrice02, optPrice03, optPrice04, optPrice05, optSize01, optSize02, optSize03, stockState));

                        } else if (btnType.equals("Etc") && menuCG.equals("Etc")) {
                            img_Path = doc.getData().get("Img_Path").toString();
                            menuNum = Long.parseLong(doc.getData().get("Menu_Num").toString());
                            menu_CG = doc.getData().get("MenuCG").toString();
                            menuName = doc.getData().get("MenuName").toString();
                            menuPrice = Long.parseLong(doc.getData().get("MenuPrice").toString());
                            menuDetail = doc.getData().get("MenuDetail").toString();
                            optKind01 = doc.getData().get("OptKind01").toString();
                            optKind02 = doc.getData().get("OptKind02").toString();
                            optPrice01 = Long.parseLong(doc.getData().get("OptPrice01").toString());
                            optPrice02 = Long.parseLong(doc.getData().get("OptPrice02").toString());
                            optPrice03 = Long.parseLong(doc.getData().get("OptPrice03").toString());
                            optPrice04 = Long.parseLong(doc.getData().get("OptPrice04").toString());
                            optPrice05 = Long.parseLong(doc.getData().get("OptPrice05").toString());
                            optSize01 = doc.getData().get("OptSize01").toString();
                            optSize02 = doc.getData().get("OptSize02").toString();
                            optSize03 = doc.getData().get("OptSize03").toString();
                            stockState = (Boolean) doc.getData().get("StockStage");

                            list_menu.add(new DTO_Cart_Download(menuNum, menu_CG, img_Path, menuName, menuPrice, menuDetail, optKind01, optKind02,
                                    optPrice01, optPrice02, optPrice03, optPrice04, optPrice05, optSize01, optSize02, optSize03, stockState));
                        }

                        if (menuCG.equals("Main") || menuCG.equals("Side") || menuCG.equals("Etc")) {
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            Frag_main fragment1 = new Frag_main(MainActivity.this, list_menu);
                            transaction.replace(R.id.leftFrame, fragment1);
                            transaction.commitAllowingStateLoss();
                        }
                    }
                } else {
                    Log.d("Error : ","Getting selectAll Method = ", task.getException());
                    Toast.makeText(getApplicationContext(), "자료 업로드 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}