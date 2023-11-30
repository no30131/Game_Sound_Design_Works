import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from datetime import datetime
from sqlalchemy import create_engine
from matplotlib.ticker import FuncFormatter

def format_with_commas(value, _):
    # 將數字轉換為帶逗號的字符串格式
    return "{:,.0f}".format(value)

# 資料庫連線
db_connection_str = "mysql+mysqlconnector://root:sS123456@127.0.0.1:3306/專題"
engine = create_engine(db_connection_str)

# CSV檔案的路徑
csv_file_path = "畜禽屠宰數.csv"
df = pd.read_csv(csv_file_path)

# 將資料寫入資料庫
table_name = "slaughter"  # 資料表名稱
df.to_sql(table_name, con=engine, if_exists="replace", index=False)
print("slaughter.csv檔案已上傳到資料庫")

# 從資料庫讀取資料
query = "SELECT * FROM slaughter"
df = pd.read_sql(query, con=engine)

# 將日期資料中的日設為每個月的第一天
df["年份"] = df["年份"] + "-01"

# 轉換日期欄位為日期時間格式
df["年份"] = pd.to_datetime(df["年份"])

# 設定中文(影響整個程式)
plt.rcParams["font.family"] = "Microsoft JhengHei"
plt.rcParams["font.size"] = 20
plt.rcParams["axes.unicode_minus"] = False # 讓正負號能正常顯示

# 設定中文字體
font_path = r"C:/Windows/Fonts/msjh.ttc"
font_prop = fm.FontProperties(fname=font_path)

# 創建時間序列圖表
plt.figure(figsize=(18, 12))
plt.bar(df["年份"], df["屠宰總數"])

# 添加標題和標籤
plt.title("2006-2022年屠宰動物總數")
plt.xlabel("年份")
plt.ylabel("屠宰數", rotation=0)

# 設定X軸刻度為每隔一年
ax = plt.gca()

# 格式化y軸標籤的數字(加上逗點)
y_format = FuncFormatter(format_with_commas)
plt.gca().get_yaxis().set_major_formatter(y_format)

# 設定X軸的刻度範圍
start_date = datetime(2006, 1, 1)  # 起始日期
end_date = datetime(2022, 1, 1)  # 結束日期
ax.set_xlim(start_date, end_date)

# 顯示圖例
plt.legend()

# 儲存圖表為PNG
output_png = "Slaughter.png" 
plt.savefig(output_png, format="png")
print("file saved")

# 顯示圖表
plt.xticks(rotation=45)  # 旋轉X軸標籤，以便更好地顯示日期
plt.tight_layout()  # 調整圖表佈局
plt.show()

