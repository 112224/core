package hello.core.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);


    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작할 때 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url +" message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("closed: " + url);
    }


    public void init() throws Exception {

        connect();
        call("초기화 연결 메시지");

    }

    public void close() throws Exception {
        disconnect();
    }
}
