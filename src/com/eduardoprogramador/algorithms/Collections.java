/*
 * Copyright 2022. Eduardo Programador
 * www.eduardoprogramador.com
 * Free softwares at Microsoft Store, PlayStore and Web Apps.
 * consultoria@eduardoprogramador.com
 *
 * All Rights Reserved.
 * */

package com.eduardoprogramador.algorithms;

public class Collections implements Order {
    private int[] numbers;
    private int index;
    private int change;
    private boolean goOn;

    private Collections() {}

    public static Collections startRoutine() {
        return new Collections();
    }

    public void load(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] result()  {

        return numbers;
    }

    public void showResult() {
        for(int i : numbers) {
            System.out.println(i);
        }
    }

    @Override
    public void bubbleSort() throws CollectionException {

        if(numbers == null)
            throw new CollectionException("You must first load an int array with the load() method.");

        goOn = false;

        for (int i = 0; i < numbers.length; i++) {

            if((i + 1) < numbers.length) {

                if(numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = temp;
                    goOn = true;
                }
            }
        }

        if(goOn)
            bubbleSort();

    }

    @Override
    public void selectionSort() throws CollectionException {

        if(numbers == null)
            throw new CollectionException("You must first load an int array with the load() method.");

        boolean goOn = false;
        boolean change = false;
        int actualSmaller = -1;
        int cur = 0;

        for (int i = 0; i < numbers.length; i++) {

            int total = numbers.length;;
            int first = numbers[i];

            if((i + 1) < total) {

                for (int j = (i + 1); j < total; j++) {
                    int second = numbers[j];

                    if(actualSmaller == -1) {
                        if(first > second) {
                            actualSmaller = second;
                            cur = j;
                            change = true;
                        } else {
                        }
                    } else {
                        if(actualSmaller > second) {
                            actualSmaller = second;
                            cur = j;
                            change = true;
                        } else {
                        }
                    }
                }

                if(change) {
                    int now = numbers[i];
                    numbers[i] = numbers[cur];
                    numbers[cur] = now;
                    goOn = true;
                } else {
                    goOn = false;
                }

            }

        }

        if(goOn) {
            selectionSort();
        }

    }

    @Override
    public void insertionSort() throws CollectionException {

        if(numbers == null)
            throw new CollectionException("You must first load an int array with the load() method.");

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0 && numbers[j-1] > numbers[j] ; j--) {
                int temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
            }
        }

    }

    @Override
    public void quickSort() throws CollectionException {

        if(numbers == null)
            throw new CollectionException("You must first load an int array with the load() method.");

        if(numbers.length > 1) {

            for (int i = 1; i < numbers.length; i++) {
                if(numbers[i] <= numbers[index]) {
                    change++;
                    if(change < numbers.length) {
                        int temp = numbers[i];
                        numbers[i] = numbers[change];
                        numbers[change] = temp;
                    }
                }
            }

            for (int i = 0; i < numbers.length; i++) {

                if(numbers[i] > numbers[index]) {
                    int temp = numbers[i - 1];
                    numbers[i - 1] = numbers[index];
                    numbers[index] = temp;
                    index = (i - 1);
                    break;
                }
            }

            for (int i = 0; i < (numbers.length); i++) {

                for (int j = 0; j < (index -1); j++) {
                    if((j+1) < (index)) {
                        if(numbers[j] > numbers[j+1]) {
                            int temp = numbers[j+1];
                            numbers[j+1] = numbers[j];
                            numbers[j] = temp;
                        }
                    }
                }

                    for (int j = index; j < numbers.length; j++) {
                        if((j+1) < numbers.length) {
                            if(numbers[j] > numbers[j+1]) {
                                int temp = numbers[j+1];
                                numbers[j+1] = numbers[j];
                                numbers[j] = temp;
                            }
                        }
                    }
            }
        }
    }
}


