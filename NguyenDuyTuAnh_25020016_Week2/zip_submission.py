import zipfile
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
