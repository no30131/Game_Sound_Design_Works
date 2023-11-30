"""
請撰寫一程式，使用pandas將以下資料做成DataFrame
輸出小陳和小美的成績
將自然成績以遞減方式排序
輸出小黃的成績
"""

import pandas as pd

score = {"國語":[75,91,71,69],
         "數學":[62,53,88,53],
         "英語":[85,56,51,87],
         "自然":[73,63,69,74],
         "社會":[60,65,87,70]}

# 將score轉換成DataFrame
d1 = pd.DataFrame(score)

# 手動設定DataFrame的索引
d2 = pd.DataFrame(score, index=["小林","小黃","小陳","小美"])
print(d2)

# 顯示小陳和小美的成績
print("\n後二位的成績")
print(d2.tail(2))

# 將自然成績以遞減方式排序
print("\n以自然遞減排序")
d3 = d2.sort_values("自然", ascending=False)
print(d3.iloc[0:5:1,3:5:3])

# 輸出小黃的成績
print("\n小黃的成績")
print(d2.iloc[1])