package hello.core.singleton;

public class SingletonService {
//    static 영역에는 하나만 올라가는 것 잊지 말기
    private static final SingletonService instance = new SingletonService();

//    객체의 인스턴스가 필요할 경우 static을 통해 조회할 수 있도록 허용 -> 항상 같은 instance 를 반환
    public static SingletonService getInstance() {
        return instance;
    }

//    외부에서 생성자를 호출할 수 없도록 private 으로 생성자 설정
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }

}
