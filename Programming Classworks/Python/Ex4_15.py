# 請撰寫一程式，讓使用者輸入月份並判斷該月份為哪個季節
# ◆ 12-2月為冬天  ◆ 3-5月為春天
# ◆ 6-8月為夏天   ◆ 9-11月為秋天
# ◆ 其餘輸入請顯示超出範圍


try:
    month = int(input("請輸入月份(須為整數)："))
    if month in (9,10,11):
        print("%s月為秋天" %month)
    elif month in (6,7,8):
        print("%s月為夏天" %month)    
    elif month in (3,4,5):
        print("%s月為春天" %month)
    elif month in (12,1,2):
        print("%s月為冬天" %month)
    else: 
        print("超出範圍！") 
except:
    print("輸入錯誤！")