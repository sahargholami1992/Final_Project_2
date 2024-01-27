package com.example.final_project_2.utill;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.io.IOException;

public class ImageValidator implements ConstraintValidator<ValidImage, byte[]> {



    @Override
    public boolean isValid(byte[] imageData, ConstraintValidatorContext context) {
        // Check if the byte array is not null or empty
        if (imageData == null || imageData.length == 0) {
            return false;
        }

        // Check image size
        if (imageData.length > 300 * 1024) { // 300 KB
            return false;
        }

        // Check image format
        try {
            // You can perform additional checks for image format here if needed
            return isJpgFormat(imageData); // Example: Check if the image is in JPG format
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your requirements
            return false;
        }
    }

    private boolean isJpgFormat(byte[] imageData) throws IOException {
        // Implement logic to check if the byte array represents a valid JPG image
        // For simplicity, you can use a third-party library like Apache Commons Imaging or other image processing libraries
        // Example: return ImageFormatChecker.isJpgFormat(imageData);
        if (imageData.length < 2) {
            return false;
        }
        return (imageData[0] & 0xFF) == 0xFF && (imageData[1] & 0xFF) == 0xD8;
    }
}