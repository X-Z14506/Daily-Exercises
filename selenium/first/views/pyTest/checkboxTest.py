from selenium import webdriver
import time
import os

# 浏览器上是哪个复选框和两个单选框，定位这三个复选框
dr = webdriver.Firefox()
file_path = 'file:///' + os.path.abspath("F:\\python\\FirstTest\\first\\views\\checkbox.html")
dr.get(file_path)
# 选择页面上所有的input，然后从中过滤出所有的checkbox并勾选之
inputs = dr.find_elements_by_tag_name("input")
time.sleep(3)
for input in inputs:
    if input.get_attribute('type') == 'checkbox':
        input.click()
time.sleep(2)
dr.quit()