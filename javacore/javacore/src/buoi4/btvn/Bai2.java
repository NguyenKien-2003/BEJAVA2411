package buoi4.btvn;

public class Bai2 {

        public static boolean isValidPhoneNumber(String phoneNumber) {
            // Bước 1: Loại bỏ tất cả các ký tự không phải là số (bao gồm dấu "-" và dấu ".")
            String cleanedPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");

            // Bước 2: Kiểm tra độ dài của số điện thoại (10 hoặc 11 chữ số)
            if (cleanedPhoneNumber.length() != 10 && cleanedPhoneNumber.length() != 11) {
                return false;
            }

            // Bước 3: Kiểm tra tiền tố hợp lệ
            // Số điện thoại phải bắt đầu bằng "0", "84", hoặc "+84"
            if (!(cleanedPhoneNumber.startsWith("0") || cleanedPhoneNumber.startsWith("84"))) {
                return false;
            }

            // Bước 4: Nếu có dấu "+" ở đầu, phải có "84" ngay sau dấu "+"
            if (phoneNumber.startsWith("+") && !cleanedPhoneNumber.startsWith("84")) {
                return false;
            }

            // Bước 5: Nếu không có ký tự nào ngoài số, dấu "-" và "."
            return true;
        }

        public static void main(String[] args) {
            String[] testNumbers = {
                    "084123456789",      // đúng
                    "+848412345678",     // đúng
                    "0.841234.5678",     // đúng
                    "0-841-234-5678",    // đúng
                    "08412345678",       // sai (ít số)
                    "084-123-45abc",     // sai (chứa ký tự không hợp lệ)
                    "0812345678",        // sai (không có đủ 9 chữ số)
                    "0841234567890",     // sai (thừa số)
            };

            for (String number : testNumbers) {
                System.out.println(number + " is valid: " + isValidPhoneNumber(number));
            }
        }
    }



