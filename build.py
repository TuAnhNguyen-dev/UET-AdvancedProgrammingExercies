import os

# Tên thư mục gốc
root_folder = "NguyenDuyTuAnh_25020016_WeekX"

# Nội dung run.sh mới, cập nhật theo chuẩn yêu cầu trong ảnh
# Lưu ý: Lệnh chạy được đổi thành 'Solution' để khớp với lớp code của chúng ta
run_sh_content = """#!/bin/bash
javac src/*.java
java -cp src Main
"""

# Nội dung mẫu cho Solution.java
solution_template = """public class Main {
    public static void main(String[] args) {
        System.out.println("Bài tập đang chờ triển khai!");
    }
}
"""

run_all_content = """#!/bin/bash

for i in {1..10}; do
  dir=Bai$(printf "%02d" $i)
  echo "===== $dir ====="
  (cd $dir && bash run.sh)
  echo ""
done
"""

def create_run_all_file():
    file_path = os.path.join(root_folder, "run_all.sh")
    with open(file_path, "w", encoding='utf-8', newline="\n") as f:
        f.write(run_all_content)
    print(f"Đã tạo file: {file_path}")

# Nội dung file zip_submission.py
zip_submission_content = """import zipfile
import os

def zip_project(output_filename):
    # Các thư mục và file cần bỏ qua
    ignore_dirs = {'build', 'target', '.git', '__pycache__', '.idea'}
    ignore_extensions = {'.class', '.iml'}
    ignore_files = {'zip_submission.py'}

    print(f"Đang nén dự án vào: {output_filename}...")
    
    with zipfile.ZipFile(output_filename, 'w', zipfile.ZIP_DEFLATED) as zipf:
        for root, dirs, files in os.walk('.'):
            # Loại bỏ các thư mục không cần thiết trong quá trình duyệt
            dirs[:] = [d for d in dirs if d not in ignore_dirs]
            
            for file in files:
                if file in ignore_files:
                    continue
                if file == output_filename:
                    continue
                if any(file.endswith(ext) for ext in ignore_extensions):
                    continue
                
                file_path = os.path.join(root, file)
                # Thêm file vào zip, lưu giữ cấu trúc thư mục
                zipf.write(file_path, os.path.relpath(file_path, '.'))
                print(f"Đã thêm: {file_path}")

    print(f"Xong! File nén đã sẵn sàng: {output_filename}")

if __name__ == "__main__":
    # Lấy tên thư mục chứa file này làm tên file zip
    dir_name = os.path.basename(os.path.dirname(os.path.abspath(__file__)))
    zip_project(f'{dir_name}.zip')
"""

def create_zip_submission_file():
    """Tạo file zip_submission.py trong thư mục HaDuyAnh_25020009_WeekX"""
    file_path = os.path.join(root_folder, "zip_submission.py")
    with open(file_path, "w", encoding='utf-8') as f:
        f.write(zip_submission_content)
    print(f"Đã tạo file: {file_path}")

def create_structure():
    if not os.path.exists(root_folder):
        os.makedirs(root_folder)
        
    for i in range(1, 11):
        bai_name = f"Bai{i:02d}" # Tạo tên folder Bai01, Bai02,...
        path = os.path.join(root_folder, bai_name)
        src_path = os.path.join(path, "src")
        
        os.makedirs(src_path, exist_ok=True)
        
        # Tạo file run.sh với encoding utf-8 để tránh lỗi
        with open(os.path.join(path, "run.sh"), "w", encoding='utf-8', newline="\n") as f:
            f.write(run_sh_content)
        
        # Tạo file Solution.java (nếu chưa tồn tại)
        if not os.path.exists(os.path.join(src_path, "Main.java")):
            with open(os.path.join(src_path, "Main.java"), "w", encoding='utf-8') as f:
                f.write(solution_template)
                
    print(f"Đã cập nhật xong cấu trúc thư mục tại: {root_folder} với run.sh mới.")

if __name__ == "__main__":
    create_structure()
    create_run_all_file()
    create_zip_submission_file()
     