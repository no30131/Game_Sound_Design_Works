"""請讀取drugstore.csv檔案，並找尋開在板橋區的藥局後，再寫入新檔案"""

import csv

f1 = r"C:\Users\USER\Desktop\drugstore.csv" # 原始檔案
f2 = r"C:\Users\USER\Desktop\f2.csv" # 新的檔案要存放的路徑

# 開啟 f1 檔案，讀取「板橋區」的資料
data = []

with open(f1, encoding = "utf-8-sig") as readdata:
    reader = csv.DictReader(readdata)
    
    for row in reader:
        if row ['District'] == "板橋區": # 指定只要「板橋區」的內容
            data.append(row)  # 將資料存到列表

# 開啟 f2 檔案，寫入「板橋區」的資料						
with open(f2, "w", newline="") as writerdata:
    fieldnames = reader.fieldnames  # 取得原始檔案的標題行
    writerfile = csv.DictWriter(writerdata, fieldnames=fieldnames)
 
    # writerfile.writeheader()    # 這行打開可以帶入標題行
    
    for row in data:
        writerfile.writerow(row)  # 寫入列表資料到新檔案
    
print("寫入完成")  # 完成