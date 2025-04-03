package Homework;

import java.util.Scanner;

public class Homework05 {
    public static enum ErrorEnum {
        PHONE_ERROR(101, "手机号码格式错误"),
        ArrayIndexOutOfBoundsException(102, "数组越界异常"),
        IllegalArgumentException(103, "非法参数异常");

        private int errorcode;
        private String errormsg;

        ErrorEnum() {
        }

        ErrorEnum(int errorcode, String errormsg) {
            this.errorcode = errorcode;
            this.errormsg = errormsg;
        }
        public String getMsg(){
            return "ErrorEnum{" +
                    "errorcode=" + errorcode +
                    ", errormsg='" + errormsg + '\'' +
                    '}';
        }

    }
        public static class BusinessException extends RuntimeException {

            public BusinessException() {

            }

            public BusinessException(ErrorEnum a) {
                super(a.getMsg());
            }

        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String phonenumber = scanner.nextLine();
            if (!phonenumber.matches("^1[3-9]\\d{9}$")) {
                throw new BusinessException(ErrorEnum.PHONE_ERROR);
            }
        }

}
