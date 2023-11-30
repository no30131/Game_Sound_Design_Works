"""
請用findl_all()函數找出全台水庫的名稱
"""

from bs4 import BeautifulSoup
import requests

# 水庫清單網址
url = "https://water.taiwanstat.com/"
# 先用requests請求回應
web = requests.get(url)

# 使用lxml解析器解析(需轉為text型式)
soup = BeautifulSoup(web.text, "lxml")

reservoir = soup.find_all("div", class_="name")

for row in reservoir:
    print(row.text)