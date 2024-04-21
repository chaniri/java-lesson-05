package kr.easw.lesson05;

/**
 * 다음 코드는 싱글톤 패턴을 구현한 예제입니다.
 *
 * 싱글톤 패턴은, 해당 클래스의 인스턴스가 오직 하나만 존재하도록 하는 디자인 패턴입니다.
 * 클래스의 수정 및 확장을 방지하고, 메모리 사용을 최적화할 수 있습니다.
 *
 * 싱글톤 클래스는 보통 유틸리티 클래스에 사용되며, 외부에서 해당 클래스의 상속 및 인스턴스 생성을 원치 않는 경우에도 사용합니다.
 */
public class SingletonExample {
    // 싱글톤 클래스의 인스턴스는 private static final로 선언합니다.
    // 보통 지정된 클래스에 하나의 인스턴스만을 선언하며, 일반적인 경우는 이 클래스가 싱글톤임을 알리기 위해 변수명을 대문자로 사용합니다.
    public static final PerformanceImpactingSomething SOMETHING = new PerformanceImpactingSomething();

    public static void main(String[] args) {
        // SOMETHING을 통해 doSomething 메서드를 호출합니다.
        System.out.println(SOMETHING.doSomething());
    }

    // 추가적인 상속을 막기 위해 private 생성자를 선언합니다.
    // 또한, 외부에서 인스턴스 사용은 가능하게끔 스태틱 클래스로 선언합니다.
    // 이렇게 하면, 리플렉션과 같은 특수한 경우를 제외하면 해당 클래스의 인스턴스는 오직 하나만 존재하게 됩니다.
    private static final class PerformanceImpactingSomething {

        // 작업을 수행하는 메서드입니다.
        // 외부에서 호출할 필요가 없으므로 private으로 선언합니다.
        private String doSomething() {
            try {
                Thread.sleep(5000L); // 5초 동안 스레드를 잠시 멈춥니다.
            } catch (InterruptedException ex) {
                // InterruptedException이 발생할 경우, 처리하지 않고 무시합니다.
            }
            return "Hello, World!";
        }
    }
}
