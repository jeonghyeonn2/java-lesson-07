package kr.easw.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ���� 2���� �������� �Ұ��� List �÷��ǰ� ���ʸ����� �̿��� ��� ���� ���⸦ ��������.
 *
 * **�ݵ��** CalculatorImpl Ŭ������ �����Ͽ� ������ Ǯ��� �մϴ�.
 *
 * �ش� ������ ������ ���� ���� ������ �ֽ��ϴ� :
 * - CalculatorImpl Ŭ������ Calculator �������̽��� �����ؾ� �մϴ�.
 * - CalculatorImpl Ŭ������ List�� �ݵ�� ����ؾ� �մϴ�.
 * - ������ ������ �߻����� �ʾƾ� �մϴ�.
 * - �Էµ� ������ ���� ���, RuntimeException�� �߻����Ѿ� �մϴ�.
 */
public class ScoreCalculatorWithList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new CalculatorImpl();

        while (true) {
            System.out.println("Enter the subject and score.");
            System.out.print("> ");
            String subject = scanner.next();
            if (subject.equals("exit")) {
                break;
            }
            int score = scanner.nextInt();
            calculator.addScore(subject, score);
        }
        System.out.printf("Subject Counts: %d; Average: %.2f; ", calculator.getSubjectCount(), calculator.getAverage());
    }

    interface Calculator {
        void addScore(String subject, int score);

        double getAverage();

        int getSubjectCount();
    }

    static class CalculatorImpl implements Calculator {
        private static final List<ScoreCalculatorWithList.Score> scores = new ArrayList<>();

        @Override
        public void addScore(String subject, int score) {
            scores.add(new ScoreCalculatorWithList.Score(subject,score));
        }

        @Override
        public double getAverage() {
            if (scores.isEmpty()) {
                throw new RuntimeException("�Էµ� ������ �����ϴ�.");
            }

            int total = 0;
            for (Score score : scores) {
                total += score.getScore();
            }

            return (double) total / scores.size();
        }

        @Override
        public int getSubjectCount() {
            return scores.size();
        }
    }

    static class Score {
        private final String subject;
        private final int score;

        public Score(String subject, int score) {
            this.subject = subject;
            this.score = score;
        }

        public String getSubject() {
            return subject;
        }

        public int getScore() {
            return score;
        }
    }
}
