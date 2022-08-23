from bs4 import BeautifulSoup
import os

def getTextColor(tag):
    return tag["android:textColor"]


def getParentBackgroundColor(tag):
    background = None
    for parent in tag.parents:
        if parent.has_attr("android:background"):
            background = parent["android:background"]
            break
    return background
os.chdir("../app/src/main/res/layout")

filename = "activity_main.xml"
Bs_data = BeautifulSoup(open(filename, 'r'), "xml")

b_unique = Bs_data.find('com.lyft.android.ui.DeprecatedButton')
print(b_unique. __dict__)
# if(len(b_unique) > 0):
#     print(filename,"is using DeprecatedButton", b_unique[0].tag)

# for tag in b_unique:
#     try:
#         x=1
# #         textColor = getTextColor(tag)
# #         parentBackground = getParentBackgroundColor(tag)
# #         print("TextColor", textColor)
# #         print("Parent Background", parentBackground)
#     except Exception as e:
#         print("error", e)