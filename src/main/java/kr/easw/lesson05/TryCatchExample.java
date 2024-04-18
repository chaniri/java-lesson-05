package kr.easw.lesson05;

import java.util.Scanner;


/**
 * 해당 클래스는 try-catch문을 사용한 예제입니다.
 *
 *
 * try-catch문이란, try 블럭으로 시작하여 catch 블럭으로 끝나는 구문입니다.
 * try 블럭 안에서 예상치 못한 오류(예외)가 발생한 경우, catch 블럭에 어떠한 예외가 발생했는지를 확인하고, 이에 대한 처리를 할 수 있습니다.
 * catch 블럭 안의 예외는 부모 클래스를 지정했을 경우, 해당 부모 클래스의 자식 클래스도 처리할 수 있습니다.
 * 예를 들어, 해당 예제에서는 Integer.parseInt() 메서드를 사용하여 문자열을 정수로 변환하고 있습니다.
 * 해당 메서드는 문자열을 숫자로 변환하기 실패한 경우, NumberFormatException 예외를 발생시키나 이는 Exception 클래스로 예외 처리를 지정함으로써 처리할 수도 있습니다.
 * 다만, 이러한 경우는 모든 오류를 구분 없이 처리하기에, 일반적인 경우에서는 예측 가능한 클래스를 먼저 처리하고, 그 이후에 Exception 클래스를 처리하는 것이 권장됩니다.
 */
public class TryCatchExample {

    public static void main(String[] args) {
        // 콘솔 창에서 입력을 받는 Scanner 객체를 생성합니다.
        Scanner scanner = new Scanner(System.in);
        // 총 점수를 저장할 변수를 선언합니다.
        int totalScore = 0;
        // 몇 번째 반복인지 저장할 변수를 선언합니다.
        int cycle = 0;
        // 종료 여부를 저장할 변수를 선언합니다.
        boolean doExit = false;
        // do-while문을 사용하여 최소 1회 반복을 보장합니다.
        do {
            // 반복 횟수를 증가시킵니다.
            cycle++;
            // 사용자에게서 다음 입력을 받습니다.
            String nextValue = scanner.nextLine();
            // 만약 사용자가 "종료"를 입력했다면, 반복문을 종료합니다.
            if (nextValue.equals("종료")) {
                doExit = true;
                continue;
            }
            // 사용자가 입력한 값을 정수로 변환하여 총 점수에 더합니다.
            try {
                // 사용자가 입력한 값을 정수로 변환합니다.
                // 이 때, 만약 사용자가 숫자가 아닌 값을 입력했다면, NumberFormatException 예외가 발생합니다.
                int score = Integer.parseInt(nextValue);
                // 총 점수에 사용자가 입력한 값을 더합니다.
                totalScore += score;
            } catch (NumberFormatException e) {
                // 사용자가 숫자가 아닌 값을 입력했을 경우, 다음과 같은 메시지를 출력합니다.
                System.out.println("숫자를 입력해주세요.");
            }
            // 사용자가 종료 명령을 내리지 않았다면, 다음 입력을 받습니다.
        } while (!doExit);
        // 반복문이 종료되었을 때, 총 점수와 평균 점수를 출력합니다.
        System.out.println("총 점수는 " + totalScore + "점 입니다.");
        System.out.println("평균 점수는 " + ((double) totalScore / cycle) + "점 입니다.");
    }
}
