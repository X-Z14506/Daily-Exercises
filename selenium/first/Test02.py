from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com")
time.sleep(5)

# 放大浏览器
driver.maximize_window()
time.sleep(3)

# 最小化浏览器
driver.minimize_window()
time.sleep(2)

# 设置浏览器界面的大小
driver.set_window_size(1000, 800)

# 打印title
title = driver.title
print(title)

# 打印url
url = driver.current_url
print(url)

time.sleep(6)
driver.quit()