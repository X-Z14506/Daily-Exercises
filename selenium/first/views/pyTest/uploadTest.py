from selenium import webdriver
import os
import time

driver = webdriver.Chrome()

# 脚本要与upload_file.html 同一目录
file_path = 'file:///' + os.path.abspath('F:\\python\\FirstTest\\first\\views\\upload.html')
driver.get(file_path)

# 定位上传按钮，添加本地文件
driver.find_element_by_name("file").send_keys('D:\\PycharmProjects\\test\\upload.txt')
time.sleep(2)
driver.quit()