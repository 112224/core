### 2022/02/07

현재 날짜에 작성된 상황에서 다음과 같은 설계상 문제점들이 있다.

* 다른 저장소로 변경시에 OCP 원칙이 잘 지켜지지 않음
* DIP 를 잘 준수하지 못함 -> 의존관계가 인터페이스 뿐만 아니라 실제 구현체에 까지 의존하는 문제점
* 추후 수정 사항