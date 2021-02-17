from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.common.exceptions import NoSuchAttributeException,UnexpectedTagNameException
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.alert import Alert
from time import sleep
import os

dr = webdriver.Firefox()
dr.implicitly_wait(5)
file_path = 'file:///'+os.path.abspath('F:\\python\\FirstTest\\first\\views\\send.html')
dr.get(file_path)
# 点击请点击按钮
dr.find_element_by_xpath("/html/body/input").click()
sleep(3)
# 输入内容
dr.switch_to_alert().send_keys('张三')
# 确认警告
dr.switch_to_alert().accept()
sleep(5)
dr.quit()