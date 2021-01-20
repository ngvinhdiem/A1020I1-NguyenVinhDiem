package b4_lop_va_doi_tuong_trong_java.baitap;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
class StopWatch {
    Date now,startTime,endTime;

    public StopWatch() {
        now = new Date();
        this.startTime=now;
    }

    public void start() {
        now = new Date();
        this.startTime=now;
    }
    public void end() {
        now = new Date();
        this.endTime=now;
    }
    public long getElapsedTime() {
        return this.endTime.getTime()-this.startTime.getTime();
    }
}

public class XayDungLopStopWatch {
    public static void main(String[] args) {
        Random generator = new Random();
        StopWatch watch = new StopWatch();
        int num = 100000;
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = generator.nextInt();
        }
        System.out.println(Arrays.toString(array));
        int index,temp,i,j;
        watch.start();
        for (i = 0; i < num-1; i++) {
            index = i;
            for (j = i+1; j < num; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        watch.end();
        System.out.println(Arrays.toString(array));
        System.out.println(watch.getElapsedTime());

    }
}
