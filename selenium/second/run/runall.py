# -*- coding: utf-8 -*-
import unittest, csv
import os, sys
import time
# 导入testbaidu1，testbaidu2

from second import testbaidu1
from second import testbaidu2


# 手工添加案例到套件，
def createsuite():
    suite = unittest.TestSuite()
    # 将测试用例加入到测试容器（套件）中
    suite.addTest(testbaidu1.Baidu1("test_baidusearch"))
    suite.addTest(testbaidu1.Baidu1("test_hao"))
    suite.addTest(testbaidu2.Baidu2("test_baidusearch"))
    return suite

if __name__=="__main__":
     suite=createsuite()
     runner = unittest.TextTestRunner(verbosity=2)
     runner.run(suite)