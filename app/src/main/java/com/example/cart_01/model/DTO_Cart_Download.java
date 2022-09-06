package com.example.cart_01.model;

import java.util.Objects;

public class DTO_Cart_Download {

    long menuNum;
    String menuCG;

    String imgPath;
    String menuName;
    long menuPrice;
    String menuDetail;

    String OptKind01;
    String OptKind02;

    long OptPrice01;
    long OptPrice02;
    long OptPrice03;
    long OptPrice04;
    long OptPrice05;

    String OptSize01;
    String OptSize02;
    String OptSize03;

    Boolean StockState;

    // DTO 추가적으로 생성자 필요시 생성하기
    public DTO_Cart_Download() {
    }

    // 다이얼 로그 박스 생성자
    public DTO_Cart_Download(String menuName, long menuPrice, String menuDetail, String optKind01, String optKind02,
                             long optPrice01, long optPrice02, long optPrice03, long optPrice04, long optPrice05,
                             String optSize01, String optSize02, String optSize03)

    {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDetail = menuDetail;
        OptKind01 = optKind01;
        OptKind02 = optKind02;
        OptPrice01 = optPrice01;
        OptPrice02 = optPrice02;
        OptPrice03 = optPrice03;
        OptPrice04 = optPrice04;
        OptPrice05 = optPrice05;
        OptSize01 = optSize01;
        OptSize02 = optSize02;
        OptSize03 = optSize03;
    }

    // 전체 생성자
    public DTO_Cart_Download(long menuNum, String menuCG, String imgPath, String menuName,
                             long menuPrice, String menuDetail, String optKind01, String optKind02,
                             long optPrice01, long optPrice02, long optPrice03, long optPrice04, long optPrice05,
                             String optSize01, String optSize02, String optSize03, Boolean stockState)
    {
        this.menuNum = menuNum;
        this.menuCG = menuCG;
        this.imgPath = imgPath;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDetail = menuDetail;
        OptKind01 = optKind01;
        OptKind02 = optKind02;
        OptPrice01 = optPrice01;
        OptPrice02 = optPrice02;
        OptPrice03 = optPrice03;
        OptPrice04 = optPrice04;
        OptPrice05 = optPrice05;
        OptSize01 = optSize01;
        OptSize02 = optSize02;
        OptSize03 = optSize03;
        StockState = stockState;
    }

    public long getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(long menuNum) {
        this.menuNum = menuNum;
    }

    public String getMenuCG() {
        return menuCG;
    }

    public void setMenuCG(String menuCG) {
        this.menuCG = menuCG;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public long getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(long menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuDetail() {
        return menuDetail;
    }

    public void setMenuDetail(String menuDetail) {
        this.menuDetail = menuDetail;
    }

    public String getOptKind01() {
        return OptKind01;
    }

    public void setOptKind01(String optKind01) {
        OptKind01 = optKind01;
    }

    public String getOptKind02() {
        return OptKind02;
    }

    public void setOptKind02(String optKind02) {
        OptKind02 = optKind02;
    }

    public long getOptPrice01() {
        return OptPrice01;
    }

    public void setOptPrice01(long optPrice01) {
        OptPrice01 = optPrice01;
    }

    public long getOptPrice02() {
        return OptPrice02;
    }

    public void setOptPrice02(long optPrice02) {
        OptPrice02 = optPrice02;
    }

    public long getOptPrice03() {
        return OptPrice03;
    }

    public void setOptPrice03(long optPrice03) {
        OptPrice03 = optPrice03;
    }

    public long getOptPrice04() {
        return OptPrice04;
    }

    public void setOptPrice04(long optPrice04) {
        OptPrice04 = optPrice04;
    }

    public long getOptPrice05() {
        return OptPrice05;
    }

    public void setOptPrice05(long optPrice05) {
        OptPrice05 = optPrice05;
    }

    public String getOptSize01() {
        return OptSize01;
    }

    public void setOptSize01(String optSize01) {
        OptSize01 = optSize01;
    }

    public String getOptSize02() {
        return OptSize02;
    }

    public void setOptSize02(String optSize02) {
        OptSize02 = optSize02;
    }

    public String getOptSize03() {
        return OptSize03;
    }

    public void setOptSize03(String optSize03) {
        OptSize03 = optSize03;
    }

    public Boolean getStockState() {
        return StockState;
    }

    public void setStockState(Boolean stockState) {
        StockState = stockState;
    }

    @Override
    public String toString() {
        return "DTO_Cart{" +
                "menuNum=" + menuNum +
                ", menuCG='" + menuCG + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuDetail='" + menuDetail + '\'' +
                ", OptKind01='" + OptKind01 + '\'' +
                ", OptKind02='" + OptKind02 + '\'' +
                ", OptPrice01=" + OptPrice01 +
                ", OptPrice02=" + OptPrice02 +
                ", OptPrice03=" + OptPrice03 +
                ", OptPrice04=" + OptPrice04 +
                ", OptPrice05=" + OptPrice05 +
                ", OptSize01='" + OptSize01 + '\'' +
                ", OptSize02='" + OptSize02 + '\'' +
                ", OptSize03='" + OptSize03 + '\'' +
                ", StockState=" + StockState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTO_Cart_Download dto_cart = (DTO_Cart_Download) o;
        return menuNum == dto_cart.menuNum && menuPrice == dto_cart.menuPrice && OptPrice01 == dto_cart.OptPrice01 && OptPrice02 == dto_cart.OptPrice02 && OptPrice03 == dto_cart.OptPrice03 && OptPrice04 == dto_cart.OptPrice04 && OptPrice05 == dto_cart.OptPrice05 && Objects.equals(menuCG, dto_cart.menuCG) && Objects.equals(imgPath, dto_cart.imgPath) && Objects.equals(menuName, dto_cart.menuName) && Objects.equals(menuDetail, dto_cart.menuDetail) && Objects.equals(OptKind01, dto_cart.OptKind01) && Objects.equals(OptKind02, dto_cart.OptKind02) && Objects.equals(OptSize01, dto_cart.OptSize01) && Objects.equals(OptSize02, dto_cart.OptSize02) && Objects.equals(OptSize03, dto_cart.OptSize03) && Objects.equals(StockState, dto_cart.StockState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuNum, menuCG, imgPath, menuName, menuPrice, menuDetail, OptKind01, OptKind02, OptPrice01, OptPrice02, OptPrice03, OptPrice04, OptPrice05, OptSize01, OptSize02, OptSize03, StockState);
    }
}
