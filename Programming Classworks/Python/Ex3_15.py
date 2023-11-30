# 請撰寫一程式，請使用者在指定的文章中輸出以下結果
# 1. 找尋「to」這個單字出現的次數
# 2. 找尋「want」第一次與最後一次的索引位置
# 3. 承上，請輸出兩個索引之間的字串

st = """There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real! Dream what you want to dream;go where you want to go; be what you want to be,because you have only one life and one chance to do all the things you want to do"""
    
print("to 出現的次數：", end="")
print(st.count("to"))

first = st.find("want")
print("want 第一次的索引位置：", end="")
print(first)

last = st.rfind("want")
print("want 最後一次索引位置：", end="")
print(last)

print("兩個索引之間的字串：")
print(st[first:last+5])