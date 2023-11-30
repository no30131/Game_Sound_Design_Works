# -*- coding: utf-8 -*-
"""
請撰寫一程式，請使用者輸入梯形的上底、下底與高，
並計算梯形面積
◆ 上底、下底與面積輸出結果到小數點第二位
◆ 梯形的高設定為整數
◆ 例：輸入上底12.7、下底21.37、高18，面積結果為306.36
"""

top = float(input("請輸入梯形的上底："))
bottom = float(input("請輸入梯形的下底："))
height = int(input("請輸入梯形的高："))

area = (top+bottom)*height/2
print("--------------")
print("上底：%.2f \n下底:%.2f \n高:%d" %(top, bottom, height))
print("梯形面積為：%.2f" %area)