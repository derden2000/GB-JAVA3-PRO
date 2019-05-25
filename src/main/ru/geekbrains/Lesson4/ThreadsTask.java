package main.ru.geekbrains.Lesson4;

public class ThreadsTask {

    private static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(ThreadsTask::printA).start();
        new Thread(ThreadsTask::printB).start();
        new Thread(ThreadsTask::printC).start();
        new Thread(ThreadsTask::printD).start();
    }

    private synchronized static void printA() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'A') {
                    ThreadsTask.class.wait();
                }
                Thread.sleep(100);
                System.out.println("A");
                currentLetter = 'B';
                ThreadsTask.class.notifyAll();  //сработает и с notify(), но только чудом: выбор пробуждаемого потока - рандомный
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printB() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'B') {
                    ThreadsTask.class.wait();
                }
                Thread.sleep(100);
                System.out.println("B");
                currentLetter = 'C';
                ThreadsTask.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printC() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'C') {
                    ThreadsTask.class.wait();
                }
                Thread.sleep(100);
                System.out.println("C");
                currentLetter = 'D';
                ThreadsTask.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printD() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'D') {
                    ThreadsTask.class.wait();
                }
                Thread.sleep(100);
                System.out.println("D");
                currentLetter = 'A';
                ThreadsTask.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
