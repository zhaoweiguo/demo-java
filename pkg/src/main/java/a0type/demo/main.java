package a0type.demo;

public class main {

    public static void main(String[] args) {
        String[] str = {
                "Hello, World!",
                "你好，中国",
                "hi, 123",
                "Hello, 你好，123",
        };
        System.out.println("================== String.length() =================================");
        for (String s : str) {
            System.out.printf("len(%s): %d\n", s, s.length());
        }

        System.out.println("================== String.getUTF8Length() =================================");
        for (String s : str) {
            int len = getUTF8Length(s);
            System.out.printf("len(%s): %d\n", s, len);
        }
    }

    private static int getUTF8Length(String s) {
        byte[] utf8Bytes = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);  // 明确指定了使用UTF-8字符集进行转换
//        byte[] utf8Bytes = s.getBytes();  // 使用平台默认的字符集进行转换
        return utf8Bytes.length;
    }



}
