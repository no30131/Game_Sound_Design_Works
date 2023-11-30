"""
請撰寫一程式，請讀取youbike_immediate.json檔案，
並找出位於松山區的youbike站的第6~10筆資料
"""

import json

inf = r"C:\Users\USER\Desktop\youbike_immediate.json"

# 讀json檔
with open(inf, encoding="utf-8") as file:
    data = json.load(file)
    
# 將data裡「sarea」叫「松山區」的「sna」資料內容存到rdata列表
#rdata = []
for i in range(len(data)):
    if data[i]["sarea"] == "松山區":
        #rdata.append(data[i]["sna"])
        print(data[5:10]["sna"])



# 取出rdata第6~10筆資料
#for j in range(5, 10):
 #   print(rdata[j])
