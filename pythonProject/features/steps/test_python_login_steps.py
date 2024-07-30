from behave import given, when, then
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.common.keys import Keys
from jproperties import Properties
import time

@given('the user is on the Flipkart login page')
def step_user_on_login_page(context):
    configs = Properties()
    with open("config.properties", "rb") as file:
        configs.load(file)
    context.driver = webdriver.Chrome()
    context.driver.get(f'{configs.get("link_login").data}')
    context.driver.maximize_window()
    context.wait = WebDriverWait(context.driver, 10)
    current_url = context.driver.current_url
    assert current_url == "https://www.flipkart.com/account/login?ret=/", "Wrong Page"

@when('the user enters an incorrect phone number')
def step_user_enters_phone_number(context):
    configs = Properties()
    with open("config.properties", "rb") as file:
        configs.load(file)
    otp_button = context.wait.until(ec.presence_of_element_located((By.XPATH,
        "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")))
    assert otp_button.is_displayed()

    placeholder = context.driver.find_element(By.XPATH,
        "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")
    placeholder.click()
    placeholder.send_keys(f'{configs.get("number").data}')
    placeholder.send_keys(Keys.RETURN)

@then('an error message should be displayed')
def step_error_message_displayed(context):
    error_message = context.driver.find_element(By.XPATH,
        "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/span[3]/span")
    print("Error is: " + error_message.text)
    context.driver.implicitly_wait(3)
    placeholder = context.driver.find_element(By.XPATH,
        "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")
    placeholder.clear()
    time.sleep(3)
    context.driver.quit()
