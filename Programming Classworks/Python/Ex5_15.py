# 請撰寫一程式，請使用者輸入一正整數，判斷此正整數是否為4或7的倍數


num = eval(input("請輸入一個正整數："))

if (num % 7 == 0) and (num % 4 == 0):
    print("%d 是 4 和 7 的倍數" %num)
elif num % 7 == 0:
    print("%d 是 7 的倍數" %num)
elif num % 4 == 0:
    print("%d 是 4 的倍數" %num)
else:
    print("%d 不是 4 和 7 的倍數" %num)