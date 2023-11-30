import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from datetime import datetime
from sqlalchemy import create_engine

# 資料庫連線
db_connection_str = "mysql+mysqlconnector://root:sS123456@127.0.0.1:3306/專題"
engine = create_engine(db_connection_str)

# 讀取CSV檔案
csv_file = "GoogleTrends.csv"
df = pd.read_csv(csv_file)

# 將資料寫入資料庫
table_name = "googletrends"  # 資料表名稱
df.to_sql(table_name, con=engine, if_exists="replace", index=False)
print("GoogleTrends.csv檔案已上傳到資料庫")

# 從資料庫讀取資料
query = "SELECT * FROM googletrends"
df = pd.read_sql(query, con=engine)

# 創建一個空的圖表並設定size
plt.figure(figsize=(20, 14))

# 調整線條的y軸範圍，這裡設定為(0, 100)範圍
plt.ylim(0, 100)

# 設定中文字型
font_path = r"C:/Windows/Fonts/msjh.ttc"
font_prop = fm.FontProperties(fname=font_path)
plt.rcParams["font.family"] = font_prop.get_name()
plt.rcParams["font.size"] = 20

# 設定 X 軸刻度範圍
start_date = datetime(2013, 10, 1)  # 起始日期
end_date = datetime(2023, 10, 1)  # 結束日期

# 自訂 X 軸刻度為每隔一年的日期
ax = plt.gca()
ax.set_xlim(start_date, end_date)  # 設定 X 軸刻度範圍

# 製作四條趨勢線
plt.plot(df.iloc[:, 0], df.iloc[:, 1], label="ESG", color="blue")
plt.plot(df.iloc[:, 0], df.iloc[:, 2], label="永續", color="purple")
plt.plot(df.iloc[:, 0], df.iloc[:, 3], label="溫室氣體", color="red")
plt.plot(df.iloc[:, 0], df.iloc[:, 4], label="淨零排放", color="orange")

# 添加標題和標籤
plt.title("過去10年關鍵字趨勢")
plt.xlabel("年份")
plt.ylabel("熱度", rotation=0)

# 顯示圖例
plt.legend(loc="upper left")

# 儲存圖表為PNG
output_png = "output.png" 
plt.savefig(output_png, format="png")
print("png file saved")

# 顯示圖表
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()
