from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.action_chains import ActionChains
import time
import os
dr = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath("F:\\python\\FirstTest\\first\\views\\level_locate.html")
dr.get(file_path)
# 点击link1连接（弹出下拉列表）
dr.find_element_by_link_text('Link1').click()
action = dr.find_element_by_link_text('Action')
ActionChains(dr).move_to_element(action).perform()
# 找到id为dropdown1的父元素
# WebDriverWait(dr, 10).until(lambda the_driver:
# the_driver.find_element_by_id('dropdown1').is_displayed())
# 在父亲元件下找到link 为Action 的子元素
# menu = dr.find_element_by_id('dropdown1').find_element_by_link_text('Action')
# 鼠标定位到子元素上
# webdriver.ActionChains(dr).move_to_element(menu).perform()

time.sleep(5)
dr.quit()

