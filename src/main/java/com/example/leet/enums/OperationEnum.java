package com.example.leet.enums;

import java.util.function.BiFunction;

public class OperationEnum {
    //case 1
    enum Operation{
        ADD,
        SUBTRACT,
        MULTIPLY;
    }
    //usage if new enum introduced u might forget to change:
    public int apply(Operation operation, int x, int y){
        switch (operation){
            case ADD:
                return x + y;
            case SUBTRACT:
                return x - y;
            case MULTIPLY:
                return x * y;

            default:
                throw new UnsupportedOperationException();
        }
    }

    //case 2
    enum Operation1 {
        ADD,
        SUBTRACT,
        MULTIPLY;

        //
        public static int apply(Operation1 operation1, int arg1, int arg2) {
            switch(operation1) {
                case ADD:
                    return arg1 + arg2;
                case SUBTRACT:
                    return arg1 - arg2;
                case MULTIPLY:
                    return arg1 * arg2;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        //simpler
        public int apply(int x, int y){
            switch (this){
                case ADD:
                    return x + y;
                case SUBTRACT:
                    return x - y;
                case MULTIPLY:
                    return x * y;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    //case 3 functional programming
    enum Operation2{
        ADD((x, y) -> x + y),
        SUBTRACT((x, y) -> x - y),
        MULTIPLY((x, y) -> x * y);
        Operation2(BiFunction<Integer, Integer, Integer> operation) {
			this.operation = operation;
        }

        private final BiFunction<Integer, Integer, Integer> operation;

        public int apply(int x, int y){
            return operation.apply(x, y);
        }
        }
}
