#!/bin/bash

# 1. Tạo một thư mục 'out' để chứa các file .class (mã máy) cho sạch sẽ
mkdir -p out

# 2. Biên dịch TOÀN BỘ file .java trong thư mục src và ném kết quả vào thư mục out
# Chú ý: -d out nghĩa là "đổ file class vào thư mục out"
javac -d out -cp ".:lib/junit-platform-console-standalone-1.10.0.jar" src/*.java

# Kiểm tra xem lệnh javac có thành công không
if [ $? -ne 0 ]; then
    echo "❌ LỖI BIÊN DỊCH! Hãy kiểm tra lại code Java của bro."
    exit 1
fi

echo "✅ Biên dịch thành công! Bắt đầu chạy Test..."
echo "=================================================="

# 3. Kích hoạt JUnit
# Bí quyết ở đây là dùng --scan-class-path thay vì -c TênClass
# Nó sẽ tự chui vào thư mục out, tìm tất cả những file nào có chữ @Test để chạy!
java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp out --scan-class-path

echo "=================================================="