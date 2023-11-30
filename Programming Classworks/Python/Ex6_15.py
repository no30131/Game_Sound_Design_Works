# 請撰寫一程式，請使用者輸入列數與欄數，每個字元寬度為4

row = int(input("請輸入列數："))
col = int(input("請輸入欄數："))
       
for i in range(0,row):
    for j in range(0,col):
        print(str(j-i).rjust(4), end=" ")
    print()
 