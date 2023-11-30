# -*- coding: utf-8 -*-
"""
請撰寫一程式，請使用者輸入身高與體重，計算出BMI值，
輸出至小數點第二位
◆ BMI公式：體重(公斤)/身高的平方(公尺的平方)
"""

height = float(input("請輸入身高："))
weight = float(input("請輸入體重："))
height_m = height / 100  #將輸入的公分除100，轉換成公尺
BMI = (weight/(height_m)**2)
print("\nBMI為：%.2f" %BMI) #輸出BMI值，並只顯示到小數點後二位