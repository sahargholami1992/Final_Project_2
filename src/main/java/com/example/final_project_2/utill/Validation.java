package com.example.final_project_2.utill;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}$";
    private static final String STRING_REGEX = "^[a-zA-Z\\s]+$";
    private static final Scanner SC = new Scanner(System.in);

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean containsOnlyAlphabetsAndSpaces(String input) {
        return input.matches(STRING_REGEX) && !StringUtils.isBlank(input);
    }


    public static byte[] readsImage(String imageName)  {
        InputStream inputStream = Validation.class.getClassLoader().getResourceAsStream(imageName);
        if (inputStream != null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bytesRead;
            byte[] buffer = new byte[1024];

            while (true) {
                try {
                    if ((bytesRead = inputStream.read(buffer)) == -1) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }else{
            System.out.println("invalid image name");
            return null;
        }
    }


    public static boolean isValidImage(byte[] imageData) {
        try {
            if (imageData == null || !isJpegFormat(imageData)) {
                System.out.println("Invalid image format. Only JPEG format is allowed.");
                return false;
            }
            if (!isWithinSizeLimit(imageData)) {
                System.out.println("Image size exceeds the maximum limit (300 KB).");
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isJpegFormat(byte[] imageData) throws IOException {
        if (imageData.length < 2) {
            return false;
        }
        return (imageData[0] & 0xFF) == 0xFF && (imageData[1] & 0xFF) == 0xD8;
    }

    private static boolean isWithinSizeLimit(byte[] imageData) {
        return imageData != null && imageData.length <= (long) 307200;
    }



    public static boolean saveImageToFile(byte[] imageData, String outputPath) {
        try (OutputStream outputStream = new FileOutputStream(outputPath)) {
            outputStream.write(imageData);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static Integer input() {
        int i;
        while (true) {
            try {
                i = SC.nextInt();
                SC.nextLine();
                return i;
            } catch (InputMismatchException in) {
                SC.nextLine();
                System.out.println("enter valid number !");
            }
        }
    }
    public static Double inputDouble() {
        double i;
        while (true) {
            try {
                i = SC.nextDouble();
                SC.nextLine();
                return i;
            } catch (InputMismatchException in) {
                SC.nextLine();
                System.out.println("enter valid number !");
            }
        }
    }
    public static boolean validateString(String string) {
        return !StringUtils.isBlank(string);
    }
    public static LocalDate validateAndProcessDate(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(inputDate, formatter);

    }

    }

