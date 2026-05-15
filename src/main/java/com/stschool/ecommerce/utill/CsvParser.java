//package com.stschool.ecommerce.utill;
//
//import com.stschool.ecommerce.entity.Product;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class CsvParser {
//    public List<Product> getCustomersFromCsv() throws IOException {
////    List<Customer> customers = new ArrayList<>();
////    File file = new File("D:\\Student_tribe\\products.csv");
////    BufferedReader br = new BufferedReader(new FileReader(file));
////    br.readLine();
////    String customerData = br.readLine();
////    while (customerData != null) {
////        String[] split = customerData.split(",");
////        Customer product = new Customer();
////        product.setId(Integer.parseInt(split[0]))
////                .setName(split[1])
////                .setMaxRetailPrice(Double.parseDouble(split[2]))
////                .setDiscountPercentage(Double.parseDouble(split[3]))
////                .setAvailable(Boolean.parseBoolean(split[4]))
////                .setCompany(split[5])
////                .setCategory(split[6])
////                .setManufacturedYear(Integer.parseInt(split[7]));
////        products.add(product);
////    }
////    return products;
//        InputStream is = getClass()
//                .getClassLoader()
//                .getResourceAsStream("customer.csv");
//
//        if (is == null) {
//            throw new RuntimeException("Products.CSV not found in the resources");
//        }
//
//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(is))) {
//            return br.lines()
//                    .skip(1)
//                    .map(this::praseCustomer)
//                    .toList();
//        }
//    }
//
//    private Product praseCustomer(String line) {
//        String[] split = line.split(",", 10);
//        if (split.length < 13) {
//            throw new RuntimeException("Invalid CSV row :" + line);
//        }
//        try {
//            //Address residental = praseAddress(split[11])
//            return Product.builder()
//                    .id(Integer.parseInt(split[0].trim()))
//                    .name(split[1].trim())
//                    .email(split[2].trim().toLowerCase())
//                    .password(split[3].trim())
//                    .phoneNo(split[4].trim())
//                    .age(Byte.parseByte(split[5].trim().toUpperCase()))
//                    .gender(Gender.valueOf(split[6].trim().toUpperCase()))
//                    .status(Status.valueOf(split[7].trim().toUpperCase()))
//                    .membership(Membership.valueOf(split[8].trim().toUpperCase()))
//                    .build();
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error parsing customer row : " + line, e);
//        }
//
//    }
//
//    private Address parseAddress(String addressData) {
//
//        if (addressData == null || addressData.isEmpty()) return null;
//
//        String[] parts = addressData.split(":");
//
//        if (parts.length < 9) {
//            throw new RuntimeException("Invalid address: " + addressData);
//        }
//
//        return Address.builder()
//                .houseNo(parts[0].trim())
//                .building(parts[1].trim())
//                .landMark(parts[2].trim())
//                .street(parts[3].trim())
//                .city(parts[4].trim())
//                .district(parts[5].trim())
//                .state(parts[6].trim())
//                .country(parts[7].trim())
//                .zipCode(Integer.parseInt(parts[8].trim()))
//                .build();
//    }
//
//    // =========================
//    // DATE PARSER (SAFE)
//    // =========================
//
//    private LocalDateTime parseDate(String value) {
//        if (value == null || value.isBlank()) return null;
//        return LocalDateTime.parse(value.trim());
//    }
//}