package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;     //문제가 되는 부분
    }

//    무상태로 설계하는 방법 -> 값을 직접 반환하도록 작성, 공유자원을 조회하여 값을 가져오는 형태는 위험
//    public int order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        return price;
//    아래의 getPrice 제거
//}

    public int getPrice() {
        return price;
    }
}
